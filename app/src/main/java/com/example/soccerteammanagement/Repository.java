package com.example.soccerteammanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T extends SoccerEntity> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public void remove(T item) {
        if (!items.remove(item)) {
            throw new IllegalArgumentException("Item not found in repository");
        }
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public List<T> filter(Predicate<T> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate cannot be null");
        }
        return items.stream().filter(predicate).collect(Collectors.toList());
    }
}

