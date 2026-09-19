package laba12.entity;

import laba12.service.RowConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    private final List<String> storage = new ArrayList<>();

    private final Map<Class<?>, RowConverter<?>> registry = new HashMap<>();

    public void put(Object item) {
        if (item != null) {
            storage.add(item.toString());
        } else {
            storage.add(null);
        }
    }

    public <T> void registerConverter(Class<T> targetClass, RowConverter<T> converter) {
        registry.put(targetClass, converter);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(int index, Class<T> targetClass) {
        String rawValue = storage.get(index);
        RowConverter<?> converter = registry.get(targetClass);

        if (converter == null) {
            throw new IllegalArgumentException("Конвертер для типа " + targetClass.getName() + " не зарегистрирован.");
        }

        return (T) converter.convert(rawValue);
    }
}
