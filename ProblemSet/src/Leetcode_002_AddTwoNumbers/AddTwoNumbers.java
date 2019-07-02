package Leetcode_002_AddTwoNumbers;

import LinkedList.ListNode;

/*
	�������� �ǿ� ������������ʾ�����Ǹ���������
	���У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�	
	��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�	
	�����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
	
	ʾ����	
		���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
		�����7 -> 0 -> 8
		ԭ��342 + 465 = 807
 */
public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		// ListNode node3 = new ListNode(8);
		l1.next = node1;
		node1.next = node2;
		// node2.next = node3;
		ListNode l2 = new ListNode(5);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(4);
		l2.next = node4;
		node4.next = node5;
		AddTwoNumbers atn = new AddTwoNumbers();
		atn.addTwoNumbers(l1, l2);
	}

	// 2. �������
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int flag = 0;// ��λ��־��
		ListNode preHead = new ListNode(0);// ��ͷ
		ListNode curNode = preHead;
		while (l1 != null || l2 != null || flag != 0) {
			int a = l1 == null ? 0 : l1.val;
			l1 = l1 == null ? null : l1.next;

			int b = l2 == null ? 0 : l2.val;
			l2 = l2 == null ? null : l2.next;

			int val = a + b + flag;

			curNode.next = new ListNode(val % 10);
			curNode = curNode.next;

			flag = val / 10;
		}
		return preHead.next;
	}

}
