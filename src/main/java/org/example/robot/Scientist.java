package org.example.robot;

import java.util.EnumMap;
import java.util.Map;

public class Scientist {

    private final Map<Detail, Integer> storage = new EnumMap<>(Detail.class);

    public void addDetail(Detail detail) {
        storage.merge(detail, 1, Integer::sum);
    }

    public int getCountOfRobots() {
        return storage.values().stream()
                .sorted()
                .toList()
                .getFirst();
    }
}