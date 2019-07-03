package Leetcode_234_PalindromeLinkedList;

import LinkedList.ListNode;
import LinkedList.ListNodeUtils;

/*
	���ж�һ�������Ƿ�Ϊ��������
	
	ʾ�� 1:	
		����: 1->2
		���: false
	
	ʾ�� 2:	
		����: 1->2->2->1
		���: true
	
	���ף�
		���ܷ��� O(n) ʱ�临�ӶȺ� O(1) �ռ临�ӶȽ�����⣿
 */
public class PalindromeLinkedList {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1 };
		System.out.println("length:" + arr.length);

		ListNode head = ListNodeUtils.creatNode(arr, arr.length);
		ListNodeUtils.printList(head);
		PalindromeLinkedList pll = new PalindromeLinkedList();
		System.out.println(pll.isPalindrome(head));

	}

	// 234. ��������
	public boolean isPalindrome(ListNode head) {
		ListNode end = head;
		ListNode mid = head;
		// �ҵ��е�
		int halfLength = 0;
		while (end != null && end.next != null) {
			halfLength++;
			mid = mid.next;
			end = end.next.next;
		}
		System.out.println("halfLength:" + halfLength);
		// ��ת���Σ�midΪͷ��㣩
		ListNode nextHead = reverseList(mid);
		ListNodeUtils.printList(nextHead);
		// �Ƚ�
		for (int i = 0; i < halfLength; i++) {
			if (head.val != nextHead.val) {
				return false;
			}
			head = head.next;
			nextHead = nextHead.next;
		}
		return true;
	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;

			pre = head;
			head = next;
		}
		return pre;
	}

}
