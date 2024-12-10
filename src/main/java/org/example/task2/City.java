package org.example.task2;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class City {
    int index;
    String name;
    Map<City, Integer> neighbors;

    City(String name, int index) {
        this.name = name;
        this.index = index;
        this.neighbors = new HashMap<>();
    }

    void addNeighbor(City city, int cost) {
        neighbors.put(city, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

