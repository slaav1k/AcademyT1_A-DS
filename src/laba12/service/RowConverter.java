package laba12.service;

@FunctionalInterface
    public interface RowConverter<T> {
        T convert(String rawData);
    }
