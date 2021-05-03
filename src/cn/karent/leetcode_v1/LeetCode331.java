package cn.karent.leetcode_v1;

/**
 * 验证二叉树的前序序列化
 */
public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {
        if( preorder.length() == 0) {
            return true;
        }
        int slot = 1;
        int i = 0;
        String[] chs = preorder.split(",");
        while (i < chs.length && slot > 0) {
            if( !chs[i].equals("#")) {
                slot += 2;
            }
            slot--;
            i++;
        }
        return i == chs.length && slot == 0;
    }

    public static void main(String[] args) {
        LeetCode331 lc = new LeetCode331();
//        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        String s = "9,#,#,1";
//        String s = "#,#,3,5,#";
        String s = "#,7,6,9,#,#,#";
        boolean ret = lc.isValidSerialization(s);
        System.out.println(ret);
    }

}
