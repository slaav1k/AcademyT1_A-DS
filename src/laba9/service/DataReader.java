package laba9.service;

import laba9.entity.Model;
import laba9.infrastructure.ComponentContext;
import laba9.infrastructure.Initializable;

import java.util.Scanner;
import java.util.function.Supplier;

public class DataReader implements Supplier<Model>, Initializable {
    @Override
    public Model get() {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите операцию и два числа через пробел: ");
        model.op = sc.next();
        model.x = sc.nextInt();
        model.y = sc.nextInt();
        return model;
    }

    @Override
    public void initialize(ComponentContext context) {

    }
}
