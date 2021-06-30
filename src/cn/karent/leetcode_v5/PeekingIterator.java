package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.06.30
 ***********************************************/
public class PeekingIterator implements Iterator<Integer>{

    private Integer last = null;

    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if( last != null) return last;
        if( !iter.hasNext()) return null;
        last = iter.next();
        return last;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if( last != null) {
            Integer t = last;
            last = null;
            return t;
        }
        if( !iter.hasNext()) return null;
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext() || last != null;
    }

    public static void main(String[] args) {

    }

}
