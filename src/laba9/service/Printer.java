package laba9.service;

import laba9.entity.Model;
import laba9.infrastructure.ComponentContext;
import laba9.infrastructure.Initializable;

import java.util.function.Consumer;

public class Printer implements Consumer<Model>, Initializable {
    @Override
    public void accept(Model model) {
        System.out.println(model.x + model.op + model.y + "=" + model.res);
    }

    @Override
    public void initialize(ComponentContext context) {

    }
}
