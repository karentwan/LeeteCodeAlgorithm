package cn.karent.leetcode_v2;

import cn.karent.util.*;
import java.util.*;

/**
 * 从先序遍历还原二叉树
 */
public class LeetCode1028 {

    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> st = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            int level = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                level++;
                i++;
            }
            int val = 0;
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                val = val * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(val);
            if( level == st.size()) {
                if( !st.isEmpty() ) {
                    st.peek().left = node;
                }
            } else {
                while (st.size() != level) {
                    st.pop();
                }
                st.peek().right = node;
            }
            st.push(node);
        }
        while (st.size() > 1) {
            st.pop();
        }
        return st.peek();
    }

}
