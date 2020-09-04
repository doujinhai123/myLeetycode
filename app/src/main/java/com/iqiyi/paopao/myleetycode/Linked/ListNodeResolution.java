package com.iqiyi.paopao.myleetycode.Linked;

import java.util.List;
import java.util.Stack;

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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode result = ListNodeResolution.revertList(listNode);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(0);
        listNode2.next.next = new ListNode(1);

        isPalindrome(listNode2);


    }

    public static boolean isPalindrome(ListNode head) {

        if(head == null) {
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
            now.next =  pre;
            pre = now;
            now  =faster;
            faster = faster.next;
        }
        now.next = pre;

        while (halfpast != null && now != null) {
            if(halfpast.value != now.value) {
                return  false;
            } else {
                halfpast = halfpast.next;
                now = now.next;
            }
        }
        if(halfpast!= null || now != null) {
            return false;
        } else {
            return true;
        }

    }
}
