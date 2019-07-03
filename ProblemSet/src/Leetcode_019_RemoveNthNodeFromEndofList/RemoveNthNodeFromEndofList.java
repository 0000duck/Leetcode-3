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
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		ListNode q = dummy;
		for (int i = 0; i <= n && q != null; i++) {
			q = q.next;
		}

		while (q != null) {
			p = p.next;
			q = q.next;
		}

		p.next = p.next.next;

		return dummy.next;
	}

}
