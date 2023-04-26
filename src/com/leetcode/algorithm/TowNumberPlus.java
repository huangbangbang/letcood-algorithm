package com.leetcode.algorithm;

import java.util.Objects;

/**
 * @author Huang Bangbang
 * @date 2023/4/26 - 15:39
 */
public class TowNumberPlus {
    public static void main(String[] args) {
        TowNumberPlus towNumberPlus = new TowNumberPlus();
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next= new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6) ;
        node2.next.next = new ListNode(4);
        ListNode result = towNumberPlus.addTwoNumbers(node1, node2);
        System.out.println(result);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        operation(l1,l2,result,0);
        return result;
    }


    public boolean operation(ListNode l1, ListNode l2,ListNode node,int modResult ) {
        if (null == l1 && null == l2 && modResult ==0) {
            return false;
        }
        if (null == l1 && null == l2 && modResult !=0) {
            node.val = 1;
            return true;
        }
        int mod = 0;
        int result = 0;

        if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            mod = (l1.val + l2.val +modResult) / 10;
            result = (l1.val + l2.val +modResult) % 10;
        } else if (Objects.isNull(l1)) {
            mod = (l2.val + modResult)/10;
            result = (l2.val + modResult)%10;
        } else {
            mod = (l1.val + modResult)/10;
            result = (l1.val + modResult)%10;
        }
        node.val = result;
        if (Objects.nonNull(l1)){
            l1 = l1.next;
        }
        if (Objects.nonNull(l2)){
            l2 = l2.next;
        }
        node.next = new ListNode();
        boolean operation = operation(l1, l2, node.next, mod);
        if (!operation){
            node.next = null;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
