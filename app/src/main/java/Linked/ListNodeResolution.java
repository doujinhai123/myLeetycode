package Linked;

import java.util.HashSet;
import java.util.Stack;

public class ListNodeResolution {
    //反转链表
    public static ListNode revertList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode now = head;
        ListNode fast = head.next;
        while (fast != null) {
            now.next = pre;
            pre = now;
            now = fast;
            fast = fast.next;
        }
        now.next = pre;
        return now;
    }
  // 旋转链表
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode faster = head;
        ListNode slower = head;
        ListNode newHeader = slower;
        while (k != 0) {
            faster = faster.next;
            if(faster == null) {
                return head;
            }
            k = k-1;
        }
        while (faster != null && faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }
        newHeader  = slower.next;
        slower.next = null;
        faster.next = head;
        return newHeader;

    }

    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        ListNode post = head.next;
        int n = 0;
        //注意是需要判断到post 不等于空的时候
        while (post != null) {
            now.next = pre;
            pre = now;
            now = post;
            post = post.next;
            n++;
        }
        //注意是now的next 辞职post为null
        now.next = pre;
        int[] res = new int[n + 1];
        int i = 0;
        while (now != null) {
            res[i] = now.val;
            i++;
            now = now.next;
        }

        return res;


    }

    public static boolean isPalindrome(ListNode head) {
        //使用栈解决
        //边界条件不用忘记了
        if (head == null || head.next == null) {
            return true;
        }
        ListNode runner = head;
        Stack<Integer> stack = new Stack<>();
        while (runner != null) {
            stack.push(runner.val);
            runner = runner.next;
        }
        while (!stack.isEmpty()) {
            Integer integer = stack.pop();
            if(integer == head.val) {
                head = head .next;
            } else {
                return false;
            }
        }

        return  true;

//        //边界条件不用忘记了
//        if (head == null || head.next == null) {
//            return true;
//        }
//        ListNode p = new ListNode(-1);
//        ListNode low = p;
//        ListNode fast = p;
//        p.next = head;
//        //快慢指针不断迭代，找到中间节点
//        while (fast != null && fast.next != null) {
//            low = low.next;
//            fast = fast.next.next;
//        }
//        ListNode cur = low.next;
//        ListNode pre = null;
//        low.next = null;
//        low = p.next;
//        //将链表一分为二之后，反转链表后半部分
//        while (cur != null) {
//            ListNode tmp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = tmp;
//        }
//        //将链表前半部分和 反转的后半部分对比
//        while (pre != null) {
//            if (low.val != pre.val) {
//                return false;
//            }
//            low = low.next;
//            pre = pre.next;
//        }
//        return true;
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head;
        ListNode slowRunner = head;
        ListNode fastRunner = head.next;
        if (head.val == val) {
            head = head.next;
            return head;
        }
        while (slowRunner != null && fastRunner != null) {
            if (fastRunner.val == val) {
                slowRunner.next = fastRunner.next;
                break;
            } else {
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next;
            }
        }
        return result;

    }

    //删除链表的倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (n != 0) {
            fast = fast.next;
            n = n - 1;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null) {
            return slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    //删除链表倒数节点变形
    //删除链表的倒数第n个节点
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (n != 0) {
            fast = fast.next;
            n = n - 1;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null) {
            return slow.next;
        }
        return slow.next;
    }

    //删除链表中的所有重复元素，剩余的元素都为非重复的
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? node1 = headB : node1.next;
            node2 = node2 == null ? node2 = headA : node2.next;
        }
        return node1;
    }

    //删除重复节点使得每个节点只出现一次
    public static ListNode deleteDuplicatess(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode runner = head;
        while ( runner.next != null) {
            if (runner.val == runner.next.val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }

        }
        return head;

    }

    //删除链表中指定的所有的重复元素
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newheader = new ListNode(-1);
        newheader.next = head;
        ListNode preheader = newheader;
        ListNode curheader = head;
        while (curheader != null) {
            if (curheader.val == val) {
                preheader.next = curheader.next;
                curheader = curheader.next;
            } else {
                preheader = curheader;
                curheader = curheader.next;
            }

        }
        return newheader.next;
    }
    //判断链表是否有环
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null&&fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }

        return false;

    }
    //合并有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head3 = new ListNode(-1);
        ListNode runner = head3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                runner.next = new ListNode(l1.val);
                runner = runner.next;
                l1 = l1.next;
            } else {
                runner.next = new ListNode(l2.val);
                l2 = l2.next;
                runner = runner.next;
            }
        }
        if (l1 == null) {
            runner.next = l2;
        } else {
            runner.next = l1;
        }
        return head3.next;

    }
    //遍历链表

    public static void foreachListNode(ListNode node) {
        ListNode header = node;
        while (header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }



    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next= new ListNode(4);
        listNode.next.next.next.next.next= new ListNode(4);
        listNode.next.next.next.next.next.next= new ListNode(5);
//        //链表的反转
//        revertList(listNode);
//        //右旋转链表
//        rotateRight(listNode,2);
//        //删除链表到倒数第N个节点
//        removeNthFromEnd1(listNode,4);
//        //删除重复节点，使得每一个节点只出现一次
//        deleteDuplicatess(listNode);
//        //只要节点元素重复，就删除所有的
        ListNode head = deleteDuplicates(listNode);
        foreachListNode(head);

//        //判断链表是否有环
//        hasCycle(listNode);
//        //判断是不是回文链表
//        isPalindrome(listNode);
//        //合并有序链表
//        mergeTwoLists(listNode,listNode);




    }


}
