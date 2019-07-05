package Leetcode_203_RemoveLinkedListElements;

import LinkedList.ListNode;

/*
	ɾ�������е��ڸ���ֵ val �����нڵ㡣
	
	ʾ��:	
		����: 1->2->6->3->4->5->6, val = 6
		���: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

	// 203. �Ƴ�����Ԫ��
	// ��ͷ
	public ListNode removeElements2(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0);// ��ͷ
		dummyHead.next = head;
		ListNode cur = dummyHead;

		while (cur.next != null) {
			if (cur.next.val == val) {
				ListNode delNode = cur.next;
				cur.next = delNode.next;
				delNode.next = null;
			} else {
				cur = cur.next;
			}
		}
		head = dummyHead.next;
		dummyHead.next = null;// ��ԭԭ���Ľṹ
		return head;
	}

}
