package laba10.service;

import laba10.util.PersonNameFormater;
import laba10.entity.PersonRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonFileParser {
    private static final Pattern LINE_PATTERN = Pattern.compile("^\\s*(\\S+)\\s+(\\d+)\\s*$");

    public static Map<Integer, List<String>> process(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .parallel()
                    .map(LINE_PATTERN::matcher)
                    .filter(matcher -> matcher.matches())
                    .map(matcher -> new PersonRecord(Integer.parseInt(matcher.group(2)), PersonNameFormater.formatName(matcher.group(1))))
                    .collect(Collectors.groupingByConcurrent(PersonRecord::number, Collectors.mapping(PersonRecord::name, Collectors.toList())));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл: " + path, e);
        }
    }
}
