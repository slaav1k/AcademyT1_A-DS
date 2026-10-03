package laba13.view;

import laba13.entity.Model;
import laba13.infrastructure.Initializable;
import laba13.viewmodel.CalculatorViewModel;
import laba13.infrastructure.ComponentContext;

import java.util.Scanner;

public class ConsoleReader implements Initializable {
    private CalculatorViewModel viewModel;

    public void read() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите операцию и два числа через пробел (или 'f' для выхода): ");
            String input = sc.next();
            if ("f".equalsIgnoreCase(input)) break;

            Model model = new Model();
            model.op = input;
            model.x = sc.nextInt();
            model.y = sc.nextInt();

            viewModel.perform(model);
        }
    }

    @Override
    public void initialize(ComponentContext context) {
        this.viewModel = context.findComponents(CalculatorViewModel.class).get(0);
    }
}
