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

        //边界条件不用忘记了
        if(head==null || head.next==null) {
            return true;
        }
        ListNode p = new ListNode(-1);
        ListNode low = p;
        ListNode fast = p;
        p.next = head;
        //快慢指针不断迭代，找到中间节点
        while(fast!=null && fast.next!=null) {
            low = low.next;
            fast = fast.next.next;
        }
        ListNode cur = low.next;
        ListNode pre = null;
        low.next = null;
        low = p.next;
        //将链表一分为二之后，反转链表后半部分
        while(cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        //将链表前半部分和 反转的后半部分对比
        while(pre!=null) {
            if(low.val!=pre.val) {
                return false;
            }
            low = low.next;
            pre = pre.next;
        }
        return true;
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
//删除链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if(fast.val == slow.val) {
            } else {
                slow.next = fast;
              slow = fast;
            }
            fast = fast.next;
        }
        return head;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1==null?node1 = headB:node1.next;
            node2 = node2==null?node2 = headA:node2.next;
        }
        return node1;
    }
//删除重复节点使得每个节点只出现一次
    public ListNode deleteDuplicatess(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            if(runner.val == runner.next.val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }

        }
        return head;

    }
    //删除链表中指定的所有的重复元素
    public ListNode removeElements(ListNode head, int val) {
        if (head == null ) {
            return null;
        }
        ListNode newheader = new ListNode(-1);
        newheader.next = head;
        ListNode preheader = newheader;
        ListNode curheader = head;
        while (curheader != null) {
            if(curheader.val == val) {
                preheader.next = curheader.next;
                curheader = curheader.next;
            } else  {
                preheader = curheader;
                curheader = curheader.next;
            }

        }
        return newheader.next;
    }


}
