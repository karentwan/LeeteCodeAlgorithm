package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 员工的重要性
 * @author wan
 * @date 2021.05.01
 ********************************************/
public class LeetCode690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    
    private int dfs(Employee emp, Map<Integer,Employee> map) {
        int ret = emp.importance;
        for (Integer es : emp.subordinates) {
            ret += dfs(map.get(es), map);
        }
        return ret;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return dfs(map.get(id), map);
    }

    public static void main(String[] args) {

    }

}
