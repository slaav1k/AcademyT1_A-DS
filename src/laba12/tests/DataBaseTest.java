package laba12.tests;

import laba12.entity.DataBase;
import laba12.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {

    @Test
    @DisplayName("Проверка базового сохранения строки и получения в виде Integer через конвертер")
    void testBasicPutAndGet() {
        DataBase db = new DataBase();
        db.put("123");
        db.registerConverter(Integer.class, Integer::parseInt);

        Integer result = db.get(0, Integer.class);
        assertNotNull(result);
        assertEquals(123, result);
    }

    @Test
    @DisplayName("Проверка работы с множеством конвертеров и различными типами данных (Integer, String, Point)")
    void testMultipleConvertersAndTypes() {
        DataBase db = new DataBase();

        db.put(42);
        db.put("Hello, World!");
        db.put("3,7");

        db.registerConverter(Integer.class, Integer::valueOf);
        db.registerConverter(String.class, x -> x);
        db.registerConverter(Point.class, Point::parse);

        Integer intVal = db.get(0, Integer.class);
        String strVal = db.get(1, String.class);
        Point pointVal = db.get(2, Point.class);

        assertEquals(42, intVal);
        assertEquals("Hello, World!", strVal);
        assertEquals("3,7", pointVal.toString());
    }

    @Test
    @DisplayName("Проверка выброса исключения при попытке получить данные для незарегистрированного типа")
    void testUnregisteredConverterException() {
        DataBase db = new DataBase();
        db.put("Some data");

        assertThrows(IllegalArgumentException.class, () -> {
            db.get(0, Double.class);
        });
    }

    @Test
    @DisplayName("Проверка возможности мультиконвертации одного и того же индекса в разные типы")
    void testSameIndexDifferentConversions() {
        DataBase db = new DataBase();
        db.put("500");

        db.registerConverter(Integer.class, Integer::parseInt);
        db.registerConverter(String.class, s -> "Value: " + s);

        Integer asInt = db.get(0, Integer.class);
        String asFormattedStr = db.get(0, String.class);

        assertEquals(500, asInt);
        assertEquals("Value: 500", asFormattedStr);
    }
}