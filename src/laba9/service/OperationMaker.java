package laba9.service;

import laba9.entity.Model;
import laba9.infrastructure.ComponentContext;
import laba9.infrastructure.Initializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OperationMaker implements Initializable {
    private Supplier<Model> datareader;
    private Consumer<Model> printer;
    private Map<String, BinaryOperator<Integer>> operations = new HashMap<>();

    public void make() {
        Model model = datareader.get();
        BinaryOperator<Integer> operator = operations.get(model.op);
        if (operator == null) {
            throw new IllegalArgumentException("Неизвестная операция: " + model.op);
        }
        model.res = operator.apply(model.x, model.y);
        printer.accept(model);
    }

    @Override
    public void initialize(ComponentContext context) {
        this.datareader = context.findComponents(Supplier.class).get(0);
        this.printer = context.findComponents(Consumer.class).get(0);

        List<BinaryOperator> ops = context.findComponents(BinaryOperator.class);
        this.operations = ops.stream()
                .collect(Collectors.toMap(
                        Object::toString,
                        op -> (BinaryOperator<Integer>) op
                ));
    }
}
