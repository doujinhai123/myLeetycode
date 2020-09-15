package com.iqiyi.paopao.myleetycode.tree;

import com.iqiyi.paopao.myleetycode.Linked.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
   ArrayList arrayList = new ArrayList();
   public void main(String[] args) {
       TreeNode treeNode = new TreeNode(0);
       treeNode.left = new TreeNode(1);
       treeNode.right = new TreeNode(2);
       treeNode.left.left = null;
       treeNode.left.right = null;
       treeNode.right.left = new TreeNode(3);
       treeNode.right.right = new TreeNode(4);

   }
   //二叉树的前学
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return arrayList;
        }
        arrayList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return arrayList;
    }
    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return arrayList;
        }
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        arrayList.add(root.val);
        return arrayList;

    }
    //二叉树的后序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return arrayList;
        }
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        arrayList.add(root.val);
        return arrayList;

    }
    //二叉树的层序遍历
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList();
        if(root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

        }
        int[] reslt = new int[arrayList.size()];

        for (int i = 0; i <arrayList.size() ; i++) {
            reslt[i] = arrayList.get(i);
        }
        return reslt;







    }


}