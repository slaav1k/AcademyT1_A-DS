package laba13;

import laba13.model.Calculator;
import laba13.view.ConsoleReader;
import laba13.view.ConsoleWriter;
import laba13.viewmodel.CalculatorViewModel;
import laba13.infrastructure.ComponentContext;
import laba13.service.*;

public class Runner {
    public static void main(String[] args) {
        ComponentContext context = new ComponentContext();

        context.register(new PlusOperation());
        context.register(new MinusOperation());
        context.register(new Calculator());
        context.register(new CalculatorViewModel());
        context.register(new ConsoleWriter());

        ConsoleReader reader = new ConsoleReader();
        context.register(reader);

        reader.read();
    }
}
