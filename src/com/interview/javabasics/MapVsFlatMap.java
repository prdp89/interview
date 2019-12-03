package com.interview.javabasics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//https://stackoverflow.com/questions/26684562/whats-the-difference-between-map-and-flatmap-methods-in-java-8
public class MapVsFlatMap {

    private String name;
    private List<String> items;

    private MapVsFlatMap( String name, String... items ) {
        this.name = name;
        this.items = Arrays.asList(items);
    }

    public static void main( String[] args ) {
        MapVsFlatMap amazon = new MapVsFlatMap("amazon", "Laptop", "Phone");
        MapVsFlatMap ebay = new MapVsFlatMap("ebay", "Mouse", "Keyboard");
        List<MapVsFlatMap> parcels = Arrays.asList(amazon, ebay);

        System.out.println("-------- Without flatMap() ---------------------------");
        List<List<String>> mapReturn = parcels.stream()
                .map(MapVsFlatMap::getItems)
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + mapReturn);

        System.out.println("\n-------- With flatMap() ------------------------------");
        List<String> flatMapReturn = parcels.stream()
                .map(MapVsFlatMap::getItems)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + flatMapReturn);
    }

    public List<String> getItems() {
        return items;
    }
}
