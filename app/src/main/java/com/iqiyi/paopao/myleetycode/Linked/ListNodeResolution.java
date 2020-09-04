package com.iqiyi.paopao.myleetycode.Linked;

public class ListNodeResolution {


    public static ListNode revertList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        ListNode post = head.next;
        //注意是需要判断到post 不等于空的时候
        while (post != null) {
            now.next = pre;
            pre = now;
            now = post;
            post = post.next;
        }
        //注意是now的next 辞职post为null
        now.next = pre;
        return now;


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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        deleteNode(listNode, 5);
//        ListNode result = ListNodeResolution.revertList(listNode);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }
//        ListNode listNode2 = new ListNode(1);
//        listNode2.next = new ListNode(0);
//        listNode2.next.next = new ListNode(1);
//
//        isPalindrome(listNode2);


    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode halfpast = slow.next;
        slow.next = null;


        ListNode pre = null;
        ListNode now = head;
        ListNode faster = head.next;
        while (faster != null) {
            now.next = pre;
            pre = now;
            now = faster;
            faster = faster.next;
        }
        now.next = pre;

        while (halfpast != null && now != null) {
            if (halfpast.val != now.val) {
                return false;
            } else {
                halfpast = halfpast.next;
                now = now.next;
            }
        }
        if (halfpast != null || now != null) {
            return false;
        } else {
            return true;
        }

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
    public ListNode removeNthFromEnd1(ListNode head, int n) {
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

}
