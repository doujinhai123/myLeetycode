package com.iqiyi.paopao.myleetycode.tree;

import com.iqiyi.paopao.myleetycode.Linked.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {
   ArrayList arrayList = new ArrayList();
   public static void main(String[] args) {
       TreeNode treeNode = new TreeNode(3);
       treeNode.left = new TreeNode(9);
       treeNode.right = new TreeNode(20);
       treeNode.left.left = null;
       treeNode.left.right = null;
       treeNode.right.left = new TreeNode(15);
       treeNode.right.right = new TreeNode(7);
       levelOrderwwzhilist(treeNode);

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
//    //二叉树的后序遍历
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null) {
//            return arrayList;
//        }
//        inorderTraversal(root.left);
//        inorderTraversal(root.right);
//        arrayList.add(root.val);
//        return arrayList;
//
//    }
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


    //二叉树的层序遍历
    public List<List<Integer>> levelOrderww(TreeNode root) {
        List<List<Integer>>  result = new ArrayList<>();
        if(root == null) {
            return  result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;

    }


    //二叉树的之字形打印
    public static void levelOrderwwzhi(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty()||!stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode treeNode = stack1.pop();
                System.out.println(treeNode.val);
                if(treeNode.left != null) {
                    stack2.push(treeNode.left);
                }
                if(treeNode.right!= null) {
                    stack2.push(treeNode.right);
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode treeNode = stack2.pop();
                System.out.println(treeNode.val);
                if(treeNode.right != null) {
                    stack1.push(treeNode.right);
                }
                if(treeNode.left != null) {
                    stack1.push(treeNode.left);
                }
            }
        }

    }

    //二叉树的之字形打印
    public static List<List<Integer>> levelOrderwwzhilist(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();

        Stack<TreeNode> stack1  = new Stack<>();
        stack1.add(root);
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> allist = new LinkedList<>();
            while (!stack1.isEmpty()) {
                TreeNode val = stack1.pop();
                allist.add(val.val);
                if(val.left != null) {
                    stack2.push(val.left);
                }
                if(val.right != null) {
                    stack2.push(val.right);
                }
            }
            if(allist.size() > 0) {
                lists.add(allist);
            }
            List<Integer> bllist = new LinkedList<>();
            while (!stack2.isEmpty()) {
                TreeNode val = stack2.pop();
                bllist.add(val.val);
                if(val.right != null) {
                    stack1.push(val.right);
                }
                if(val.left != null) {
                    stack1.push(val.left);
                }
            }
            if(bllist.size() > 0) {
                lists.add(bllist);
            }


        }
        return lists;

    }
    //二叉树的深度
    public int maxDepth(TreeNode root) {
       if(root == null) {
           return 0;
       }
       int leftdepth = maxDepth(root.left) +1;
       int rightdepth = maxDepth(root.right) + 1;
       return leftdepth > rightdepth? leftdepth:rightdepth;

    }
    //二叉树深度非递归
    public int maxDepthss(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       int n = 0;
       while (!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll();
               System.out.println(node.val);
               if(node.left != null) {
                   queue.add(node.left);
               }
               if(node.right != null) {
                   queue.add(node.right);
               }
           }
           n = n + 1;
       }
       return n;
    }


}