package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 给表达式添加运算符
 * @author wan
 * @date 2021.10.16
 ***********************************************/
public class LeetCode282 {
    // + - * #  优先级队列
    private int[][] priors = {
            {-1, -1, -1, 1}, // +
            {-1, -1, -1, 1}, // -
            {1, 1, -1, 1},   // *
            {-1, -1, -1, -1} // #
    };

    private char[] opChars = {'+', '-', '*'};

    private long _calc(long n1, long n2, int op) {
        long ret = 0;
        switch (op) {
            case 0:  // +
                ret = n1 + n2;
                break;
            case 1:  // -
                ret = n1 - n2;
                break;
            case 2:
                ret = n1 * n2;
                break;
        }
        return ret;
    }

    private void calc(LinkedList<Integer> ops, LinkedList<Long> nums, LinkedList<String> trace, int op) {
        while ( !ops.isEmpty() && priors[op][ops.peekLast()] == -1) {
            long n2 = nums.pollLast();
            long n1 = nums.pollLast();
            Integer lastOp = ops.pollLast();
            long ret = _calc(n1, n2, lastOp);
            nums.offerLast(ret);
            String s2 = trace.pollLast();
            String s1 = trace.pollLast();
            trace.offerLast(s1 + opChars[lastOp] + s2);
        }
        ops.offerLast(op);
    }

    private List<String> rets = new ArrayList<>();

    private void dfs(
            char[] chs,
            int idx,
            int target,
            LinkedList<Integer> ops,
            LinkedList<Long> nums,
            LinkedList<String> trace
    ) {
        long t = 0;
        // 克隆当前栈
        for (int i = idx; i < chs.length; i++) {
            t = t * 10 + (chs[i] - '0');
            if( i != idx && chs[idx] == '0') return;
            if( i == chs.length - 1) {  // 最后一个字符
                LinkedList<Integer> cloneOps = new LinkedList<>(ops);
                LinkedList<Long> cloneNums = new LinkedList<>(nums);
                LinkedList<String> cloneTrace = new LinkedList<>(trace);
                cloneNums.offerLast(t);
                cloneTrace.offerLast(t + "");
                calc(cloneOps, cloneNums, cloneTrace,3);
                long last = cloneNums.peekLast();
                String ret = cloneTrace.peekLast();
                if( last == target) {
//                    System.out.println(1);
//                    System.out.println(ret);
                    rets.add(ret);
                }
            } else {
                for (int j = 0; j < 3; j++) {  // 运算符
                    LinkedList<Integer> cloneOps = new LinkedList<>(ops);
                    LinkedList<Long> cloneNums = new LinkedList<>(nums);
                    LinkedList<String> cloneTrace = new LinkedList<>(trace);
                    cloneNums.offerLast(t);
                    cloneTrace.offerLast(t + "");
                    calc(cloneOps, cloneNums, cloneTrace, j);
                    dfs(chs, i+1, target, cloneOps, cloneNums, cloneTrace);
                }
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        char[] chs = num.toCharArray();
        dfs(chs, 0, target, new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
        return rets;
    }

    public static void main(String[] args) {
        LeetCode282 lc = new LeetCode282();
//        String num = "123";
//        int target = 6;
        String num = "232";
        int target = 8;
//        String num = "105";
//        int target = 5;
//        String num = "2147483648";
//        int target = -2147483648;
        List<String> rets = lc.addOperators(num, target);
        System.out.println(rets);
//        String s = "2147483648";
//        int t = 0;
//        for (int i = 0; i < s.length(); i++) {
//            t = t * 10 + (s.charAt(i) - '0');
//        }
//        System.out.println(t);
    }

}
