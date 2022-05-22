package cn.karent.leetcode_v6;

import java.util.HashMap;
import java.util.Map;

/*******************************************
 * @author wan
 * @date: 2022.05.22 09:48
 * @description: 我能赢吗
 *******************************************/
public class LeetCode464 {

    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 先判断所有数加起来是否能够大于等于desiredTotal, 不能的话再怎么选都不可能赢
        if ((1+maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    private boolean dfs(int maxChoosableInteger,
                        int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memo.containsKey(usedNumbers)) {
            boolean ret = false;
            // 遍历所有的元素
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) {  // 当前元素未选中
                    if (i+1+currentTotal >= desiredTotal) {  // 当前能赢
                        ret = true;
                        break;
                    }
                    if (!dfs(maxChoosableInteger, usedNumbers | (1<<i), desiredTotal,
                            currentTotal+i+1)) {  // 对方赢不了
                        ret = true;
                        break;
                    }
                }
            }
            memo.put(usedNumbers, ret);
        }
        return memo.get(usedNumbers);
    }

    public static void main(String[] args) {
        LeetCode464 lc = new LeetCode464();
        int maxChoosableInteger = 10, desiredTotal = 11;
        System.out.println(lc.canIWin(maxChoosableInteger, desiredTotal));
    }

}
