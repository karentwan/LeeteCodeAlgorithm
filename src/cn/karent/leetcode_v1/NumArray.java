package cn.karent.leetcode_v1;

/**
 * 区域和检索 - 数组不可变
 * 使用线段树(最佳用法是使用前缀和, 时间复杂度为O(1))
 */
public class NumArray {

   /* class SegTree {

        private int[] nodes = null;
        private int n = 0;
        private int[] leftBorder = null;
        private int[] rightBorder = null;

        public SegTree(int[] data) {
            n = 4 * data.length;
            nodes = new int[n];
            leftBorder = new int[n];
            rightBorder = new int[n];
            create(data, 0, data.length-1, 0);
        }

        public void create(int[] data, int l, int r, int idx) {
            if( l > r) {
                return;
            }
            if( l == r) {
                nodes[idx] = data[l];
                leftBorder[idx] = rightBorder[idx] = l;
                return;
            }
            int mid = l + (r - l) / 2;
            create(data, l, mid, idx * 2 + 1);
            create(data, mid+1, r, idx * 2 + 2);
            nodes[idx] = nodes[idx * 2 + 1] + nodes[idx * 2 + 2];
            leftBorder[idx] = l;
            rightBorder[idx] = r;
        }

        public int search(int l, int r, int idx) {
            if( leftBorder[idx] > r || rightBorder[idx] < l) {
                return 0;
            }
            if( leftBorder[idx] >= l && rightBorder[idx] <= r) {
                return nodes[idx];
            }
            int mid = l + (r - l) / 2;
            int ret = search(l, r, idx * 2 + 1);
            ret += search(l, r, idx * 2 + 2);
            return ret;
        }

    }

    private SegTree st = null;

    public NumArray(int[] nums) {
        st = new SegTree(nums);
    }

    public int sumRange(int i, int j) {
        return st.search(i, j, 0);
    }*/

    private int[] data = null;

    private int n = 0;

    public NumArray(int[] nums) {
        n = nums.length+1;
        data = new int[n];
        for (int i = 1; i < n; i++) {
            data[i] = data[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if( j >= n-1) {
            j = n-2;
        }
        if( i < 0) {
            i = 0;
        }
        return data[j+1] - data[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        int ret = na.sumRange(0, 2);
        System.out.println(ret);
        ret = na.sumRange(2, 5);
        System.out.println(ret);
        ret = na.sumRange(0, 5);
        System.out.println(ret);
    }

}
