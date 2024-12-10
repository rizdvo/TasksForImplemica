package org.example.task2;

import lombok.Data;


@Data
public class Road {
    private City city;
    private int cost;

    Road(City city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}
