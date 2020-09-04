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
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        ListNode now = slow;
        ListNode faster = slow.next;
        while (faster != null) {
            now.next = pre;
            pre = now;
            now = faster;
            faster = faster.next;
        }
        now.next = pre;

        while (now != null && head != null) {
            if (now.value != head.value) {
                return false;
            } else {
                now = now.next;
                head = head.next;
            }
        }
        if (now == null && head == null) {
            return true;
        }
        return false;


    }
}
