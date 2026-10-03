package laba13.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Observer {
    private final Map<String, List<Action>> observers = new HashMap<>();

    public void subscribe(String event, Action a) {
        if (a == null) return;
        List<Action> actions = observers.computeIfAbsent(event, x -> new ArrayList<>());
        actions.add(a);
    }

    public void notify(String event) {
        List<Action> actions = observers.get(event);
        if (actions == null || actions.isEmpty()) return;
        for (Action a : actions) a.invoke();
    }
}
