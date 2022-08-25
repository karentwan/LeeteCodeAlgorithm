package cn.karent.util;

import java.util.*;

/**
 * 工具类
 */
public class LeetCodeUtil {

    public static <T> void print(T[][] t) {
        for(T[] tmp : t) {
            for(T tt : tmp) {
                System.out.print(tt + " ");
            }
            System.out.println();
        }
    }

    public static <T> void print(T[] t) {
        for(T tmp : t) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static <T> void print(List<T> list) {
        for(T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(long[] arr) {
        for (long l : arr) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

    public static <T> List<T> arr2list(T[] arr) {
        List<T> rets = new ArrayList<>();
        for(T item : arr) {
            rets.add(item);
        }
        return rets;
    }

    public static <T> List<List<T>> arr2list(T[][] arr) {
        List<List<T>> rets = new ArrayList<>();
        for(T[] a : arr) {
            List<T> ret = new ArrayList<>();
            for(T tmp : a) {
                ret.add(tmp);
            }
            rets.add(ret);
        }
        return rets;
    }

    public static TreeNode arr2tree(Integer[] arr) {
        if( arr.length == 0) {
            return null;
        }
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        que.offer(root);
        int i = 1;
        while( i < arr.length ) {
            TreeNode node = que.poll();
            if( i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                que.offer(node.left);
            }
            i++;
            if( i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                que.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static ListNode arr2ListNode(Integer[] arr) {
        ListNode phead = new ListNode();
        ListNode p = phead;
        for (int a : arr) {
            p.next = new ListNode(a);
            p = p.next;
        }
        return phead.next;
    }

    public static void traverseList(ListNode head) {
        ListNode p = head;
        while( p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static void levelTraverse(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if( root == null) {
            return;
        }
        que.offer(root);
        TreeNode tmp = null;
        while( !que.isEmpty() ) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                tmp = que.poll();
                System.out.print(tmp.val + " ");
                if( tmp.left != null) {
                    que.offer(tmp.left);
                }
                if( tmp.right != null) {
                    que.offer(tmp.right);
                }
            }
            System.out.println();
        }
    }
    
    public static void preorderTraverse(TreeNode root) {
        if( root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }
    
    public static void inorderTraverse(TreeNode root) {
        if( root == null) {
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.val + " ");
        inorderTraverse(root.right);
    }
    
    public static void postorderTraverse(TreeNode root) {
        if( root == null) {
            return;
        }
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.print(root.val + " ");
    }

    public static void run(TestCase tc, int[]... arrs) {
        for (int[] arr : arrs) {
            tc.test(arr);
        }
    }

}
