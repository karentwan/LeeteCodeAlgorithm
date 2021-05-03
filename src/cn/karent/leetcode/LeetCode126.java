package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 单词接龙
 */
public class LeetCode126 {

    List<String> getNeighbor(String word, Set<String> words) {
        char[] chs = word.toCharArray();
        List<String> rets = new ArrayList<>();
        for(char a = 'a'; a <= 'z'; a++) {
            for(int i = 0; i < chs.length; i++) {
                if(chs[i] == a) {
                    continue;
                }
                char ch = chs[i];
                chs[i] = a;
                if( words.contains(String.valueOf(chs))) {
                    rets.add(String.valueOf(chs));
                }
                chs[i] = ch;
            }
        }
        return rets;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Set<String> words = new HashSet<>(wordList);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        que.offer(path);
        List<List<String>> rets = new ArrayList<>();
        while( !que.isEmpty() ) {
            int size = que.size();
            Set<String> level = new HashSet<>();
            for(int i = 0; i < size; i++) {
                List<String> node = que.poll();
                String last = node.get(node.size()-1);
                List<String> neighbors = getNeighbor(last, words);
                for(String tmp : neighbors) {
                    if( visited.contains(tmp)) {
                        continue;
                    }
                    if( tmp.equals(endWord) ) {
                        node.add(endWord);
                        rets.add(new ArrayList<>(node));
                        break;
                    }
                    List<String> next = new ArrayList<>(node);
                    next.add(tmp);
                    que.offer(next);
//                    visited.add(tmp);  // 这一层不能直接加入, 否则会影响到同一层的结果
                    level.add(tmp);
                }
            }
            if( rets.size() > 0) {
                break;
            }
            visited.addAll(level);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode126 lc = new LeetCode126();
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] arr = {"hot","dot","dog","lot","log","cog"};
        String beginWord = "red";
        String endWord = "tax";
        String[] arr = {"ted","tex","red","tax","tad","den","rex","pee"};
        List<String> wordList = LeetCodeUtil.arr2list(arr);
        List<List<String>> rets = lc.findLadders(beginWord, endWord, wordList);
        LeetCodeUtil.print(rets);
    }
}
