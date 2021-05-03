package cn.karent.interview;

import java.util.*;

/**
 * 婴儿名字
 */
public class Question1707 {

    private Map<String, Integer> map = new HashMap<>();
    private Map<Integer, String> inverseMap = new HashMap<>();

    class DSU {
        private int n = 0;
        private int[] parent = null;
        private int[] rank = null;
        private int capcity = 0;

        public DSU(int n) {
            this.n = n;
            capcity = n * 2;
            parent = new int[capcity];
            for(int i = 0; i < capcity; i++) {
                parent[i] = i;
            }
            rank = new int[capcity];
        }

        public void set(int idx, int n) {
            rank[idx] = n;
        }

        public int find(int idx) {
            if( parent[idx] == idx) {
                return idx;
            }
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }

        public void unionString(String s1, String s2) {
            int x1 = map.getOrDefault(s1, -1);
            int x2 = map.getOrDefault(s2, -1);
            if( x1 == -1) {
                x1 = n;
                map.put(s1, n);
                inverseMap.put(n, s1);
                n++;
            }
            if( x2 == -1) {
                x2 = n;
                map.put(s2, n);
                inverseMap.put(n, s2);
                n++;
            }
            union(x1, x2);
        }

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            String key1 = inverseMap.get(px1);
            String key2 = inverseMap.get(px2);
            if( key1.compareTo(key2) > 0) {
                int tmp = px1;
                px1 = px2;
                px2 = tmp;
            }
            if( px1 != px2) {
                parent[px2] = px1;
                rank[px1] += rank[px2];
            }
        }

        public List<String> getUnique() {
            List<String> rets = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if( parent[i] == i) {
                    String key = inverseMap.get(i);
                    int n = rank[i];
                    key = key + "(" + n + ")";
                    rets.add(key);
                }
            }
            return rets;
        }
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        int idx = 0;
        DSU dsu = new DSU(names.length);
        for(String name : names) {
            int bracket = name.indexOf('(');
            String s = name.substring(0, bracket);
            int n = Integer.parseInt(name.substring(bracket+1, name.length()-1));
            map.put(s, idx);
            dsu.set(idx, n);
            inverseMap.put(idx, s);
            idx++;
        }
        for(String str : synonyms) {
            int b = str.indexOf(',');
            String s1 = str.substring(1, b);
            String s2 = str.substring(b+1, str.length()-1);
            dsu.unionString(s1, s2);
        }
        List<String> list = dsu.getUnique();
        String[] rets = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            rets[i] = list.get(i);
        }
        return rets;
    }

    public static void main(String[] args) {
        Question1707 q = new Question1707();
//        String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
//        String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        String[] names = {"a(10)","c(13)"};
        String[] synonyms = {"(a,b)","(c,d)","(b,c)"};
        String[] rets = q.trulyMostPopular(names, synonyms);
        for(String ret : rets) {
            System.out.print(ret + " ");
        }
    }
}
