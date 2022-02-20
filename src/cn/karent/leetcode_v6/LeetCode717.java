package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-02-20 09:08
 * @description: 1比特与2比特字符
 *******************************************/
public class LeetCode717 {

    private boolean dfs(int[] bits, int idx) {
        if (idx == bits.length-1) {
            return true;
        }
        if (idx >= bits.length ) return false;
        if (bits[idx] == 0 && dfs(bits, idx+1)) return true;
        if( bits[idx] == 1 && dfs(bits, idx+2)) return true;
        return false;
    }

    public boolean isOneBitCharacter(int[] bits) {
        return dfs(bits, 0);
    }

    public static void main(String[] args) {
        LeetCode717 lc = new LeetCode717();
//        int[] bits = {1,0,0};
//        int[] bits = {1,1,1,0};
        int[] bits = {0,1,0};
        System.out.println(lc.isOneBitCharacter(bits));
    }

}
