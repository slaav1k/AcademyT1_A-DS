package laba13.tests;

import laba13.entity.Model;
import laba13.infrastructure.ComponentContext;
import laba13.model.Calculator;
import laba13.service.MinusOperation;
import laba13.service.PlusOperation;
import laba13.viewmodel.CalculatorViewModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Проверка базовой операции сложения")
    void testPlusOperation() {
        PlusOperation plus = new PlusOperation();
        Integer res = plus.apply(10, 20);
        assertEquals(30, res);
    }

    @Test
    @DisplayName("Проверка базовой операции вычитания")
    void testMinusOperation() {
        MinusOperation minus = new MinusOperation();
        Integer res = minus.apply(50, 15);
        assertEquals(35, res);
    }

    @Test
    @DisplayName("Проверка поиска компонентов через ComponentContext")
    void testComponentContextFindComponents() {
        ComponentContext context = new ComponentContext();
        context.register(new PlusOperation());
        context.register(new MinusOperation());

        List<BinaryOperator> ops = context.findComponents(BinaryOperator.class);

        assertEquals(2, ops.size());
    }

    @Test
    @DisplayName("Проверка выполнения операции сложения через MVVM ViewModel")
    void testViewModelPlusExecution() {
        ComponentContext context = new ComponentContext();

        Calculator calculator = new Calculator();
        context.register(new PlusOperation());
        context.register(new MinusOperation());
        context.register(calculator);

        CalculatorViewModel viewModel = new CalculatorViewModel();
        context.register(viewModel);

        Model model = new Model();
        model.op = "+";
        model.x = 15;
        model.y = 25;

        viewModel.perform(model);

        Model resultModel = viewModel.getCurData();
        assertNotNull(resultModel);
        assertEquals(40, resultModel.res);
    }

    @Test
    @DisplayName("Проверка выполнения операции вычитания через MVVM ViewModel")
    void testViewModelMinusExecution() {
        ComponentContext context = new ComponentContext();

        Calculator calculator = new Calculator();
        context.register(new PlusOperation());
        context.register(new MinusOperation());
        context.register(calculator);

        CalculatorViewModel viewModel = new CalculatorViewModel();
        context.register(viewModel);

        Model model = new Model();
        model.op = "-";
        model.x = 100;
        model.y = 40;

        viewModel.perform(model);

        Model resultModel = viewModel.getCurData();
        assertNotNull(resultModel);
        assertEquals(60, resultModel.res);
    }

    @Test
    @DisplayName("Проверка выброса исключения для неизвестной операции")
    void testUnknownOperationException() {
        ComponentContext context = new ComponentContext();

        Calculator calculator = new Calculator();
        context.register(new PlusOperation());
        context.register(calculator);

        CalculatorViewModel viewModel = new CalculatorViewModel();
        context.register(viewModel);

        Model model = new Model();
        model.op = "*";
        model.x = 5;
        model.y = 5;

        assertThrows(IllegalArgumentException.class, () -> {
            viewModel.perform(model);
        });
    }
}