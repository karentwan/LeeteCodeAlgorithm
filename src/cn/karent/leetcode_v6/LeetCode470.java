package cn.karent.leetcode_v6;

public class LeetCode470 {

    private int rand7() {
        return ((int) (Math.random() * 7));
    }

    /**
     * 利用生成randY来生成randX, 公式randX = (randY - 1) * Y + rand
     * 两次调用生成的槽位为Y * Y, 每一个槽位的出现都是等概率的, 后续要如何算概率
     * 取决于我们怎么利用槽位里面的值, 如果算x1 * x2(槽位里面的两个值)那么概率就是他们出现的次数
     * 只要取相同的数也是等概率的, 但是要转换为我们需要的数字
     * @return
     */
    public int rand10() {
        int a = 0, b = 0, c = 0;
        do {
            a = rand7();
            b = rand7();
            c = (a - 1) * 7 + b;
        } while (c > 40);
        return c % 10 + 1;
    }

    public static void main(String[] args) {

    }
}
