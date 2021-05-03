package cn.karent.interview;

import java.util.*;
import cn.karent.util.*;

public class Offer26 {

    private boolean dfs(TreeNode a, TreeNode b) {
        if( a == null) {
            return b == null;
        }
        if( b == null ) {
            return true;
        }
        return a.val == b.val && dfs(a.left, b.left) && dfs(a.right, b.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) {
            return false;
        }
        if( A == null) {
            return B == null;
        }
        if( dfs(A, B) ) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static void main(String[] args) {
        Offer26 offer = new Offer26();
        Integer[] arr1 = {3,4,5,1,2};
        Integer[] arr2 = {4,1};

        TreeNode a = LeetCodeUtil.arr2tree(arr1);
        TreeNode b = LeetCodeUtil.arr2tree(arr2);
        boolean ret = offer.isSubStructure(a, b);
        System.out.println(ret);
    }

}
