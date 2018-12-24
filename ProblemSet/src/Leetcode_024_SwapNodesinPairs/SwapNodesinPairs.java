package Leetcode_024_SwapNodesinPairs;

import LinkedList.ListNode;

/*
	����һ���������������������ڵĽڵ㣬�����ؽ����������
	
	ʾ��:	
		���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
	
	˵��:	
		����㷨ֻ��ʹ�ó����Ķ���ռ䡣
		�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 */
public class SwapNodesinPairs {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		SwapNodesinPairs snp = new SwapNodesinPairs();
		snp.swapPairs(head);

	}

	// 24. �������������еĽڵ�
	public ListNode swapPairs(ListNode head) {
		// <=1���ڵ�
		if ((head == null) || (head.next == null)) {
			return head;
		}
		// >=2�ڵ�
		ListNode newHead = new ListNode(0);
		newHead.next = head.next;
		ListNode slow;
		ListNode fast;
		slow = head;
		fast = head.next;
		head = fast.next;
		fast.next = slow;
		slow.next = swapPairs(head);
		return newHead.next;
	}

	// 2ms
	public ListNode swapPairs0(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode tmp;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode pre = h;
		while (pre.next != null && pre.next.next != null) {
			tmp = pre.next;
			pre.next = tmp.next;
			tmp.next = tmp.next.next;
			pre.next.next = tmp;
			pre = tmp;
		}
		return h.next;
	}
}
