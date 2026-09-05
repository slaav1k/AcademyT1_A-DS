package laba9.tests;

import laba9.entity.Model;
import laba9.infrastructure.ComponentContext;
import laba9.service.MinusOperation;
import laba9.service.OperationMaker;
import laba9.service.PlusOperation;
import laba9.service.Printer;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CalculatorTest {

    @Test
    public void testPlusOperation() {
        PlusOperation plus = new PlusOperation();
        Integer res = plus.apply(10, 20);
        Assert.assertEquals(res, Integer.valueOf(30));
    }

    @Test
    public void testMinusOperation() {
        MinusOperation minus = new MinusOperation();
        Integer res = minus.apply(50, 15);
        Assert.assertEquals(res, Integer.valueOf(35));
    }

    @Test
    public void testComponentContextFindComponents() {
        ComponentContext context = new ComponentContext();
        context.register(new PlusOperation());
        context.register(new MinusOperation());

        List<BinaryOperator> ops = context.findComponents(BinaryOperator.class);

        Assert.assertEquals(ops.size(), 2);
    }

    @Test
    public void testOperationMakerDependencyPullAndExecution() {
        ComponentContext context = new ComponentContext();

        Supplier<Model> mockDataReader = () -> {
            Model m = new Model();
            m.op = "+";
            m.x = 15;
            m.y = 25;
            return m;
        };

        final Model[] resultContainer = new Model[1];
        Consumer<Model> mockPrinter = model -> resultContainer[0] = model;

        context.register(new PlusOperation());
        context.register(new MinusOperation());
        context.register(mockDataReader);
        context.register(mockPrinter);

        OperationMaker maker = new OperationMaker();
        context.register(maker);

        maker.make();

        Assert.assertNotNull(resultContainer[0]);
        Assert.assertEquals(resultContainer[0].res, 40);
    }

    @Test
    public void testOperationMakerMinusExecution() {
        ComponentContext context = new ComponentContext();

        Supplier<Model> mockDataReader = () -> {
            Model m = new Model();
            m.op = "-";
            m.x = 100;
            m.y = 40;
            return m;
        };

        final Model[] resultContainer = new Model[1];
        Consumer<Model> mockPrinter = model -> resultContainer[0] = model;

        context.register(new PlusOperation());
        context.register(new MinusOperation());
        context.register(mockDataReader);
        context.register(mockPrinter);

        OperationMaker maker = new OperationMaker();
        context.register(maker);

        maker.make();

        Assert.assertNotNull(resultContainer[0]);
        Assert.assertEquals(resultContainer[0].res, 60);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testUnknownOperationException() {
        ComponentContext context = new ComponentContext();

        Supplier<Model> mockDataReader = () -> {
            Model m = new Model();
            m.op = "*";
            m.x = 5;
            m.y = 5;
            return m;
        };

        context.register(new PlusOperation());
        context.register(mockDataReader);
        context.register(new Printer());

        OperationMaker maker = new OperationMaker();
        context.register(maker);

        maker.make();
    }
}