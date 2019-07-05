package Leetcode_061_RotateList;

import LinkedList.ListNode;
import LinkedList.ListNodeUtils;

/*
	����һ��������ת����������ÿ���ڵ������ƶ� k ��λ�ã����� k �ǷǸ�����
	
	ʾ�� 1:	
		����: 1->2->3->4->5->NULL, k = 2
		���: 4->5->1->2->3->NULL
	����:
		������ת 1 ��: 5->1->2->3->4->NULL
		������ת 2 ��: 4->5->1->2->3->NULL
	
	ʾ�� 2:	
		����: 0->1->2->NULL, k = 4
		���: 2->0->1->NULL
	����:
		������ת 1 ��: 2->0->1->NULL
		������ת 2 ��: 1->2->0->NULL
		������ת 3 ��: 0->1->2->NULL
		������ת 4 ��: 2->0->1->NULL
 */
public class RotateList {
	public static void main(String[] args) {
		ListNode head = ListNodeUtils.creatNode(new int[] { 1 }, 1);
		ListNodeUtils.printList(head);
		head = new RotateList().rotateRight(head, 0);
		ListNodeUtils.printList(head);

	}

	// 61. ��ת����
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode p = head;

		int length = 0;
		while (p != null) {
			++length;
			p = p.next;
		}
		k %= length;
		if (k == 0) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		p = dummy;
		ListNode q = dummy;

		for (int i = 0; i < k; i++) {
			q = q.next;
		}

		while (q.next != null) {
			p = p.next;
			q = q.next;
		}

		dummy.next = p.next;
		p.next = null;
		q.next = head;

		return dummy.next;
	}
}
