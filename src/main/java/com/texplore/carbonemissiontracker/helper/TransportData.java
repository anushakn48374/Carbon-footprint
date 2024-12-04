package com.texplore.carbonemissiontracker.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransportData {

    private static final Map<String, List<Integer>> transModeMap = new HashMap<>();

    static {
        transModeMap.put("Car - Petrol", Arrays.asList(190, 0));
        transModeMap.put("Car - Diesel", Arrays.asList(150, 0));
        transModeMap.put("Car - Electric", Arrays.asList(25, 0));
        transModeMap.put("Bike", Arrays.asList(100, 0));
        transModeMap.put("Bus / Metro", Arrays.asList(80, 0));
        transModeMap.put("Cycle", Arrays.asList(0, 10));
        transModeMap.put("Walk", Arrays.asList(0, 20));
    }

    public static List<Integer> getTransMode(String transMode) {
        return transModeMap.get(transMode);
    }
}
