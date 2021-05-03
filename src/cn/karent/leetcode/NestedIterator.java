package cn.karent.leetcode;

import java.util.*;

class NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() { return true;}

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() { return 0;}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() { return null;}

}

/**
 * 扁平化嵌套列表迭代器
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> data = new ArrayList<>();

    private int idx = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nest) {
        for(NestedInteger n : nest) {
            if( n.getInteger() != null) {
                data.add(n.getInteger());
            } else {
                dfs(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return data.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < data.size();
    }

}
