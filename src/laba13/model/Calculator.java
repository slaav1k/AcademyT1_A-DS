package laba13.model;

import laba13.base.Observer;
import laba13.entity.Model;
import laba13.infrastructure.Initializable;
import laba13.infrastructure.ComponentContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Calculator extends Observer implements Initializable {
    private Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
    private int result;

    public void makeOperation(Model model) {
        BinaryOperator<Integer> operator = operations.get(model.op);
        if (operator == null) {
            throw new IllegalArgumentException("Неизвестная операция: " + model.op);
        }
        this.result = operator.apply(model.x, model.y);
        notify("result");
    }

    public int getResult() {
        return result;
    }

    @Override
    public void initialize(ComponentContext context) {
        List<BinaryOperator> ops = context.findComponents(BinaryOperator.class);
        this.operations = ops.stream()
                .collect(Collectors.toMap(
                        Object::toString,
                        op -> (BinaryOperator<Integer>) op
                ));
    }
}
