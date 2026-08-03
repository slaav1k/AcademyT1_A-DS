package laba5;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<int[]> convertMatrixToList(int[][] pMatrix) {
        ArrayList<int[]> edges = new ArrayList<>();
        int n = pMatrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pMatrix[i][j] == 1) {
                    edges.add(new int[] {i, j});
                }
            }
        }
        return edges;
    }
}
