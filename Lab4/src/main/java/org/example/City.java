package org.example;


import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.Edge;
import java.util.Collection;

import java.util.*;

import org.graph4j.spanning.WeightedSpanningTreeIterator;

public class City {
    private String name;
    Set<Intersection> intersections = new HashSet<>();
    List<Street> streets = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addStreet(Street street){
        streets.add(street);
        intersections.add(street.getA());
        intersections.add(street.getB());
    }

    public int connectingStreets(Street target){
        int count = 0;
        for(Street s : this.streets){
            if(s.equals(target)) continue;

            if(s.getA().equals(target.getA()) || s.getB().equals(target.getA())
                || s.getA().equals(target.getB()) || s.getB().equals(target.getB())){
                count++;
            }
        }
        return count;
    }

    public void longer3(){
        this.streets.stream()
                .filter(street -> street.getLength() > 10)
                .filter(street -> this.connectingStreets(street) >= 3)
                .forEach(street -> System.out.println(street.getName()));
    }

    public Set<Intersection> getIntersections() {
        return intersections;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public String getName() {
        return name;
    }

    public void minimumCostSolution(int k){
        Map<Intersection, Integer> intersectionId = new HashMap<>();
        int id = 0;
        for(Intersection inter : this.getIntersections()){
            intersectionId.put(inter, id++);
        }

        Graph cityGraph = GraphBuilder.numVertices(this.getIntersections().size()).buildGraph();

        for(Street street : this.getStreets()){
            int aID = intersectionId.get(street.getA());
            int bID = intersectionId.get(street.getB());
            double weight = street.getLength();

            cityGraph.addEdge(aID, bID, weight);
        }

        WeightedSpanningTreeIterator iterator = new WeightedSpanningTreeIterator(cityGraph);

        int count = 1;
        while(iterator.hasNext() && count <= k){
            Collection<Edge> spanningTree = iterator.next();
            double totalCost = 0;

            for(Edge edge : spanningTree){
                totalCost += edge.weight();
            }
            System.out.println(totalCost);

            count++;
        }
    }


    @Override
    public String toString() {
        return "City name: " + name + "\n" +
                "Intersections: " + intersections + "\n" +
                "Streets: " + streets;
    }
}
