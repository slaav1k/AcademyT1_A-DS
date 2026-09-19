package laba10;

import laba10.service.PersonFileParser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) throws Exception {
        Path tempFile = Files.createTempFile("people_data", ".txt");
        tempFile.toFile().deleteOnExit();

        List<String> inputData = List.of(
                "вася 5",
                "Петя 3",
                "АНЯ 5",
                "Тото"
        );
        Files.write(tempFile, inputData);

        System.out.println("Содержимое файла:");
        for (String line : inputData) {
            System.out.println(line);
        }

        Map<Integer, List<String>> result = PersonFileParser.process(tempFile);

        System.out.println("\nРезультат");
        System.out.println(result);
    }
}