package cn.karent.leetcode_v6;


/******************************************
 * 排序的循环链表
 * @author wan
 * @date 2022.06.18 09:22
 ******************************************/
public class Offer029 {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if (head == null) {  // 没有节点
            n.next = n;
            return n;
        }  else if (head.next == head) {  // 只有一个节点
            n.next = head;
            head.next = n;
            return head;
        }
        // 先找到起始节点
        Node cur = head, next = head.next;
        while (next != head) {  // 循环遍历一轮
            if (insertVal >= cur.val && insertVal <= next.val) {
                break;
            }
            if (cur.val > next.val) {  // cur为当前最大的节点, next为当前最小的节点
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = next;
            next = next.next;
        }
        cur.next = n;
        n.next = next;
        //
        return head;
    }

    public static void main(String[] args) {
        Offer029 lc = new Offer029();


    }

}


