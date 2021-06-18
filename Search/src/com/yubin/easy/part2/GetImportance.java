package com.yubin.easy.part2;

import java.util.*;

public class GetImportance {
    private Map<Integer, Employee> map = null;
    private int importance1 = 0;

    /**
     * dfs求解
     */
    public int getImportance1(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        importance1 = 0;
        getImportance1(id);
        return importance1;
    }

    private void getImportance1(int id) {
        Employee e = map.get(id);
        importance1 += e.importance;
        for (Integer subordinate : e.subordinates) {
            getImportance1(subordinate);
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportance(id);
    }

    /**
     * 基于队列的bfs
     */
    private int getImportance(int id) {
        int importance = 0;
        Employee e = map.get(id);
        importance += e.importance;
        Deque<Employee> list = new LinkedList<>();
        list.add(e);
        while (true) {
            int size = list.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                List<Integer> employeeId = list.removeFirst().subordinates;
                for (Integer integer : employeeId) {
                    count++;
                    Employee employee = map.get(integer);
                    list.add(employee);
                    importance += employee.importance;
                }
            }
            if (count == 0) return importance;
        }
    }

    class Employee {
        public int id;//id号
        public int importance;//自身的重要性
        public List<Integer> subordinates;//直系下属
    }
}