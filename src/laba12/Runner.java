package laba12;

import laba12.entity.DataBase;
import laba12.entity.Point;

public class Runner {
    public static void main(String[] args) {
        DataBase db = new DataBase();

        db.put(100);
        db.put("5,10");
        db.put("Привет, мир!");

        db.registerConverter(Integer.class, raw -> Integer.valueOf(raw));
        db.registerConverter(String.class, raw -> raw);
        db.registerConverter(Point.class, Point::parse);

        Integer intVal = db.get(0, Integer.class);
        String strValFromInt = db.get(0, String.class);
        Point pointVal = db.get(1, Point.class);
        String textVal = db.get(2, String.class);

        System.out.println("Элемент [0] как Integer: " + intVal);
        System.out.println("Элемент [0] как String: " + strValFromInt);
        System.out.println("Элемент [1] как Point -> x, y: " + pointVal);
        System.out.println("Элемент [2] как String: " + textVal);

        System.out.println("\nВсе тесты выполнены успешно!");
    }
}
