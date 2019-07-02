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

	// �ݹ�
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		ListNode next = head.next.next;
		newHead.next = head;
		head.next = swapPairs(next);
		return newHead;
	}

	// ����
	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			ListNode node1 = pre.next;
			ListNode node2 = node1.next;
			ListNode next = node2.next;

			pre.next = node2;
			node2.next = node1;
			node1.next = next;
			pre = node1;
		}
		return dummy.next;
	}
}
