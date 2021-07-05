package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 原子的数量
 * @author wan
 * @date 2021.07.05
 ***********************************************/
public class LeetCode726 {

    private int idx;
    private String formula;

    public String getAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(idx++));
        for (; idx < formula.length() && Character.isLowerCase(formula.charAt(idx)); idx++) {
            sb.append(formula.charAt(idx));
        }
        return sb.toString();
    }

    public int getNumber() {
        int cnt = 0;
        for (; idx < formula.length() && Character.isDigit(formula.charAt(idx)); idx++) {
            cnt = cnt * 10 + (formula.charAt(idx) - '0');
        }
        return cnt == 0 ? 1 : cnt;
    }

    public String countOfAtoms(String formula) {
        idx = 0;
        this.formula = formula;
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int n = formula.length();
        for (; idx < n; ) {
            char ch = formula.charAt(idx);
            if( ch == ')') {
                Map<String, Integer> m1 = st.pop();
                Map<String, Integer> m2 = st.peek();
                idx++;
                int cnt = getNumber();
                // 将m1里面的元素加到m2里面去
                for (String s : m1.keySet()) {
                    m2.put(s, m2.getOrDefault(s, 0) + m1.get(s) * cnt);
                }
            } else if( ch == '('){
                st.push(new HashMap<>());
                idx++;
            } else {
                String s = getAtom();
                int cnt = getNumber();
                Map<String, Integer> map = st.peek();
                map.put(s, cnt + map.getOrDefault(s, 0));
            }
        }
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> tm = new TreeMap<>(st.pop());
        for (Map.Entry<String, Integer> es : tm.entrySet()) {
            String key = es.getKey();
            int cnt = es.getValue();
            sb.append(key);
            if( cnt > 1) {
                sb.append(cnt);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode726 lc = new LeetCode726();
//        String s = "H2O";
//        String s = "Mg(OH)2";
        String s = "H11He49NO35B7N46Li20";
        String ret = lc.countOfAtoms(s);
        System.out.println(ret);
    }

}
