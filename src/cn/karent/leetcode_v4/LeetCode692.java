package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 前k个高频单词
 * @author wan
 * @date 2021.05.20
 ********************************************/
public class LeetCode692 {

    class Node implements Comparable<Node>{
        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
//            return this.cnt == o.cnt ? this.word.compareTo(o.word) : o.cnt - this.cnt;
            return this.cnt == o.cnt ? o.word.compareTo(this.word) : this.cnt - o.cnt;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (String key : map.keySet()) {
            int cnt = map.get(key);
            Node node = new Node(key, cnt);
            if( pq.size() < k) pq.offer(node);
            else if( !pq.isEmpty() && node.compareTo(pq.peek()) > 0) {
                pq.offer(node);
                pq.poll();
            }
        }
        List<String> rets = new ArrayList<>();
        while (!pq.isEmpty()) {
            rets.add(pq.poll().word);
        }
        Collections.reverse(rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode692 lc = new LeetCode692();
//        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
//        int k = 2;
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> rets = lc.topKFrequent(words, k);
        System.out.println(rets);
    }

}
