package Leetcode_234_PalindromeLinkedList;

import LinkedList.ListNode;

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
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(3);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(1);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		PalindromeLinkedList pll = new PalindromeLinkedList();
		pll.isPalindrome(head);
	}

	// 234. ��������
	public boolean isPalindrome(ListNode head) {
		// �սڵ����ֻ��һ���ڵ�
		if ((head == null) || (head.next == null)) {
			return true;
		}
		// �ҵ��м�ڵ�
		// ż�����ڵ� slow.next �Ǻ��ε�head
		// �������ڵ� slow���м�ڵ�
		ListNode fast = head;
		ListNode slow = head;
		while ((fast.next != null) && (fast.next.next != null)) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// ��������ν��з�ת
		ListNode midNode = slow;
		ListNode firNode = slow.next;// ��������ĵ�һ���ڵ�
		ListNode cur = firNode.next;// ����ڵ�ӵ�һ���ڵ����һ����ʼ
		firNode.next = null;// ��һ���ڵ���������һ���ڵ�
		while (cur != null) {
			ListNode nextNode = cur.next;// �����´α����Ľڵ�
			cur.next = midNode.next;
			midNode.next = cur;
			cur = nextNode;
		}

		// ��ת֮���ǰ���ν��бȽ�
		slow = head;
		fast = midNode.next;
		while (fast != null) {
			if (fast.val != slow.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;

	}

	// 0ms
	public boolean isPalindrome0(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		if (head.next.next == null) {
			return head.val == head.next.val;
		}

		ListNode fast = head.next;
		ListNode slow = head;

		while (fast.next != null) {
			// ��ͣ�Ĵ�slow�ĺ�һ����ʼ������֪���ҵ�ֵ��ͬ�Ľڵ�
			// һ����ɺ����ƶ���ԭ�ڵ����һ���ڵ㿪ʼ�������ظ�����Ĳ���
			if (fast.next.val == slow.val) {
				if (fast.next.next != null) {
					return false;
				}
				fast.next = null;
				slow = slow.next;
				fast = slow.next;
				if (fast == null || fast.val == slow.val) {
					return true;
				}
			} else {
				fast = fast.next;
			}
		}
		return false;
	}
}
