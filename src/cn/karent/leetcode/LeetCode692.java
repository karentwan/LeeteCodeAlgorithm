package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 前k个高频单词
 */
public class LeetCode692 {

    class Pair implements Comparable<Pair>{
        private String word;
        private int cnt;

        public Pair(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if( o.cnt == this.cnt) {
                return o.word.compareTo(this.word);
            }
            return this.cnt - o.cnt;
        }

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        PriorityQueue<Pair> que = new PriorityQueue<>();
        int cnt = 0;
        while( iter.hasNext() && cnt < k ) {
            Map.Entry<String, Integer> entry = iter.next();
            que.offer(new Pair(entry.getKey(), entry.getValue()));
            cnt++;
        }
        while( iter.hasNext() ) {
            Map.Entry<String, Integer> entry = iter.next();
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            if( pair.compareTo(que.peek()) > 0) {
                que.poll();
                que.offer(pair);
            }
        }
        List<String> rets = new ArrayList<>();
        while( !que.isEmpty() ) {
            rets.add(que.poll().word);
        }
        Collections.reverse(rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode692 lc = new LeetCode692();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
//        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
//        int k = 4;
        List<String> rets = lc.topKFrequent(words, k);
        LeetCodeUtil.print(rets);
    }

}
