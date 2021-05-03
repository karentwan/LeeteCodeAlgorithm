package cn.karent.leetcode_v2.weeklycontest235;

import java.util.*;
import cn.karent.util.*;


/**
 * 截断句子
 * @author wan
 * @date 2021.04.04
 */
public class Algo5722 {

    public String truncateSentence(String s, int k) {
        String[] tmps = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k && i < tmps.length; i++) {
            sb.append(tmps[i]);
            sb.append(" ");
        }
        if( sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Algo5722 algo = new Algo5722();
        String s = "Hello how are you Contestant";
        int k = 4;
        String ret = algo.truncateSentence(s, k);
        System.out.println(ret);
    }

}
