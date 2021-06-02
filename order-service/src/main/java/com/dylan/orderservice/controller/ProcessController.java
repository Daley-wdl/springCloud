package com.dylan.orderservice.controller;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author wudelong
 * @Date 2021/6/1 11:13
 */
public class ProcessController {

    public static void main(String[] args) {



        int[] nums = {3,2,5,4, 6,7,8};
        System.out.println(partitionDisjoint(nums));

        Stack<Integer> stack = new Stack<>();
        Integer peek = stack.peek();


        List<Integer> objects = Lists.newArrayList();


        Deque<Object> deque = new LinkedList<>();
        deque.peek();


    }


    public static int partitionDisjoint(int[] A) {
        int cmax = A[0]; //cmax:current maximum
        int nmax = A[0];//nmax: next maximum
        int ans = 0;

        for (int i = 1; i < A.length; i++) {
            int val = A[i];
            nmax = Math.max(val, nmax); //next max for case if i exist in left Part

            if (val < cmax) {
                ans = i;         //now left Part is till here
                cmax = nmax; //maximum of left array is nmax(as we are maintaining maximum for split Part)
            }
        }
        return ans + 1; // we have to return length not idx so ans+1.
    }

}
