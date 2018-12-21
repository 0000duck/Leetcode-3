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
		
	}
	// 24. �������������еĽڵ�
	public ListNode swapPairs(ListNode head) {
		// <=1���ڵ�
		if ((head == null) || (head.next == null)) {
			return head;
		}
		// >=2�ڵ�
		ListNode newHead = new ListNode(0);		
		ListNode cur = head;
		newHead.next = cur.next;
		ListNode slow;
		ListNode fast;
		while ((cur != null) && (cur.next != null)) {
			slow = cur;
			fast = cur.next;
			cur = fast.next;
			fast.next = slow;
			slow.next = cur;
		}
		return newHead.next;

	}
}
