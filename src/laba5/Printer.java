package laba5;

import java.util.ArrayList;

public class Printer {
    public static void printListOfEdges(ArrayList<int[]> pEdges) {
        StringBuilder sb = new StringBuilder();
        int n = pEdges.size();
        for (int i = 0; i < n; i++) {
            int[] edge = pEdges.get(i);
            sb.append("(").append(edge[0]).append(", ").append(edge[1]).append(")");
            if (i != n - 1) {
                sb.append(" - ");
            }
        }
        System.out.println(sb);
    }
}
