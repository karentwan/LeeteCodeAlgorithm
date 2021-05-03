package cn.karent.leetcode;

import java.util.*;

/**
 * 行星碰撞
 */
public class LeetCode735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < asteroids.length; i++) {
            if( asteroids[i] > 0) {
                st.push(i);
            } else {
                int tmp = Math.abs(asteroids[i]);
                while( !st.isEmpty() && tmp > asteroids[st.peek()]) {
                    set.add(st.pop());
                }
                if( !st.isEmpty() ) {
                    if( tmp == asteroids[st.peek()] ) {
                        set.add(st.pop());
                    }
                    set.add(i);
                }
            }
        }
        int[] rets = new int[asteroids.length - set.size()];
        int idx = 0;
        for(int i = 0; i < asteroids.length; i++) {
            if( !set.contains(i)) {
                rets[idx++] = asteroids[i];
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode735 lc = new LeetCode735();
//        int[] asteroids = {5,10,-5};
//        int[] asteroids = {8,-8};
//        int[] asteroids = {10,2,-5};
        int[] asteroids = {-2,-1,1,2};
        int[] rets = lc.asteroidCollision(asteroids);
        for(int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
