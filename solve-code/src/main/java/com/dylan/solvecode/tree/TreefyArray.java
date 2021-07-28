package com.dylan.solvecode.tree;

import apple.laf.JRSUIUtils;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 树化数组
 *
 * @author wudelong
 * @Date 2021/6/29 10:35
 */
public class TreefyArray {


    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5,-1,6,-1,-1,7,8,-1,-1};

        System.out.println(JSONUtil.toJsonStr(treefy(arr)));
        printTree(treefy(arr), 0);
    }

    public static TreeNode treefy(Integer[] arr) {

        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        for (int i = 0; i * 2 + 2 < arr.length; i++) {
            TreeNode temp = deque.poll();
            if (arr[i*2+1] != -1) {
                temp.left = new TreeNode(arr[i*2+1]);
                deque.offer(temp.left);
            }
            if (arr[i * 2 + 2] != -1) {
                temp.right = new TreeNode(arr[i * 2 + 2]);
                deque.offer(temp.right);
            }
        }
        return  root;
    }


    /**
     * 树状打印
     */
    public static void printTree(TreeNode root, int high) {
        if (root == null) {
            return;
        }
        printTree(root.right, high + 1);
        System.out.println(getPlace(high) + root.val);
        printTree(root.left, high +1);

    }

    public  static String getPlace(int n) {
        String str = "";
        for (int i =0; i< n * 2;i++){
            str += " ";
        }
        return str ;
    }
}
