package Leetcode_328_OddEvenLinkedList;

import LinkedList.ListNode;

/*
	����һ�������������е������ڵ��ż���ڵ�ֱ�����һ��
	��ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
	
	�볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������
	
	ʾ�� 1:	
		����: 1->2->3->4->5->NULL
		���: 1->3->5->2->4->NULL
	
	ʾ�� 2:	
		����: 2->1->3->5->6->4->7->NULL 
		���: 2->3->6->7->1->5->4->NULL
		
	˵��:
		Ӧ�����������ڵ��ż���ڵ�����˳��
		����ĵ�һ���ڵ���Ϊ�����ڵ㣬�ڶ����ڵ���Ϊż���ڵ㣬�Դ����ơ�
 */
public class OddEvenLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		// ListNode node8 = new ListNode(8);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		// node7.next = node8;
		OddEvenLinkedList oell = new OddEvenLinkedList();
		oell.oddEvenList(head);
	}

	// 328. ��ż����
	public ListNode oddEvenList(ListNode head) {
		// �ա�һ���ڵ㡢�����ڵ�
		if ((head == null) || (head.next == null) || (head.next.next == null)) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = head.next;
		// ��������odd.next==null
		// ż������even.next = null
		while ((odd.next != null) && (even.next != null)) {
			odd.next = even.next;
			odd = odd.next;
			if (odd == null) {
				// even.next = odd;
				break;
			} else {
				even.next = odd.next;
				even = even.next;
			}
		}

		odd.next = evenHead;

		return head;

	}
}
