package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 按递增顺序显示卡牌
 * @author wan
 * @date 2021.05.15
 ********************************************/
public class LeetCode950 {

    // 硬模拟
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int[] rets = new int[n];
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            que.offer(i);
        }
        for (int d : deck) {
            rets[que.pollFirst()] = d;
            if( !que.isEmpty()) {
                que.offerLast(que.pollFirst());
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode950 lc = new LeetCode950();
        int[] arr = {17, 13, 11, 2, 3, 5, 7};
        int[] rets = lc.deckRevealedIncreasing(arr);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
