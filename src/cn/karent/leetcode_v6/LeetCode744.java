package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-04-03 12:01
 * @description: 寻找比目标字母大的最小字母
 *******************************************/
public class LeetCode744 {

    public char nextGreatestLetter1(char[] letters, char target) {
        int min = 52;
        int t = target - 'a';
        for(int i = 0; i < letters.length; i++) {
            int l = letters[i] - 'a';
            if (l > t) {
                min = Math.min(min, l);
            } else if (l + 26 > t) {
                min = Math.min(min, l + 26);
            }
        }
        return (char) ((min >= 26 ? min - 26 : min) + 'a');
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length-1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (letters[m] > target) {
                r = m-1;
            } else {
                l = m + 1;
            }
        }
        return l == letters.length ? letters[0] : letters[l];
    }

    public static void main(String[] args) {
        LeetCode744 lc = new LeetCode744();
//        char[] letters = {'c', 'f', 'j'};
//        char target = 'a';
//        char[] letters = {'c', 'f', 'j'};
//        char target = 'c';        
        char[] letters = {'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char target =  'z';
        System.out.println(lc.nextGreatestLetter(letters, target));
    }

}
