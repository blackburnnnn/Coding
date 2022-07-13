package com.lei.mycode.DataStructure;

/**
 * @description
 * @author michaelj
 * @date 2022/6/20
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,4,6,9,10,15,20};
        int findVal = 6;
        System.out.println(binarySearch(arr, 0, arr.length-1, findVal));
        System.out.println(binarySearchNoRecur(arr, findVal));
    }

    /**
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 目标数
     * @return 如果找到就返回下标，没找到就返回-1
     */

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (arr[mid] == findVal) {
            return mid;
        } else if (arr[mid] > findVal) {
            // 向左边查找
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            // 向右边查找
            return binarySearch(arr, mid + 1, right, findVal);
        }
    }

    public static int binarySearchNoRecur(int[] arr, int findVal) {
        int start = 0;
        int end = arr.length-1;
        int middle;
        while(start <= end){
            middle = (start+end)/2;
            if(arr[middle] == findVal){
                return middle;
            }
            else if(arr[middle] > findVal){
                end = middle-1;// 需要加上一个偏置位1，因为middle已经不用考虑了，否则查找大的不存在的数，程序会一直运行
            }
            else{
                start = middle+1;
            }
        }
        return -1;
        // 搜索区间为[left, right]
//        int left = 0, right = nums.length - 1; // 注意这里右边界设为nums.length - 1
//        while (left <= right) {
//            // 这里判断条件为 <= 出 while 条件为 left = right + 1; 即 [right + 1, right] [5, 4]
//            // 此时区间为空，while 终止，直接返回 -1；
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] < target) {
//                // 这里和下面都是 mid +/- 1 是因为本算法的搜索区间两端都是闭的，即[left, right],
//                // 当发现索引mid不是要找的target时，下一步去搜索区间 [left, mid - 1] 或 [mid + 1 ,right]
//                left = mid + 1;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            }
//        }
//        // while 结束还没返回：没找到
//        return -1;
    }
}
