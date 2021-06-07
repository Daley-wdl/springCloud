package com.dylan.orderservice.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author wudelong
 * @Date 2021/6/1 11:13
 */
public class ProcessController {

    public static void main(String[] args) {



        int[] nums = {3,2,5,4, 6,7,8};
//        System.out.println(partitionDisjoint(nums));

        /**
         *               5
         *              / \
         *             4   8
         *            /   / \
         *           11  13  4
         *          /  \    / \
         *         7    2  5   1
         */

        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4, new TreeNode(5), new TreeNode(1));

        List<List<Integer>> result = Lists.newArrayList();
        if(0 == 0) {
            System.out.println(JSONUtil.toJsonStr(result));
        }
        process(root, 0, new ArrayList<>(), result);
        System.out.println(JSONUtil.toJsonStr(result));
    }

    public static void process(TreeNode root, int current, List<Integer> list, List<List<Integer>> result){

        if(current < 0) {
            return;
        }

        if(current == 0) {
            System.out.println(JSONUtil.toJsonStr(list));
            result.add(new ArrayList<>(list));
            return;
        }

        if(root == null){
            return;
        }

        if(current - root.val >= 0) {
            list.add(root.val);
            /**
             * root current left right
             * 2
             */
            if(root.left == null && root.right == null){
                process(root.left, current - root.val, list, result);
            } else {
                process(root.left, current - root.val, list, result);
                process(root.right, current - root.val, list, result);
            }
            list.remove(list.size() -1);
        }
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

       public static class TreeNode {
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

}
