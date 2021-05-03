package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 重新排列句子中的单词
 */
public class LeetCode1451 {

    private void mergeSort(String[] arr, int left, int right, String[] tmp, Comparator<String> cmp) {
        if( left >= right) {
            return;
        }
        int mid = left + (right - left) /2;
        mergeSort(arr, left, mid, tmp, cmp);
        mergeSort(arr, mid+1, right, tmp, cmp);
        int i = left, j = mid+1, k = left;
        while (i <= mid && j <= right) {
            if( cmp.compare(arr[i], arr[j]) <= 0) {
                tmp[k] = arr[i++];
            } else {
                tmp[k] = arr[j++];
            }
            k++;
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }
        for (i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    private void sort(String[] arr, Comparator<String> cmp) {
        String[] tmps = new String[arr.length];
        mergeSort(arr, 0, arr.length-1, tmps, cmp);
    }

    public String arrangeWords(String text) {
        String[] strs = text.split(" ");
        sort(strs, (k1, k2) -> {
           return k1.length() - k2.length();
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i].toLowerCase());
            sb.append(" ");
        }
        if( sb.length() > 0) {
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            if( ch >= 'a' && ch <= 'z') {
                ch -= 'a';
                ch += 'A';
            }
            sb.insert(0, ch);
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1451 lc = new LeetCode1451();
        String s = "Leetcode is cool";
        String ret = lc.arrangeWords(s);
        System.out.println(ret);
    }

}
