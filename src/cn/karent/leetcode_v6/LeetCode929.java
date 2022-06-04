package cn.karent.leetcode_v6;

import java.util.HashSet;
import java.util.Set;

/******************************************
 * 独特的电子邮件地址
 * @author wan
 * @date 2022.06.04 09:50
 ******************************************/
public class LeetCode929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(validEmail(email));
        }
        return set.size();
    }

    private String validEmail(String email) {
        char[] chs = email.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length && chs[i] != '@' && chs[i] != '+'; i++) {
            if (chs[i] != '.') {
                sb.append(chs[i]);
            }
        }
        int atIdx = email.indexOf('@');
        sb.append(email.substring(atIdx));
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode929 lc = new LeetCode929();
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(lc.numUniqueEmails(emails));

    }

}
