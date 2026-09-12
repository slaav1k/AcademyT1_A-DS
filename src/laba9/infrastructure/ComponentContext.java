package laba9.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class ComponentContext {
    private final List<Object> components = new ArrayList<>();

    public void register(Object component) {
        if (component instanceof Initializable initializable) {
            initializable.initialize(this);
        }
        components.add(component);
    }

    public <T> List<T> findComponents(Class<T> requiredType) {
        return components.stream()
                .filter(requiredType::isInstance)
                .map(requiredType::cast)
                .toList();
    }
}
