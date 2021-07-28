package com.dylan.solvecode.tree;

/**
 * 共用树节点
 *
 * @author wudelong
 * @Date 2021/6/29 10:36
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
