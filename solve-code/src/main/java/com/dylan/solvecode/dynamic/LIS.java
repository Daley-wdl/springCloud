package com.dylan.solvecode.dynamic;

/**
 * 最长递增子序列
 *
 * @author wudelong
 * @Date 2021/7/24 22:48
 */
public class LIS {

    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(process(arr, getDp(arr)));
    }



    public static int[] getDp(int[] arr) {

        int[] dp = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] process(int[] arr, int[] dp) {

        int len = 0;
        int index = 0;

        for(int i =0; i< dp.length; i++){
            if(dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }

        int[] result = new int[len];
        result[--len] = arr[index];

        for(int i = index; i>=0; i--) {

            if(arr[i] < arr[index] && ((dp[i] + 1) == dp[index])) {
                result[--len] = arr[i];
                index = i;
            }
        }
        return result;
    }

}
