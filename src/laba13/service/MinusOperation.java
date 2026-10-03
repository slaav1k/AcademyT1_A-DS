package laba13.service;

import laba13.infrastructure.ComponentContext;
import laba13.infrastructure.Initializable;

import java.util.function.BinaryOperator;

public class MinusOperation implements BinaryOperator<Integer>, Initializable {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public void initialize(ComponentContext context) {

    }

    @Override
    public String toString() {
        return "-";
    }
}
