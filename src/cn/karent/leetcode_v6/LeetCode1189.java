package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-02-13 10:39
 * @description: "气球"的最大数量
 *******************************************/
public class LeetCode1189 {

    public int maxNumberOfBalloons(String text) {
        int[] cache = new int[26];
        char[] chs = text.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            cache[chs[i] - 'a']++;
        }
        int ans = Math.min(Math.min(Math.min(Math.min(cache[1], cache[0]),
                cache['l' - 'a'] / 2), cache['o' - 'a'] / 2), cache['n'-'a']);
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1189 lc = new LeetCode1189();
//        String text = "nlaebolko";
//        String text = "loonbalxballpoon";
        String text = "ballon";
        System.out.println(lc.maxNumberOfBalloons(text));
    }

}
