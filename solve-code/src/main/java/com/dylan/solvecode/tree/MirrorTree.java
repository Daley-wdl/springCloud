package com.dylan.solvecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudelong
 * @Date 2021/6/29 10:14
 */
public class MirrorTree {

    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5,-1,6,-1,-1,7,8,-1,-1};
        Integer[] validArr = {5, 3, 8, 1,4,-1, 9};
        System.out.println(mirrorTree(TreefyArray.treefy(arr)));

        System.out.println(isValidTree(TreefyArray.treefy(arr)));
        System.out.println(isValidTree(TreefyArray.treefy(validArr)));
    }


    /**
     * mirror 中序
     *
     * @param root
     * @return
     */
    public static List<Integer> mirrorTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;
        Integer pre = Integer.MIN_VALUE;
        while (curr != null) {

            TreeNode mostRight = curr.left;

            if(mostRight != null) {
                while (mostRight.right != null && mostRight.right != curr) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = curr;
                    curr = curr.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }


    /**
     * 判断是否是有效二叉树
     *
     * @param root
     * @return
     */
    public static boolean isValidTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;
        Integer pre = Integer.MIN_VALUE;
        while (curr != null) {

            TreeNode mostRight = curr.left;

            if(mostRight != null) {
                while (mostRight.right != null && mostRight.right != curr) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = curr;
                    curr = curr.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            if (pre > curr.val) {
                return false;
            }
            pre = curr.val;
            result.add(curr.val);
            curr = curr.right;
        }
        return true;
    }
}
