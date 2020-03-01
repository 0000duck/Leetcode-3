package Leetcode_206_ReverseLinkedList;

import LinkedList.ListNode;

/*
	��תһ��������
	
	ʾ��:	
		����: 1->2->3->4->5->NULL
		���: 5->4->3->2->1->NULL
	����:
		����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿
 */
public class ReverseLinkedList {
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
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.reverseList1(head);
	}

	// 206. ��ת����

	// �ݹ�
	public ListNode reverseList1(ListNode head) {
		// û�нڵ����ֻ��һ���ڵ�
		if (head == null || head.next == null) {
			return head;
		}
		//
		ListNode newHead = reverseList1(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	// ����
	public ListNode reverseList2(ListNode head) {
		// �±�βpre
		ListNode pre = null;
		// �±�ͷ
		ListNode next = null;
		while (head != null) {
			// �±�ͷ
			next = head.next;
			// �ɱ�ͷָ���±�β
			head.next = pre;

			pre = head;
			head = next;
		}
		return pre;
	}
}
