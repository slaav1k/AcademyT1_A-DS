package laba5;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                new int[] {0, 1, 1, 0},
                new int[] {1, 0, 1, 1},
                new int[] {1, 1, 0, 0},
                new int[] {0, 0, 0, 0}
        };
        Printer.printListOfEdges(Solution.convertMatrixToList(matrix));

        int[][] matrix2 = new int[][] {
                new int[] {0, 1, 0, 0},
                new int[] {0, 0, 1, 0},
                new int[] {0, 0, 0, 1},
                new int[] {0, 0, 0, 0}
        };
        System.out.println(Solution.topologicalSortTarjan(matrix2));
        System.out.println(Solution.topologicalSortKan(matrix2));
    }
}