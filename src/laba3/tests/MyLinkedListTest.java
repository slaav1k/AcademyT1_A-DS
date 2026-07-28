package laba3.tests;

import laba3.ItemOfList;
import laba3.MyLinkedList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyLinkedListTest {

    @Test
    public void testEmptyList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Assert.assertEquals(list.size(), 0);
        Assert.assertEquals(list.toString(), "[]");
        Assert.assertFalse(list.contains(10));
        Assert.assertEquals(list.findIndex(10), -1);
        Assert.assertNull(list.findItem(10));

        list.popFront();
        list.popBack();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void testPushAndInsertAfter() {
        MyLinkedList<String> list = new MyLinkedList<>();

        ItemOfList<String> b = list.pushFront("B");
        Assert.assertEquals(list.toString(), "[B]");

        ItemOfList<String> a = list.pushFront("A");
        Assert.assertEquals(list.toString(), "[A, B]");

        ItemOfList<String> d = list.pushBack("D");
        Assert.assertEquals(list.toString(), "[A, B, D]");

        list.insertAfter(b, "C");
        Assert.assertEquals(list.toString(), "[A, B, C, D]");

        list.insertAfter(d, "E");
        Assert.assertEquals(list.toString(), "[A, B, C, D, E]");
        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void testPushBackOnEmpty() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.pushBack("Solo");
        Assert.assertEquals(list.toString(), "[Solo]");
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void testGetAndUpdate() {
        MyLinkedList<String> list = new MyLinkedList<>();
        ItemOfList<String> node = list.pushBack("X");

        Assert.assertEquals(list.getValue(node), "X");
        list.update(node, "Y");
        Assert.assertEquals(list.getValue(node), "Y");
    }

    @Test
    public void testSearchMethods() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.pushBack("1");
        ItemOfList<String> target = list.pushBack("2");
        list.pushBack("3");
        list.pushBack("2");

        Assert.assertTrue(list.contains("2"));
        Assert.assertFalse(list.contains("4"));
        Assert.assertEquals(list.findIndex("2"), 1);
        Assert.assertEquals(list.findIndex("4"), -1);
        Assert.assertSame(list.findItem("2"), target);
        Assert.assertNull(list.findItem("4"));
    }

    @Test
    public void testPops() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        list.popFront();
        Assert.assertEquals(list.toString(), "[2, 3]");

        list.popBack();
        Assert.assertEquals(list.toString(), "[2]");

        list.popFront();
        Assert.assertEquals(list.toString(), "[]");
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void testRemoveAt() {
        MyLinkedList<String> list = new MyLinkedList<>();
        ItemOfList<String> n1 = list.pushBack("1");
        ItemOfList<String> n2 = list.pushBack("2");
        ItemOfList<String> n3 = list.pushBack("3");

        list.removeAt(n2);
        Assert.assertEquals(list.toString(), "[1, 3]");

        list.removeAt(n1);
        Assert.assertEquals(list.toString(), "[3]");

        list.removeAt(n3);
        Assert.assertEquals(list.toString(), "[]");
        Assert.assertEquals(list.size(), 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInsertAfterNull() {
        new MyLinkedList<String>().insertAfter(null, "Err");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRemoveAtNull() {
        new MyLinkedList<String>().removeAt(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetValueNull() {
        new MyLinkedList<String>().getValue(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testUpdateNull() {
        new MyLinkedList<String>().update(null, "Err");
    }
}