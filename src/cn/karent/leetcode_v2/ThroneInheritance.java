package cn.karent.leetcode_v2;

import java.util.*;

/**
 * ThroneInheritance 皇位继承顺序, 多叉树的前序遍历
 */
public class ThroneInheritance {

    class Node {
        private String name;

        private List<Node> children;

        private boolean live;

        public Node() {
            this.children = new ArrayList<>();
            live = true;
        }

        public Node(String name) {
            this();
            this.name = name;
        }

        public void addChild(Node child) {
            children.add(child);
        }

        public boolean isLive() {
            return live;
        }

        public void setLive(boolean live) {
            this.live = live;
        }
    }

    private Map<String, Node> cache = new HashMap<>();

    private Node root = null;

    public ThroneInheritance(String kingName) {
        root = new Node(kingName);
        cache.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Node node = cache.getOrDefault(parentName, null);
        if( node == null) {
            return;
        }
        Node child = new Node(childName);
        cache.put(childName, child);
        node.addChild(child);
    }

    public void death(String name) {
        Node node = cache.getOrDefault(name, null);
        if (node == null) {
            return;
        }
        node.setLive(false);
    }

    private void dfs(Node root, List<String> ret) {
        if( root == null) {
            return;
        }
        if (root.isLive()) {
            ret.add(root.name);
        }
        for (Node child : root.children) {
            dfs(child, ret);
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }

}
