package cn.karent.leetcode;

import java.util.*;

/**
 * 设计推特
 */
public class Twitter {

    class Post implements Comparable<Post>{
        public int id;

        @Override
        public int compareTo(Post o) {
            return o.timestamp - timestamp;
        }

        public int timestamp;
        public Post next;

        public Post() {
        }

        public Post(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    private int timestamp = 0;

    private Map<Integer, Post> postes = new HashMap<>();
    private Map<Integer, Set<Integer>> followings = new HashMap<>();


    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Post newPost = new Post(tweetId, timestamp);
        if( postes.containsKey(userId)) {
            Post post = postes.get(userId);
            newPost.next = post;
        }
        postes.put(userId, newPost);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> heap = new PriorityQueue<>();
        if( postes.containsKey(userId)) {
            heap.offer(postes.get(userId));
        }
        Set<Integer> followers = followings.getOrDefault(userId, null);
        List<Integer> rets = new ArrayList<>();
        if( followers != null && followers.size() > 0) {
            for(int fId : followers) {
                Post post = postes.getOrDefault(fId, null);
                if( post != null) {
                    heap.offer(post);
                }
            }
        }
        int cnt = 0;
        while( !heap.isEmpty() && cnt < 10) {
            Post post = heap.poll();
            rets.add(post.id);
            if( post.next != null) {
                heap.offer(post.next);
            }
            cnt++;
        }
        return rets;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if( followerId == followeeId) {
            return;
        }
        Set<Integer> followers = followings.getOrDefault(followerId, null);
        if( followers == null) {
            followers = new HashSet<>();
            followings.put(followerId, followers);
        }
        followers.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if( followerId == followeeId) {
            return;
        }
        Set<Integer> followers = followings.getOrDefault(followerId, null);
        if( followers != null && followers.contains(followeeId)) {
            followers.remove(followeeId);
        }
    }
}
