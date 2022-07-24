package cn.karent.leetcode_v1.weeklycontest303;

import java.util.*;

/******************************************
 * 设计食物评分系统
 * @author wan
 * @date 2022.07.24 10:42
 ******************************************/
public class FoodRatings {

    class Node implements Comparable<Node> {

        private String foodName;

        private String cuisine;

        private int rating;

        public Node(String foodName, int rating, String cuisine) {
            this.foodName = foodName;
            this.rating = rating;
            this.cuisine = cuisine;
        }

        @Override
        public int compareTo(Node o) {
            if (rating == o.rating) {
                return foodName.compareTo(o.foodName);
            }
            return o.rating - rating;
        }
    }

    private Map<String, TreeSet<Node>> cuisineMap = new HashMap<>();

    private Map<String, Node> foodMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Node node = new Node(foods[i], ratings[i], cuisines[i]);
            cuisineMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>()).add(node);
            foodMap.put(foods[i], node);
        }
    }

    public void changeRating(String food, int newRating) {
        Node node = foodMap.get(food);
        TreeSet<Node> treeSet = cuisineMap.get(node.cuisine);
        treeSet.remove(node);
        node.rating = newRating;
        treeSet.add(node);
    }

    public String highestRated(String cuisine) {
        TreeSet<Node> nodes = cuisineMap.get(cuisine);
        Node first = nodes.first();
        return first.foodName;
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings lc = new FoodRatings(foods, cuisines, ratings);
        System.out.println(lc.highestRated("korean"));
        System.out.println(lc.highestRated("japanese"));
        lc.changeRating("sushi", 16);
        System.out.println(lc.highestRated("japanese"));
        lc.changeRating("ramen", 16);
        System.out.println(lc.highestRated("japanese"));
    }

}
