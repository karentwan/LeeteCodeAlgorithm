package cn.karent.leetcode_v6;


/**
 * 按键持续时间最长的键
 */
public class LeetCode1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] times = new int[26];
        char[] chs = keysPressed.toCharArray();
        for (int i = 0, last = 0; i < chs.length; last = releaseTimes[i], i++) {
            int idx = chs[i] - 'a';
            int time = releaseTimes[i] - last;
            times[idx] = Math.max(times[idx], time);
        }
        int max = 0; char ans = '\0';
        for (int i = 0; i < 26; i++) {
            if (times[i] >= max) {
                max = times[i];
                ans = (char)(i + 'a');
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1629 lc = new LeetCode1629();
        int[] releaseTime = {9,29,49,50};
        String keysPressed = "cbcd";
        System.out.println(lc.slowestKey(releaseTime, keysPressed));
    }

}
