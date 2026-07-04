package laba1;

public class Printer {
    public static void printNetMatrix(MatrixValue[][] pNet) {
        char[] labels = {'A', 'B', 'C', 'D', 'E', 'F'};

        System.out.print("   ");
        for (char label : labels) {
            System.out.printf("%-15c", label);
        }
        System.out.println("\n---------------------------------------------------------------------------------------------");

        for (int i = 0; i < pNet.length; i++) {
            System.out.print(labels[i] + " | ");
            for (int j = 0; j < pNet[i].length; j++) {
                if (pNet[i][j] == null) {
                    System.out.printf("%-15s", "[  no link  ]");
                } else {
                    System.out.printf("%-15s", pNet[i][j]);
                }
            }
            System.out.println();
        }
    }
}
