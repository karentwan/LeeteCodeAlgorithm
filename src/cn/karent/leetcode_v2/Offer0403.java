package cn.karent.leetcode_v2;

import cn.karent.util.*;
import java.util.*;

/**
 * 特定深度节点链表
 */
public class Offer0403 {

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(tree);
        while (!que.isEmpty()) {
            int size = que.size();
            ListNode phead = new ListNode();
            ListNode p = phead;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                p.next = new ListNode(node.val);
                p = p.next;
                if( node.left != null) {
                    que.offer(node.left);
                }
                if( node.right != null) {
                    que.offer(node.right);
                }
            }
            list.add(phead.next);
        }
        ListNode[] ret = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

}
