package cn.karent.leetcode_v2;

import java.util.*;

/**
 * Dota2 参议院
 * @author wan
 * @date 2021.04.08
 */
public class LeetCode649 {

    public String predictPartyVictory(String senate) {
        Deque<Integer> rad = new LinkedList<>();
        Deque<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if( senate.charAt(i) == 'R') {
                rad.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while ( !rad.isEmpty() && !dire.isEmpty()) {
            if( rad.peek() < dire.peek()) {
                dire.poll();
                rad.offer(rad.poll() + senate.length());
            } else {
                rad.poll();
                dire.offer(dire.poll() + senate.length());
            }
        }
        return rad.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        LeetCode649 lc = new LeetCode649();
//        String s = "DDRRR";
//        String s = "RRDDD";
        String s = "RDD";
        String ret = lc.predictPartyVictory(s);
        System.out.println(ret);
    }

}
