package com.yubin.easy.part2;

import java.util.Comparator;
import java.util.List;

public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        employees.sort(Comparator.comparingInt(o -> o.importance));

        return 0;
    }

    class Employee {
        public int id;//id号
        public int importance;//自身的重要性
        public List<Integer> subordinates;//直系下属
    }
}
