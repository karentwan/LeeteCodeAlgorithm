package cn.karent.util;

import java.util.*;

/**
 * 多叉树的节点
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
