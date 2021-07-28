package com.dylan.solvecode;

/**
 * @author wudelong
 * @Date 2021/7/15 16:08
 */
public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {

        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int count = 0;
        int curr = nums[0];

        while (i <= j && j < nums.length -1) {
            if(i == j) {
                if(curr < k) {
                    count++;
                    j++;
                    curr *= nums[j];
                } else {
                    i++;
                    j++;
                }
            } else {
                if(curr < k) {
                    count++;
                    j++;
                    curr *= nums[j];
                } else {
                    curr /= nums[i++];
                }
            }
        }
        return count;
    }
}
