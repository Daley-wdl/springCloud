package com.dylan.solvecode;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

/**
 * 快排
 * @author wudelong
 * @Date 2021/7/15 14:30
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {4,3,8,6,7,1,5,0};
        int[] nums1 = {-1,-2,-3};

        Arrays.sort(nums);
        quickSort(nums1, 0, nums1.length -1);
        System.out.println(JSONUtil.toJsonStr(nums1));
    }


    public static void quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;


        if (left < right) {
            int tmp = nums[i];
            while (i < j) {

                while (i < j && nums[j] > tmp) {
                    j--;
                }

                nums[i] = nums[j];

                while (i < j && nums[i] < tmp) {
                    i++;
                }
                nums[j] = nums[i];
            }

            nums[i] = tmp;
            System.out.println(JSONUtil.toJsonStr(nums));
            quickSort(nums, left, i-1);
            quickSort(nums, i+1, right);
        }
    }


    /**
     * 有点问题
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort1(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int tmp = nums[i++];

        if(i < j) {
            while (i < j) {
                while(i < j && nums[i] < tmp) {
                    i++;
                }

                while(i < j && nums[j] > tmp) {
                    j--;
                }

                int k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
            }
            nums[i] = tmp;
            System.out.println(JSONUtil.toJsonStr(nums));
            quickSort(nums, left, i-1);
            quickSort(nums, i+1, right);
        }
    }

}
