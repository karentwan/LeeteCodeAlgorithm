package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 扁平化嵌套列表迭代器
 */
public class NestedIterator implements Iterator<Integer>{

public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

    private List<Integer> data = new ArrayList<>();

    private int idx = 0;

    private void dfs(NestedInteger ni) {
        if( ni.isInteger() ) {
            data.add(ni.getInteger());
        } else {
            List<NestedInteger> list = ni.getList();
            for (NestedInteger n : list) {
                dfs(n);
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            dfs(n);
        }
    }


    @Override
    public boolean hasNext() {
        return idx < data.size();
    }

    @Override
    public Integer next() {
        return data.get(idx++);
    }

}
