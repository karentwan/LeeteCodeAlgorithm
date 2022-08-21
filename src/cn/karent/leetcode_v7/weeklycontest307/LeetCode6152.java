package cn.karent.leetcode_v7.weeklycontest307;

import java.util.*;

/******************************************
 * 赢得比赛需要的最少训练时长
 * @author wan
 * @date 2022.08.21 10:30
 ******************************************/
public class LeetCode6152 {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int eg = 0, maxEp = 0, lastEp = 0;
        for (int i = 0; i < energy.length; lastEp += experience[i], i++) {
            eg += energy[i];
            maxEp = Math.max(maxEp, experience[i] - lastEp);
        }
        return Math.max(eg - initialEnergy + 1, 0) + Math.max(maxEp - initialExperience + 1, 0);
    }

    public static void main(String[] args) {
        LeetCode6152 lc = new LeetCode6152();
//        int initialEnergy = 5;
//        int initialExperience = 3;
//        int[] energy = {1,4,3,2};
//        int[] experience = {2,6,3,1};
        int initialEnergy = 1;
        int initialExperience = 1;
        int[] energy = {1,1,1,1};
        int[] experience = {1,1,1,50};
        System.out.println(lc.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

}
