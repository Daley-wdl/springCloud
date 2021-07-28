package com.dylan.solvecode;

import cn.hutool.json.JSONUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [239] 滑动窗口最大值
 *
 * @author wudelong
 * @Date 2021/6/22 10:11
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(JSONUtil.toJsonStr(maxSlidingWindow(arr, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int rs = 0;

        for (int i =0 ; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.peek() < i - k +1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            if(i >= k -1) {
                result[rs++] = nums[deque.peek()];
            }

        }
        return result;
    }
}
