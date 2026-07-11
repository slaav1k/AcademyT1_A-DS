package laba2.tests;

import laba2.Result;
import laba2.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MinMaxTest {
    @Test
    public void mainTest() {
        List<Integer> lst = List.of(1, 2, 3, 4, 5);
        Result res = Solution.findMinMax(lst);
        Assert.assertEquals(res.min(), 1);
        Assert.assertEquals(res.max(), 5);
    }

    @Test
    public void evenElementsTest() {
        List<Integer> lst = List.of(10, 4, 2, 8, 25, 6);
        Result res = Solution.findMinMax(lst);
        Assert.assertEquals(res.min(), 2);
        Assert.assertEquals(res.max(), 25);
    }

    @Test
    public void twoElementsTest() {
        List<Integer> lst = List.of(50, -5);
        Result res = Solution.findMinMax(lst);
        Assert.assertEquals(res.min(), -5);
        Assert.assertEquals(res.max(), 50);
    }
}
