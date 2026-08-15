package laba5;


import java.util.*;

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

    public static ArrayList<Integer> topologicalSortTarjan(int[][] pMatrix) {
        int n = pMatrix.length;
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, pMatrix);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    private static void dfs(int pNode, boolean[] pVisited, Deque<Integer> pStack, int[][] pMatrix) {
        pVisited[pNode] = true;

        for (int otherNode = 0; otherNode < pMatrix.length; otherNode++) {
            if (pMatrix[pNode][otherNode] == 1 && !pVisited[otherNode]) {
                dfs(otherNode, pVisited, pStack, pMatrix);
            }
        }

        pStack.push(pNode);
    }

    public static ArrayList<Integer> topologicalSortKan(int[][] pMatrix) {
        int n = pMatrix.length;
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pMatrix[i][j] == 1) {
                    inDegree[j]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for (int otherNode = 0; otherNode < n; otherNode++) {
                if (pMatrix[node][otherNode] == 1) {
                    inDegree[otherNode]--;
                    if (inDegree[otherNode] == 0) {
                        queue.add(otherNode);
                    }
                }
            }
        }

        return res;
    }
}
