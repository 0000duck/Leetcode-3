package Leetcode_086_PartitionList;

import LinkedList.ListNode;

/*
	����һ�������һ���ض�ֵ x����������зָ���
	ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
	
	��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
	
	ʾ��:	
		����: head = 1->4->3->2->5->2, x = 3
		���: 1->2->2->4->3->5
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/partition-list
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

//86. �ָ����� ע���ж�β��
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode before_head = new ListNode(0);
		ListNode before = before_head;
		ListNode after_head = new ListNode(0);
		ListNode after = after_head;

		while (head != null) {
			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		// ��ֹ���滹��С��x�Ľڵ�
		after.next = null;

		before.next = after_head.next;
		return before_head.next;

	}
}
