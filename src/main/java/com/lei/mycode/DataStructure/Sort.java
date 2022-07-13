package com.lei.mycode.DataStructure;


import javax.print.attribute.standard.SheetCollate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {100,22,-3,4,95};
        long startTime = System.nanoTime();
        BubbleSort(arr);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        System.out.println(Arrays.toString(arr));
    }

    // 1.简单选择排序
    public static void ChooseSort(int[] arr){
        int length = arr.length;
        for(int i=0; i<length; i++){
            int min = arr[i];
            for(int j=i+1;j<length;j++){
                if(arr[j] < min){
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }

    // 2.直接插入排序
    public static void InsertSort(int[] arr){
        int length = arr.length;
        for(int i=1; i<length; i++){
            int temp = arr[i];// 从前往后确定哨兵，然后从后往前插入
            for(int j=i-1; j>=0&&arr[j]>temp; j--){
                arr[j+1] = arr[j];
                arr[j] = temp;// 将哨兵插入至当前位置
            }
        }
    }

    // 3.希尔排序(缩小增量法)
    public static void ShellSort(int[] arr){
        int length = arr.length;
        int gap = length/2;// 初始gap
        while(gap > 0){
            for(int i=0;i<length;i++){
                for(int j=i+gap;j<length;j+=gap){
                    int temp = arr[j];
                    for(int k=j-gap; k>=0&&arr[k]>temp; k-=gap){
                        arr[k+gap] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
            gap /= 2;
        }
    }

    // 4.冒泡排序
    public static void BubbleSort(int[] arr){
        int length = arr.length;
        if(arr==null || length<2){
            return;
        }
        for(int i=0; i<length-1; i++){
            boolean sorted = true;
            for(int j=0; j<length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    sorted = false;
                }
            }
            if(sorted) break;
        }
    }

    // 5.快速排序
    public static void QuickSort(int[] arr){

    }
}
