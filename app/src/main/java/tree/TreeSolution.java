package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class TreeSolution {
    ArrayList arrayList = new ArrayList();

    public static void main(String[] args) {
        String sss = "هوديس وبلوزات للرجال";
       String[] result = sss.split(" ");

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        TreeSolution solution = new TreeSolution();
        System.out.println(solution.levelOrderwwzhilist(treeNode));
//        int valuer = lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(6)).val;
//        System.out.println(valuer);


    }

    //二叉树的前学
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return arrayList;
        }
        arrayList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return arrayList;
    }

    //二叉树的前序递归
    public List<Integer> preorder22Traversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (root == null) {
            return arrayList;
        }
        arrayList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return arrayList;
    }


    //二叉树的后序非递归 根左右  变为根右左  在变为左右跟
    public List<Integer> lastTraversalfeidigui(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<TreeNode> stackresult = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            stackresult.push(treeNode);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

        }
        while (!stackresult.isEmpty()) {
            arrayList.add(stackresult.pop().val);
        }
        return arrayList;

    }

    //二叉树的中序非递归遍历
    public List<Integer> midllefeidigui(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            arrayList.add(root.val);
            root = root.right;
        }
        return arrayList;

    }

    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return arrayList;
        }
        inorderTraversal(root.left);
        arrayList.add(root.val);
        inorderTraversal(root.right);

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
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        int[] reslt = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            reslt[i] = arrayList.get(i);
        }
        return reslt;
    }


    //二叉树的层序遍历
    public List<List<Integer>> levelOrderww(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;

    }

    //二叉树的层序
    //二叉树的层序遍历
    public static void levelOrderwwvoid(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }


    //二叉树的之字形打印
    public static void levelOrderwwzhi(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode treeNode = stack1.pop();
                System.out.println(treeNode.val);
                if (treeNode.left != null) {
                    stack2.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    stack2.push(treeNode.right);
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode treeNode = stack2.pop();
                System.out.println(treeNode.val);
                if (treeNode.right != null) {
                    stack1.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack1.push(treeNode.left);
                }
            }
        }

    }

    //二叉树的之字形打印
    public static ArrayList<ArrayList<Integer>> levelOrderwwzhilist(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root == null) {
            return lists;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.add(root);
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> allist = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode val = stack1.pop();
                allist.add(val.val);
                if (val.left != null) {
                    stack2.push(val.left);
                }
                if (val.right != null) {
                    stack2.push(val.right);
                }
            }
            if (allist.size() > 0) {
                lists.add(allist);
            }
            ArrayList<Integer> bllist = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode val = stack2.pop();
                bllist.add(val.val);
                if (val.right != null) {
                    stack1.push(val.right);
                }
                if (val.left != null) {
                    stack1.push(val.left);
                }
            }
            if (bllist.size() > 0) {
                lists.add(bllist);
            }


        }
        return lists;

    }

    //二叉树的深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = maxDepth(root.left) + 1;
        int rightdepth = maxDepth(root.right) + 1;
        return leftdepth > rightdepth ? leftdepth : rightdepth;

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
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            n = n + 1;
        }
        return n;
    }

    //是否为对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isLeftEqualRight(root.left, root.right);

    }

    public boolean isLeftEqualRight(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }

        return isLeftEqualRight(leftNode.left, rightNode.right) && isLeftEqualRight(leftNode.right, rightNode.left);
    }

    //是否为对称二叉树非递归
    //是否为对称二叉树aa
    public boolean isSymmetricaa(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (right == null || left == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;

    }


    //输入二叉树的镜像
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    ;

    //判断是否为平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftlENGTH = getlength(root.left);
        int rightLength = getlength(root.right);
        if (Math.abs(leftlENGTH - rightLength) > 1) {
            return false;
        } else {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }

    }

    private int getlength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getlength(root.left) + 1;
        int right = getlength(root.right) + 1;
        if (left > right) {
            return left;
        } else {
            return right;
        }

    }

    //二叉搜索的第K大的节点
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> arrayList = (ArrayList) midllefeidigui(root);

        return arrayList.get(arrayList.size() - 1);

    }

    ;

    //二叉树的所有路径
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }

        getTree(root, new StringBuilder());
        return res;
    }

    private void getTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        sb.append("->");
        getTree(root.left, new StringBuilder(sb));
        getTree(root.right, new StringBuilder(sb));

    }

    //二叉树的所有路径
    public static List<List<Integer>> binaryTreePathsall(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if (root == null) {
            return allPaths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<List<Integer>> pathQueue = new LinkedList<List<Integer>>();

        nodeQueue.offer(root);
        List<Integer> rootList = new LinkedList<>();
        rootList.add(root.val);
        pathQueue.offer(rootList);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            List<Integer> pollList = pathQueue.poll();

            if (node.left == null && node.right == null) {
                allPaths.add(pollList);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(pollList);
                    temp.add(node.left.val);
                    pathQueue.offer(temp);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(pollList);
                    temp.add(node.right.val);
                    pathQueue.offer(temp);
                }
            }
        }
        return allPaths;
    }

    //二叉树某一和的路径
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if (root == null) {
            return allPaths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<List<Integer>> pathQueue = new LinkedList<List<Integer>>();

        nodeQueue.offer(root);
        List<Integer> rootList = new LinkedList<>();
        rootList.add(root.val);
        pathQueue.offer(rootList);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            List<Integer> pollList = pathQueue.poll();

            if (node.left == null && node.right == null) {
                int temp = 0;
                for (int i = 0; i < pollList.size(); i++) {
                    temp = temp + pollList.get(i);
                }
                if (temp == sum) {
                    allPaths.add(pollList);
                }
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(pollList);
                    temp.add(node.left.val);
                    pathQueue.offer(temp);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(pollList);
                    temp.add(node.right.val);
                    pathQueue.offer(temp);
                }
            }
        }

        return allPaths;
    }

    //二叉搜索数的最近公共祖先
    public TreeNode lowestSearchCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode  header = root;

        while (true) {
            if(p.val < header.val && q.val < header.val) {
                 header = header.left;
            } else if(p.val > header.val && q.val > header.val) {
                header = header.right;
            } else  {
                return header;
            }
        }

    }
      //二叉树最近公共祖先
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println("sssssssssssssss" + node.val);
            if (node.left != null) {
                queue.add(node.left);
                hashMap.put(node.left.val, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                hashMap.put(node.right.val, node);
            }
        }
        while (p != null) {
            hashSet.add(p.val);
            p = hashMap.get(p.val);
        }
        while (q != null) {
            if (hashSet.contains(q.val)) {
                return q;
            } else {
                q = hashMap.get(q.val);
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : hashMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().val);


        }
        return null;
    }
}