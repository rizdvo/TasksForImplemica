package org.example.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bogda\\IdeaProjects\\TasksForImplemica\\src\\main\\resources\\task2.txt"));


        int testCases = Integer.parseInt(reader.readLine());

        // Process each test case
        while (testCases-- > 0) {
            Connection connection = new Connection();

            // Read the number of cities for the current test case
            int citiesCount = Integer.parseInt(reader.readLine());

            // Read city names and their neighbors (but not the road data yet)
            for (int i = 0; i < citiesCount; i++) {
                String cityName = reader.readLine();
                connection.addCity(cityName);
                int numNeighbors = Integer.parseInt(reader.readLine());
                for (int j = 0; j < numNeighbors; j++) {
                    reader.readLine();  // Skip neighbor data (not used here)
                }
            }

            // Reinitialize reader to read the road data after city data
            reader = new BufferedReader(new FileReader("C:\\Users\\bogda\\IdeaProjects\\TasksForImplemica\\src\\main\\resources\\task2.txt"));
            reader.readLine();
            reader.readLine();

            // Read road data for each city
            for (int i = 0; i < citiesCount; i++) {
                String cityName = reader.readLine();  // Read city name
                int numNeighbors = Integer.parseInt(reader.readLine());  // Read number of neighbors
                for (int j = 0; j < numNeighbors; j++) {
                    // Read road data (neighbor index and cost)
                    String[] roadData = reader.readLine().split(" ");
                    int neighborIndex = Integer.parseInt(roadData[0]) - 1;  // Get neighbor index (adjust for 0-based indexing)
                    int cost = Integer.parseInt(roadData[1]);
                    // Add the road (with cost) between the cities
                    connection.addRoad(cityName, connection.getCities().get(neighborIndex).name, cost);
                }
            }

            // Read the number of paths for which to calculate minimum cost
            int numPaths = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numPaths; i++) {
                // Read start and end city names
                String[] pathData = reader.readLine().split(" ");
                String startCity = pathData[0];
                String endCity = pathData[1];

                // Calculate and print the minimum cost between the cities
                int cost = connection.findMinCost(startCity, endCity);
                System.out.println(cost);  // Output the result
            }

            // If there is another test case, move to the next line
            if (reader.ready()) reader.readLine();
        }


        reader.close();
    }
}
