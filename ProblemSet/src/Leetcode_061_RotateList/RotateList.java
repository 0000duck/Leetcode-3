package Leetcode_061_RotateList;

import LinkedList.ListNode;

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

	// 61. ��ת����
	public ListNode rotateRight(ListNode head, int k) {
		if ((head == null) || (head.next == null)) {
			return head;
		}
		for (int i = 0; i < k; i++) {
			head = rotateOne(head);
		}
		return head;

	}

	//��ת1��
	public ListNode rotateOne(ListNode head) {
		ListNode headnext = head;
		while (head.next.next != null) {
			head = head.next;
		}
		ListNode last = head.next;
		head.next = null;
		last.next = headnext;
		head = last;

		return head;

	}
}
