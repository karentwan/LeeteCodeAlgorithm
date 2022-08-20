package cn.karent.leetcode_v7;

import java.util.Arrays;
import java.util.Random;

/******************************************
 * 设计跳表
 * @author wan
 * @date 2022.08.20 09:53
 ******************************************/
public class Skiplist {

    static class SkiplistNode {
        int val;
        SkiplistNode[] forward;

        public SkiplistNode(int val, int maxLevel) {
            this.val = val;
            forward = new SkiplistNode[maxLevel];
        }
    }

    // 定义一些常量
    static final int MAX_LEVEL = 32;  // 最大深度
    static final double P_FACTOR = 0.25;  // 以P_FACTOR的概率向上插入节点
    private SkiplistNode head;  // 头结点
    private Random random;   // 随机函数
    private int level;        // 当前跳表具有的深度(MAX_LEVEL是理论上的最大深度)

    public Skiplist() {
        head = new SkiplistNode(-1, MAX_LEVEL);
        random = new Random();
    }

    public boolean search(int target) {
        SkiplistNode curr = head;
        for (int i = level-1; i>=0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(update, head);
        SkiplistNode curr = head;
        for (int i = level-1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        int lv = randomLevel();  // 当前节点具有的层数
        level = Math.max(lv, level);
        SkiplistNode node = new SkiplistNode(num, lv);
        for (int i = lv-1; i >= 0; i--) {
            node.forward[i] = update[i].forward[i];
            update[i].forward[i] = node;
        }
    }

    private int randomLevel() {
        int lv = 1;
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }

    public boolean erase(int num) {
        SkiplistNode[] update = new SkiplistNode[level];
        SkiplistNode curr = head;
        for (int i = level-1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];
        if (curr == null || curr.val != num) return false;
        // 删除
        for (int i = level-1; i >= 0; i--) {
            if (update[i].forward[i] != curr) continue;
            update[i].forward[i] = curr.forward[i];
        }
        // 更新level
        while (level > 1 && head.forward[level-1] == null)
            level--;
        return true;
    }

    public static void main(String[] args) {
        Skiplist lc = new Skiplist();
        lc.add(1);
        lc.add(2);
        lc.add(3);
        System.out.println(lc.search(0));
        lc.add(4);
        System.out.println(lc.search(1));
        System.out.println(lc.erase(0));
        System.out.println(lc.erase(1));
        System.out.println(lc.search(1));
    }

}
