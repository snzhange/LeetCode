package com.snzhange.leetcode;

import com.snzhange.leetcode.model.ListNode;
import org.junit.Test;

public class Solution_201_250 {

    @Test
    public void test_234() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        a.next = b;
        ListNode c = new ListNode(0);
        b.next = c;
        System.out.println(this.isPalindrome(a));
    }

    private boolean isPalindrome(ListNode head) {
        if (null == head) {
            return false;
        }

        // 定义遍历过程中的当前节点，用于反转链表的temp节点
        ListNode curr = head, temp;
        // 遍历计算链表总长度
        int length = 1;
        while (null != curr.next) {
            length++;
            curr = curr.next;
        }

        // 重置当前节点
        curr = head;
        // 反转head到1/2长度位置的子链，结果为head引用反转后的前半段子链，curr引用后半段子链
        head = null;
        for (int i = 0; i < length / 2; i++) {
            temp = curr.next;
            curr.next = head;
            head = curr;
            curr = temp;
        }

        // 如果总长度为奇数，后半段子链需要把总链表中间节点去掉
        if (length % 2 == 1) {
            curr = curr.next;
        }
        // 同时遍历head和curr两条子链，一一对比
        while (null != head && null != curr) {
            if (head.val != curr.val) {
                return false;
            }
            head = head.next;
            curr = curr.next;
        }
        return true;
    }

}
