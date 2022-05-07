package com.tomhydra.a2sv.leetcode.dfs._690_employee_importance;

import java.util.*;

public class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee empl : employees) {
            map.put(empl.id, empl);
        }
        visited = new HashSet<>();
        return getImportance(id);
    }
    
    private int getImportance(int id) {
        Employee employee = map.get(id);
        int importance = employee.importance;
        visited.add(id);
        for (int subordinateId : employee.subordinates) {
            if (!visited.contains(subordinateId)) {
                importance += getImportance(subordinateId);
            }
        }
        return importance;
    }
}


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


