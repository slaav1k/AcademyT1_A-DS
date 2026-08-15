package laba5.tests;

import laba5.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class GraphConvertAndSortTest {

    @Test
    public void testConvertMatrixToListEmpty() {
        int[][] m = {};
        Assert.assertEquals(Solution.convertMatrixToList(m).size(), 0);
    }

    @Test
    public void testConvertMatrixToListSimple() {
        int[][] m = {
                {0,1,0},
                {0,0,1},
                {0,0,0}
        };

        ArrayList<int[]> edges = Solution.convertMatrixToList(m);

        Assert.assertEquals(edges.size(), 2);
        Assert.assertTrue(containsEdge(edges, 0, 1));
        Assert.assertTrue(containsEdge(edges, 1, 2));
    }

    @Test
    public void testConvertMatrixToListFull() {
        int[][] m = {
                {0,1},
                {1,0}
        };

        ArrayList<int[]> edges = Solution.convertMatrixToList(m);

        Assert.assertEquals(edges.size(), 2);
        Assert.assertTrue(containsEdge(edges, 0, 1));
        Assert.assertTrue(containsEdge(edges, 1, 0));
    }

    @Test
    public void testTopologicalSortTarjanSimple() {
        int[][] m = {
                {0,1,0},
                {0,0,1},
                {0,0,0}
        };

        List<Integer> expected = Arrays.asList(0,1,2);
        List<Integer> res = Solution.topologicalSortTarjan(m);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testTopologicalSortTarjanBranching() {
        int[][] m = {
                {0,1,1,0},
                {0,0,0,1},
                {0,0,0,1},
                {0,0,0,0}
        };

        List<Integer> expected = Arrays.asList(0,2,1,3);
        List<Integer> res = Solution.topologicalSortTarjan(m);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testTopologicalSortTarjanNoEdges() {
        int[][] m = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        List<Integer> expected = Arrays.asList(2,1,0);
        List<Integer> res = Solution.topologicalSortTarjan(m);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testTopologicalSortKanSimple() {
        int[][] m = {
                {0,1,0},
                {0,0,1},
                {0,0,0}
        };

        List<Integer> expected = Arrays.asList(0,1,2);
        List<Integer> res = Solution.topologicalSortKan(m);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testTopologicalSortKanBranching() {
        int[][] m = {
                {0,1,1,0},
                {0,0,0,1},
                {0,0,0,1},
                {0,0,0,0}
        };

        List<Integer> expected = Arrays.asList(0,1,2,3);
        List<Integer> res = Solution.topologicalSortKan(m);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testTopologicalSortKanMultipleComponents() {
        int[][] m = {
                {0,1,0,0},
                {0,0,0,0},
                {0,0,0,1},
                {0,0,0,0}
        };

        List<Integer> expected = Arrays.asList(0,2,1,3);
        List<Integer> res = Solution.topologicalSortKan(m);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testTopologicalSortKanCycle() {
        int[][] m = {
                {0,1,0},
                {0,0,1},
                {1,0,0}
        };

        List<Integer> res = Solution.topologicalSortKan(m);

        Assert.assertNotEquals(res.size(), 3);
    }

    @Test
    public void testTopologicalSortKanSelfLoop() {
        int[][] m = {
                {1,0},
                {0,0}
        };

        List<Integer> res = Solution.topologicalSortKan(m);

        Assert.assertNotEquals(res.size(), 2);
    }

    private boolean containsEdge(ArrayList<int[]> edges, int u, int v) {
        for (int[] e : edges) {
            if (e[0] == u && e[1] == v) {
                return true;
            }
        }
        return false;
    }
}