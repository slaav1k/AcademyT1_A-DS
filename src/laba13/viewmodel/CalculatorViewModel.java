package laba13.viewmodel;

import laba13.base.Observer;
import laba13.entity.Model;
import laba13.infrastructure.Initializable;
import laba13.model.Calculator;
import laba13.infrastructure.ComponentContext;

public class CalculatorViewModel extends Observer implements Initializable {
    private Calculator calculator;
    private Model currentModel;

    @Override
    public void initialize(ComponentContext context) {
        this.calculator = context.findComponents(Calculator.class).get(0);
        calculator.subscribe("result", this::updateResult);
    }

    private void updateResult() {
        if (currentModel != null) {
            currentModel.res = calculator.getResult();
            notify("operation complete");
        }
    }

    public Model getCurData() {
        return currentModel;
    }

    public void perform(Model model) {
        this.currentModel = new Model(model);
        calculator.makeOperation(model);
    }
}
