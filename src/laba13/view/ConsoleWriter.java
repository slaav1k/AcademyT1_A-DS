package laba13.view;

import laba13.entity.Model;
import laba13.infrastructure.Initializable;
import laba13.viewmodel.CalculatorViewModel;
import laba13.infrastructure.ComponentContext;

public class ConsoleWriter implements Initializable {
    private CalculatorViewModel viewModel;

    @Override
    public void initialize(ComponentContext context) {
        this.viewModel = context.findComponents(CalculatorViewModel.class).get(0);
        this.viewModel.subscribe("operation complete", this::write);
    }

    public void write() {
        Model m = viewModel.getCurData();
        if (m != null) {
            System.out.println("Результат: " + m.x + " " + m.op + " " + m.y + " = " + m.res);
        }
    }
}
