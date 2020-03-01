package Leetcode_019_RemoveNthNodeFromEndofList;

import LinkedList.ListNode;

/*
	����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
	
	ʾ����	
		����һ������: 1->2->3->4->5, �� n = 2.
	
		��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
	
	˵����	
		������ n ��֤����Ч�ġ�
	
	���ף�	
		���ܳ���ʹ��һ��ɨ��ʵ����
 */
public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		int n = 1;
		RemoveNthNodeFromEndofList rnnfel = new RemoveNthNodeFromEndofList();
		rnnfel.removeNthFromEnd(head, n);
	}

	// 19. ɾ������ĵ�����N���ڵ�
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head;
		ListNode fast = head;
		int fastIndex = 0;
		for (int i = 0; i <= n && fast != null; i++) {
			fastIndex++;
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			fastIndex++;
		}
		// ɾ���ڵ�
		if (fastIndex == n) {
			head = head.next;
		} else if (n == 1) {
			slow.next = null;
		} else {
			slow.next = slow.next.next;
		}

		return head;
	}

	// 7ms
	public ListNode removeNthFromEnd0(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;

		ListNode slow = new ListNode(0);
		ListNode fast = new ListNode(0);
		slow.next = head;
		fast.next = head;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		if (fast.next == null) {
			head = head.next;
			return head;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return head;
	}
}
