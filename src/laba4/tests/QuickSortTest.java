package laba4.tests;

import laba4.QuickSort;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuickSortTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{});
    }

    @Test
    public void testSingleElement() {
        int[] arr = {1};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{1});
    }

    @Test
    public void testTwoElements() {
        int[] arr = {2, 1};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{1, 2});
    }

    @Test
    public void testAllEqual() {
        int[] arr = {5, 5, 5, 5};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{5, 5, 5, 5});
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testWithDuplicates() {
        int[] arr = {3, 1, 2, 3, 1, 2};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{1, 1, 2, 2, 3, 3});
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = {-3, 5, -1, 0, 2};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{-3, -1, 0, 2, 5});
    }

    @Test
    public void testLargeNumbers() {
        int[] arr = {1000, -500, 42, 0, 999};
        QuickSort.quickSort(arr);
        Assert.assertEquals(arr, new int[]{-500, 0, 42, 999, 1000});
    }
}