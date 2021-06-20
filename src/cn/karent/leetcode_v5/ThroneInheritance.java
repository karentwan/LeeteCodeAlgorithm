package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 
 * @author wan
 * @date 2021.06.20
 ********************************************/
public class ThroneInheritance {

    class Node {
        boolean dead;
        List<Node> children;
        String name;

        public Node(String name) {
            this.name = name;
            children = new ArrayList<>();
            dead = false;
        }

        public void add(Node child) {
            children.add(child);
        }

        public List<Node> getChildren() {
            return children;
        }

        public boolean isDead() {
            return dead;
        }

        public void setDead(boolean dead) {
            this.dead = dead;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private Map<String, Node> map;

    private String king;

    public ThroneInheritance(String kingName) {
        Node root = new Node(kingName);
        king = kingName;
        map = new HashMap<>();
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Node parent = map.getOrDefault(parentName, null);
        if( parent == null) return;
        Node child = new Node(childName);
        map.put(childName, child);
        parent.add(child);
    }

    public void death(String name) {
        Node p = map.getOrDefault(name, null);
        if( p == null) return;
        p.setDead(true);
    }

    private void dfs(Node root, List<String> rets) {
        if( root == null) return;
        if( !root.isDead()) rets.add(root.name);
        List<Node> children = root.getChildren();
        for (Node child : children) {
            dfs(child, rets);
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> rets = new ArrayList<>();
        Node root = map.get(king);
        dfs(root, rets);
        return rets;
    }

    public static void main(String[] args) {

    }

}
