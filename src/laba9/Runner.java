package laba9;

import laba9.infrastructure.ComponentContext;
import laba9.service.*;

public class Runner {
    public static void main(String[] args) throws Exception {
        ComponentContext context = new ComponentContext();
        context.register(new PlusOperation());
        context.register(new MinusOperation());
        context.register(new DataReader());
        context.register(new Printer());

        OperationMaker maker = new OperationMaker();
        context.register(maker);

        maker.make();
    }
}
