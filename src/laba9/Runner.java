package laba9;

public class Runner {
    public static void main(String[] args) throws Exception {
        OperationMaker maker = new OperationMaker();
        maker.datareader = new DataReader();
        maker.printer = new Printer();
        maker.operations.put("-", new MinusOperation());
        maker.operations.put("+", new PlusOperation());
        maker.make();
    }
}
