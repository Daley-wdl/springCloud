package com.dylan.lettcode;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [829] 连续整数求和
 *
 * @author wudelong
 * @Date 2021/6/4 17:49
 */
public class ConsecutiveNumbersSum {


    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(43156417));
    }

    /**
     * 这种方式会提交会超时
     *
     * @param n
     * @return
     */
    public static int consecutiveNumbersSum(int n) {

        List<Integer> list = new ArrayList(n);
        List<List<Integer>> result = new ArrayList();
        result.add(list);

        if(n <= 2) return 1;
        // n = 5
        int start = 1;
        int end = 2;
        int sum = start + end;
        Deque<Integer> deque = new LinkedList();
        deque.offer(start); deque.offer(end);

        while(start < end){
            if(sum == n ) {
                result.add(new ArrayList(deque));
                sum -= deque.poll();
                start++;
            } else if(sum < n) {
                end++;
                sum += end;
                deque.offer(end);
            } else if(sum > n) {
                sum -= deque.poll();
                start++;
            }
        }
        System.out.println(JSONUtil.toJsonStr(result));
        return result.size();
    }

}
