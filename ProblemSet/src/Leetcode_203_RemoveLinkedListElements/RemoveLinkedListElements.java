package Leetcode_203_RemoveLinkedListElements;

import LinkedList.ListNode;

/*
	ɾ�������е��ڸ���ֵ val �����нڵ㡣
	
	ʾ��:	
		����: 1->2->6->3->4->5->6, val = 6
		���: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		// ListNode node5 = new ListNode(4);
		// ListNode node6 = new ListNode(5);
		// ListNode node7 = new ListNode(6);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		// node4.next = node5;
		// node5.next = node6;
		// node6.next = node7;

		RemoveLinkedListElements rlle = new RemoveLinkedListElements();
		rlle.removeElements(head, 6);
	}

	// 203. �Ƴ�����Ԫ��
	public ListNode removeElements(ListNode head, int val) {
		// ������
		if (head == null) {
			return null;
		}
		// ֻ��һ���ڵ�
		if (head.next == null) {
			if (head.val == val) {
				return null;
			} else {
				return head;
			}
		}
		// ���������������ϵĽڵ�
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		while ((newHead != null) && (newHead.next != null)) {
			if (newHead.next.val != val) {
				newHead = newHead.next;
			} else {
				if (newHead.next == head) {
					head = head.next;
					newHead.next = head;
				} else {
					newHead.next = newHead.next.next;
				}

			}
		}

		return head;

	}

	// 3ms
	public ListNode removeElements0(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		while (head.next != null) {
			if (head.next.val == val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}
}
