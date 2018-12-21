package Leetcode_237_DeleteNodeinaLinkedList;

import LinkedList.ListNode;

/*
	���дһ��������ʹ�����ɾ��ĳ�������и����ģ���ĩβ���ڵ㣬�㽫ֻ������Ҫ��ɾ���Ľڵ㡣
	
	����һ������ -- head = [4,5,1,9]�������Ա�ʾΪ:
	
	    4 -> 5 -> 1 -> 9
	
	ʾ�� 1:	
		����: head = [4,5,1,9], node = 5
		���: [4,1,9]
		����: ������������ֵΪ 5 �ĵڶ����ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 1 -> 9.
	
	ʾ�� 2:	
		����: head = [4,5,1,9], node = 1
		���: [4,5,9]
		����: ������������ֵΪ 1 �ĵ������ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 5 -> 9.
	
	˵��:	
		�������ٰ��������ڵ㡣
		���������нڵ��ֵ����Ψһ�ġ�
		�����Ľڵ�Ϊ��ĩβ�ڵ㲢��һ���������е�һ����Ч�ڵ㡣
		��Ҫ����ĺ����з����κν����
 */
public class DeleteNodeinaLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(9);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		DeleteNodeinaLinkedList dnll = new DeleteNodeinaLinkedList();
		dnll.deleteNode(node1);
	}

	// 237. ɾ�������еĽڵ�
	public void deleteNode(ListNode node) {
		// ����һ���ڵ��ֵ���ƹ���
		node.val = node.next.val;
		// ɾ����һ���ڵ�
		node.next = node.next.next;
	}
}
