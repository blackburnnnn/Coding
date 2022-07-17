package com.lei.mycode.leetcode;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {



    }
}


// 剑指offer 9.用两个栈实现队列



// 剑指offerⅡ 9.乘积小于k的子数组
class Solution9 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count  = 0;
        int length = nums.length;
        // l作为左窗口
        for(int l = 0; l < length; l++){
            int r = l;
            int product = nums[l];
            while(product < k){
                // 满足count就+1
                count++;
                // 右窗口滑动
                r++;
                // 防止数据超标
                if(r == length) break;
                product *= nums[r];
            }
        }
        return count;
    }
}

// 28.实现strStr()
class Solution8 {
    public static int strStr(String haystack, String needle) {
        if(needle==null || needle.equals("")) return 0;
        int length1 = haystack.length();
        int length2 = needle.length();
        for(int i=0;i<length1;i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int flag = 1;
                for(int j=0;j<length2;j++){
                    if((i+j)>=length1 || haystack.charAt(i+j) != needle.charAt(j)){
                        flag = 0;
                        break;
                    }
                }
                if(flag == 1){
                    return i;
                }
            }
        }
        return -1;
    }
}

// 121.买卖股票的最佳时机
class Solution7 {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<length; i++){
            if(prices[i] <= min){
                min = prices[i];
            }else{
                if(prices[i]-min > maxProfit){
                    maxProfit = prices[i]-min;
                }
            }
        }
        return maxProfit;
    }
}

// 9.回文数
class Solution6 {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        else{
            String str = String.valueOf(x);
            int i = 0;
            int j = str.length()-1;
            for(;i<j;i++,j--){
                if(str.charAt(i) != str.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }
}

// 26.删除有序数组中的重复项
// 边界条件是重复数字出现在末尾
class Solution5 {
//    测试代码
//    int[] nums = {1,1,2,2,2,3,4,4,4,4,4,4,4};
//    int k = Solution5.removeDuplicates(nums);
//    System.out.println(k);
//    for(int i=0;i<k;i++){
//        System.out.print(nums[i]+" ");
//    }
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length-1;i++){
            while(nums[i]==nums[i+1] && i<length-1){
                for(int j=i;j<length-1;j++){
                    nums[j] = nums[j+1];
                }
                length--;
            }
        }
        return length;
    }
}

// 94.二叉树的中序遍历(二叉树)
// 二叉树类
class TreeNode {// 这里定义了二叉树结点类，其他地方也可以用了
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
class Solution4 {
    // 二叉树的构建
    // 中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list ,root);
        return list;
    }
    public static void inOrder(List<Integer> list, TreeNode root){
        if(root != null){
            inOrder(list, root.left);
            list.add(root.val);
            inOrder(list, root.right);
        }
    }
}

// 13.罗马数字转整数(哈希表)
class Solution3 {
    public static int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<>();
        symbolValues.put('I', 1);
        symbolValues.put('V', 5);
        symbolValues.put('X', 10);
        symbolValues.put('L', 50);
        symbolValues.put('C', 100);
        symbolValues.put('D', 500);
        symbolValues.put('M', 1000);
        return getInt(symbolValues, s);
    }
    public static int getInt(Map<Character, Integer> symbolValues, String s){
        int sum = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            Character ch = s.charAt(i);
            int value = symbolValues.get(ch);
            if(i<n-1 && value<symbolValues.get(s.charAt(i+1))){// 非常规字符串
                sum -= value;
            }
            else sum += value;// 常规字符串
        }
        return sum;
    }
}

// 21.合并两个有序链表
/*
主函数
    int[] arr1 = {1,2,2,3,6};
    int[] arr2 = {1,3};
    int[] arr3 = {};
    ListNode list1 = Solution2.createLinkedList(arr1);
    ListNode list2 = Solution2.createLinkedList(arr2);
    ListNode list3 = Solution2.createLinkedList(arr3);
    ListNode result1 = Solution2.mergeMethod2(list1, list2);
    Solution2.printLinkedList(result1);
 */
// 链表类
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution2 {
    // 递归法
    public static ListNode mergeMethod2(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        else{
            if(list1.val <= list2.val){
                list1.next = mergeMethod2(list1.next,list2);
                return list1;
            }
            else{
                list2.next = mergeMethod2(list1,list2.next);
                return list2;
            }
        }
    }
    // 迭代法
    public static ListNode mergeMethod1(ListNode list1, ListNode list2) {
        ListNode p = new ListNode();// p是新链表的头节点
        ListNode q = p;// q用于连接各节点
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                q.next = list1;
                q = q.next;
                list1 = list1.next;
            }
            else{
                q.next = list2;
                q = q.next;
                list2 = list2.next;
            }
        }
        q.next = list1==null?list2:list1;
        return p.next;
    }
    // 测试代码：通过一个数组创建一个链表
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;// current指向当前节点，只是作为一个标记，会不断向后移动
        // 把这个迭代想象成一个动画去理解，就很好理解了
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    // 测试代码：打印链表
    public static void printLinkedList(ListNode head){
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
}

// 1.两数之和(哈希表解法)
class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}


