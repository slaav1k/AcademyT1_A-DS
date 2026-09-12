package laba10.util;

import java.util.Optional;

public class PersonNameFormater {
    public static String formatName(String rawName) {
        return Optional
                .ofNullable(rawName)
                .filter(s -> !s.isEmpty())
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .orElse(rawName);
    }
}
