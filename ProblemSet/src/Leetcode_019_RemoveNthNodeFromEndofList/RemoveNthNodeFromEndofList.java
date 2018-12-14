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
		int n = 1;
		RemoveNthNodeFromEndofList rnnfel = new RemoveNthNodeFromEndofList();
		rnnfel.removeNthFromEnd(head, n);
	}

	//19. ɾ������ĵ�����N���ڵ�
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// ɾ���ڵ�
		if (n == 1) {
			slow = null;
		} else {
			slow.next = slow.next.next;
		}

		return head;
	}
}
