package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 文件的最长绝对路径
 *              -这就是一个树的前序遍历
 * @author wan
 * @date 2021.07.01
 ***********************************************/
public class LeetCode388 {


    public int lengthLongestPath(String input) {
        if( input.length() == 0) return 0;
        int[] levels = new int[input.length()+1];
        int ret = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 2;
            levels[level] = levels[level-1] + s.length() - (level - 1);
            if( s.contains(".")) {
                ret = Math.max(ret, levels[level] + level - 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode388 lc = new LeetCode388();
//        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String s = "file1.txt\nfile2.txt\nlongfile.txt";
        int ret = lc.lengthLongestPath(s);
        System.out.println(ret);
    }

}
