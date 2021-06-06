package cn.karent.other;

/********************************************
 * description: 二分查找模板
 * 注意事项: 二分查找一定要注意数组里面的重复元素
 * @author wan
 * @date 2021.06.06
 ********************************************/
public class BinarySearchTest {


    public static void main(String[] args) {
        //           0 1 2 3 4  5  6  7
        int[] arr = {3,5,8,8,8,10,11,12};
        int t = 14;
//        System.out.println(new GreatThanLast().search(arr, t));
//        System.out.println(new GreatThanFirst().search(arr, t));
//        System.out.println(new LessThanLast().search(arr, t));
//        System.out.println(new Less().search(arr, t));
        System.out.println(new Great().search(arr, t));
//        System.out.println(new LessThanFirst().search(arr, t));
    }


}

interface BinarySearch {
    int search(int[] arr, int t);
}

// 查找带有重复元素的
class GreatThanLast implements BinarySearch {
    /**
     * 最小的大于等于, 例如
     * 3,5,8,8,8,10,11,12
     * 要找到大于等于8的元素位置,且最后一个
     * @param t
     * @return
     */
    @Override
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length-1;
        while ( l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] > t) r = m - 1;
            else l = m+1;
        }
        return r >= 0 && arr[r] == t ? r : l;
    }
}

class GreatThanFirst implements BinarySearch {
    @Override
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int m = l+(r-l)/2;
            if( arr[m] >= t) r = m-1;
            else l = m+1;
        }
        return l;
    }
}

class LessThanLast implements BinarySearch {
    @Override
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length-1;
        while ( l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] > t) r = m-1;
            else l = m+1;
        }
        return r;
    }
}

class LessThanFirst implements BinarySearch {
    @Override
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length-1;
        while ( l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] >= t) r = m-1;
            else l = m+1;
        }
        return arr[l] == t ? l : r;
    }
}

class Great implements BinarySearch {
    @Override
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length-1;
        while ( l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] > t) r = m - 1;
            else l = m+1;
        }
        return l;
    }
}

class Less implements BinarySearch {
    @Override
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] >= t) r = m-1;
            else l = m+1;
        }
        return r;
    }
}


