package Leetcode_083_RemoveDuplicatesfromSortedList;

import LinkedList.ListNode;

/*
	����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�	
	
	ʾ�� 1:	
		����: 1->1->2
		���: 1->2
		
	ʾ�� 2:	
		����: 1->1->2->3->3
		���: 1->2->3
 */
public class RemoveDuplicatesfromSortedList {
	// 83. ɾ�����������е��ظ�Ԫ��
	public ListNode deleteDuplicates(ListNode head) {
		if ((head == null) || (head.next == null)) {
			return head;
		}
		ListNode cur = head;
		ListNode next = cur.next;
		while (next != null) {
			if (next.val != cur.val) {
				next = next.next;
				cur = cur.next;
			} else {
				cur.next = next.next;
				 next = cur.next;
			}
		}
		return head;
	}
	
	//0ms
    public ListNode deleteDuplicates0(ListNode head) {
        check(head);
        return head;
    }
    
    public void check(ListNode current){
        if(current == null || current.next == null){
            return;
        }
        ListNode next = current.next;
        //��ǰ�ڵ����һ���ڵ��Ƿ����
        if(current.val == next.val){
        	//ɾ��next�ڵ�
            current.next = next.next;
            //������鵱ǰ�ڵ�
            check(current);
        }else{
            check(next);
        }
    }
}
