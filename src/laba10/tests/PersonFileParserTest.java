package laba10.tests;

import laba10.service.PersonFileParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonFileParserTest {

    @Test
    @DisplayName("Проверка обработки базового примера из задания")
    void testProcessExampleData(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("input_example.txt");
        List<String> inputLines = List.of(
                "вася 5",
                "Петя 3",
                "АНЯ 5",
                "Тото"
        );
        Files.write(tempFile, inputLines);

        Map<Integer, List<String>> result = PersonFileParser.process(tempFile);

        assertNotNull(result);
        assertEquals(2, result.size());

        assertTrue(result.containsKey(5));
        assertEquals(2, result.get(5).size());
        assertTrue(result.get(5).containsAll(List.of("Вася", "Аня")));

        assertTrue(result.containsKey(3));
        assertEquals(List.of("Петя"), result.get(3));

        assertFalse(result.values().stream().anyMatch(list -> list.contains("Тото")));
    }

    @Test
    @DisplayName("Проверка форматирования имен и отсеивания пустых/некорректных строк")
    void testNameFormattingAndValidation(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("input_extended.txt");
        List<String> inputLines = List.of(
                "   иван    10",
                "МАША 10",
                "оЛЕГ 10",
                "БезНомера",
                "   ",
                "НечисловойНомер abc"
        );
        Files.write(tempFile, inputLines);

        Map<Integer, List<String>> result = PersonFileParser.process(tempFile);

        assertEquals(1, result.size());
        assertTrue(result.containsKey(10));

        List<String> group10 = result.get(10);
        assertEquals(3, group10.size());
        assertTrue(group10.containsAll(List.of("Иван", "Маша", "Олег")));
    }

    @Test
    @DisplayName("Проверка выброса исключения при отсутствии файла")
    void testNonExistentFile() {
        Path nonExistentPath = Path.of("invalid_file_path_12345.txt");

        assertThrows(RuntimeException.class, () -> PersonFileParser.process(nonExistentPath));
    }
}