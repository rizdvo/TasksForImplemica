package org.example.task2;

import lombok.Data;

import java.util.*;

@Data
public class Connection {

    private List<City> cities;           // List of cities
    private Map<String, City> cityMap;   // Map for quick city lookup by name

    Connection() {
        this.cities = new ArrayList<>();
        this.cityMap = new HashMap<>();
    }

    // Adds a new city to the network
    void addCity(String name) {
        City city = new City(name, cities.size());
        cityMap.put(name, city);
        cities.add(city);
    }

    // Adds a road between two cities with a given cost
    void addRoad(String cityName, String neighborName, int cost) {
        City city = cityMap.get(cityName);
        City neighbor = cityMap.get(neighborName);
        city.addNeighbor(neighbor, cost);
    }

    // Finds the minimum cost to travel between two cities using Dijkstra's algorithm
    int findMinCost(String sourceCityName, String destinationCityName) {
        City sourceCity = cityMap.get(sourceCityName);
        City destinationCity = cityMap.get(destinationCityName);

        // Priority queue to explore cities with the lowest cost first
        PriorityQueue<Road> priorityRoads = new PriorityQueue<>(Comparator.comparingInt(Road::getCost));
        Map<City, Integer> minCosts = new HashMap<>();

        // Initialize all cities with infinite cost except the source city
        for (City city : cities) {
            minCosts.put(city, Integer.MAX_VALUE);
        }
        minCosts.put(sourceCity, 0);
        priorityRoads.add(new Road(sourceCity, 0));

        // Dijkstra's algorithm to find the minimum cost path
        while (!priorityRoads.isEmpty()) {
            Road current = priorityRoads.poll();
            City currentCity = current.getCity();
            int currentCost = current.getCost();

            // Skip if a cheaper path to this city has already been found
            if (currentCost > minCosts.get(currentCity)) continue;

            // Explore neighboring cities
            for (Map.Entry<City, Integer> entry : currentCity.neighbors.entrySet()) {
                City neighbor = entry.getKey();
                int roadCost = entry.getValue();
                int newCost = currentCost + roadCost;

                // Update cost if a cheaper path to the neighbor is found
                if (newCost < minCosts.get(neighbor)) {
                    minCosts.put(neighbor, newCost);
                    priorityRoads.add(new Road(neighbor, newCost));
                }
            }
        }

        return minCosts.get(destinationCity); // Return the minimum cost to reach the destination city
    }
}
