package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 查询无效交易
 * @author wan
 * @date 2021.05.26
 ********************************************/
public class LeetCode1169 {

    class Node {
        String name;
        int time;
        int amount;
        String city;
        int idx;

        public Node(String name, int time, int amount, String city, int idx) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.idx = idx;
        }

        public boolean invalid(Node p) {
            return (name.equals(p.name)
                    && !city.equals(p.city)
                    && Math.abs(time - p.time) <= 60);
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Node>> map = new HashMap<>();
        Set<Integer> idxs = new HashSet<>();
        for (int i = 0; i < transactions.length; i++) {
            String ts = transactions[i];
            String[] tmps = ts.split(",");
            String name = tmps[0];
            int time = Integer.parseInt(tmps[1]);
            int amount = Integer.parseInt(tmps[2]);
            String city = tmps[3];
            Node p = new Node(name, time, amount, city, i);
            List<Node> ret = null;
            if( amount > 1000) idxs.add(i);
            if( !map.containsKey(name)) {
                ret = new ArrayList<>();
                map.put(name, ret);
            } else {
                ret = map.get(name);
                for (int j = 0; j < ret.size(); j++) {
                    if( p.invalid(ret.get(j))) {
                        idxs.add(p.idx);
                        idxs.add(ret.get(j).idx);
                    }
                }
            }
            ret.add(p);
        }
        final List<String> rets = new ArrayList<>();
        idxs.forEach((k)->{
            rets.add(transactions[k]);
        });
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1169 lc = new LeetCode1169();
//        String[] transactions = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing"};
//        String[] transactions = {"alice,20,800,mtv","bob,50,1200,mtv"};
        List<String> rets = lc.invalidTransactions(transactions);
        System.out.println(rets);
    }

}
