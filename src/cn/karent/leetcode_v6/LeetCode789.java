package cn.karent.leetcode_v6;

public class LeetCode789 {

    private int mahattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    // 吃豆人游戏, 这个题不要求找出所有方案
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = mahattanDistance(new int[]{0, 0}, target);
        for (int[] ghost : ghosts) {
            int t = mahattanDistance(ghost, target);
            if( t <= distance)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
    

}
