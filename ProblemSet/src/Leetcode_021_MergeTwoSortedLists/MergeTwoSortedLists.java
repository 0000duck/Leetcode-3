package Leetcode_021_MergeTwoSortedLists;

import LinkedList.ListNode;

/*
	��������������ϲ�Ϊһ���µ������������ء�
	��������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ� 
	
	ʾ����	
		���룺1->2->4, 1->3->4
		�����1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

	// 21. �ϲ�������������

	// �ݹ�
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val <= l2.val) {
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists1(l1, l2.next);
			return l2;
		}
	}

	// ����
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 == null ? l2 : l1;
		return dummy.next;

	}
}
