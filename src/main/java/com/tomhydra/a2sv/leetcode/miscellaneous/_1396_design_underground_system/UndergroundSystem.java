package com.tomhydra.a2sv.leetcode.miscellaneous._1396_design_underground_system;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class UndergroundSystem {
    Map<Integer, Pair<Integer, String>> checkIns = new HashMap<>();
    Map<String, int[]> average = new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new ImmutablePair<>(t, stationName));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<Integer, String> pair = checkIns.get(id);
        int[] arr = average.computeIfAbsent(pair.getValue() + "-" + stationName, k -> new int[2]);
        arr[0] += 1;
        arr[1] += (t - pair.getKey());
        checkIns.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] av = average.get(startStation + "-" + endStation);
        return (double)av[1] / av[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */