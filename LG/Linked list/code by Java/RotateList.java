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

		int k = 2;

		RotateList rl = new RotateList();
		System.out.println(rl.getListNodeLength(head));

	}

	// 61. ��ת����
	public ListNode rotateRight(ListNode head, int k) {
		if ((head == null) || (head.next == null)) {
			return head;
		}
		int length = getListNodeLength(head);
		for (int i = 0; i < k % (length - 1); i++) {
			head = rotateOne(head);
		}
		return head;

	}

	// ��ת1��
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

	// ��ȡ������
	private int getListNodeLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	// 7ms
	public ListNode rotateRight0(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		int n = k % len;
		if (n == 0) {
			return head;
		}
		// System.out.println(len);
		int l = len - n - 1;
		ListNode dummy = head, curr = head;
		while (l >= 1) {
			curr = curr.next;
			l--;
		}

		ListNode t = curr.next, res = curr.next;
		curr.next = null;
		while (t.next != null) {
			t = t.next;
		}
		t.next = dummy;
		return res;
	}
}
