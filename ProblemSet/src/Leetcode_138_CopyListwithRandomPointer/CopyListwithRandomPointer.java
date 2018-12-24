package Leetcode_138_CopyListwithRandomPointer;

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
/**
 * Definition for singly-linked list with a random pointer.
 * 
 */

public class CopyListwithRandomPointer {

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
		RandomListNode newnode = new RandomListNode(current.label);
		if (current.random != null)
			newnode.random = new RandomListNode(current.random.label);
		return newnode;
	}
}
