package laba4;

import laba3.ItemOfList;
import laba3.MyLinkedList;

public class Runner {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        // Добавление и размер
        ItemOfList<String> b = list.pushFront("B");
        ItemOfList<String> a = list.pushFront("A");
        ItemOfList<String> d = list.pushBack("D");
        ItemOfList<String> c = list.insertAfter(b, "C");
        System.out.println("Список: " + list + " (Размер: " + list.size() + ")");

        // Чтение, замена и поиск
        System.out.println("Значение b: " + list.getValue(b));
        list.update(c, "NewC");
        System.out.println("После update: " + list);
        System.out.println("Индекс 'NewC': " + list.findIndex("NewC"));
        System.out.println("Содержит 'A'? " + list.contains("A"));
        System.out.println("Поиск ноды 'D': " + (list.findItem("D") == d));

        // Удаление
        list.removeAt(b);
        System.out.println("После removeAt: " + list);
        list.popFront();
        System.out.println("После popFront: " + list);
        list.popBack();
        System.out.println("После popBack: " + list);
    }
}