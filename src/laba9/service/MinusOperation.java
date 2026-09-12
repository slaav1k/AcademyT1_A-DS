package laba9.service;

import laba9.infrastructure.ComponentContext;
import laba9.infrastructure.Initializable;

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
