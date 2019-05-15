package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by YellowHuang on 2019/5/14.
 */

public class 删除单链列表中重复的数 {

    public static class ListNode {

        private ListNode next;
        private int value;

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    /**
     * Input: 1->1->2
     * Output: 1->2
     * <p>
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     */
    public static void solution(ListNode node) {
        ListNode temp = node;
        while (temp != null && temp.next != null) {
            ListNode nextListNode = temp.next;
            if (temp.value == nextListNode.value) {
                ListNode next = nextListNode.next;
                temp.next = next;
            }
            temp = temp.next;
            continue;

        }

        System.out.print(getListNodeValue(node));
    }

    static String getListNodeValue(ListNode node) {
        if (node == null) return "";
        StringBuilder str = new StringBuilder(node.value + "");
        if (node.next != null) {
            str = str.append(getListNodeValue(node.next));
        }
        return str.toString();
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 1;
        ListNode listNode3 = new ListNode();
        listNode3.value = 2;
        listNode2.next = listNode3;
        listNode1.next = listNode2;

        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        listNode4.value = 3;
        listNode5.value = 3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        solution(listNode1);
    }

}
