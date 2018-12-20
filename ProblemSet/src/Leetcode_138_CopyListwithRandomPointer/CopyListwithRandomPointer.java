package Leetcode_138_CopyListwithRandomPointer;

import java.util.HashMap;

/*
	����һ������ÿ���ڵ����һ���������ӵ����ָ�룬��ָ�����ָ�������е��κνڵ��սڵ㡣
	
	Ҫ�󷵻�����������ȿ�����
	
	 �����ǳ������
	 	��һ����������ø��Ƹ�����һ������һ�������ַ�ʽ��
	 	��һ�ַ�ʽ��ֱ�Ӹ�ֵ���ڶ��ַ�ʽ��ǳ�������������������
	 	
	 	ֱ�Ӹ�ֵ��
	 		
	 	ǳ������
	 		����һ���¶���Ȼ�󽫵�ǰ����ķǾ�̬�ֶθ��Ƶ����¶�������ֶ���ֵ���͵ģ���ô�Ը��ֶ�ִ�и��ƣ�
	 		������ֶ����������͵Ļ����������õ����������õĶ�����ˣ�ԭʼ�����丱������ͬһ������
	 	�����
	 		1�� �������ͣ�������ֵ������int��float�ȡ�
      		2�� ���󣺿������ַ���ã�Ҳ����˵��ʱ�¶�����ԭ�������ǹ��ø�ʵ��������
      		3�� String�ַ��������ַ���á��������޸�ʱ��������ַ���������������һ���µ��ַ�����ԭ���ַ������󱣳ֲ��䡣
	 	
 */
public class CopyListwithRandomPointer {
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		head.next = node2;
		node2.next = node3;

		CopyListwithRandomPointer clrp = new CopyListwithRandomPointer();
		clrp.copyRandomList(head);

	}

	// 138. ���ƴ����ָ�������
	// 0ms
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dummyHead = new RandomListNode(0);
		RandomListNode pre = dummyHead;
		RandomListNode current = head;
		while (current != null) {
			pre.next = deepCopy(current);
			current = current.next;
			pre = pre.next;
		}

		return dummyHead.next;
	}

	private RandomListNode deepCopy(RandomListNode current) {
		//
		RandomListNode newnode = new RandomListNode(current.label);
		if (current.random != null)
			//
			newnode.random = new RandomListNode(current.random.label);
		return newnode;
	}
}
