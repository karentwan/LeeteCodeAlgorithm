package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 窥探迭代器
 * @author wan
 * @date 2021.10.05
 ***********************************************/
public class PeekingIterator implements Iterator {

    private Iterator<Integer> iter;

    private Integer last;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if( !hasNext() ) return null;
        if( last == null) {
            last = iter.next();
        }
        return last;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if( !hasNext() ) {
            return null;
        }
        if( last != null) {
            Integer tmp = last;
            last = null;
            return tmp;
        }
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return last != null || iter.hasNext();
    }

    public static void main(String[] args) {

    }

}
