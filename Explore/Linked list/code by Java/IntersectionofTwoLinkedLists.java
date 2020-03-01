package Leetcode_160_IntersectionofTwoLinkedLists;

import LinkedList.ListNode;

/*
	��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
	
	���������������
		A:   a1-a2-
					c1-c2-c3
		B:b1-b2-b3-	
		�ڽڵ� c1 ��ʼ�ཻ��
	
	ʾ�� 1��
		A:     4 - 1 -
					   8- 4 -5
		B: 5 - 0 - 1 -		
	���룺
		intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
	�����
		Reference of the node with value = 8
	������ͣ�
		�ཻ�ڵ��ֵΪ 8 ��ע�⣬��������б��ཻ����Ϊ 0����
		�Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]��
		�� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣	 
	
	ʾ�� 2��
		A:0-9-1-
				2-4
		B:    3-	
	���룺
		intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
	�����
		Reference of the node with value = 2
	������ͣ�
		�ཻ�ڵ��ֵΪ 2 ��ע�⣬��������б��ཻ����Ϊ 0����
		�Ӹ��Եı�ͷ��ʼ�������� A Ϊ [0,9,1,2,4]������ B Ϊ [3,2,4]��
		�� A �У��ཻ�ڵ�ǰ�� 3 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 1 ���ڵ㡣	 
	
	ʾ�� 3��
		A:2-6-4
				
		B: 1-5	
	���룺
		intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
	�����
		null
	������ͣ�
		�Ӹ��Եı�ͷ��ʼ�������� A Ϊ [2,6,4]������ B Ϊ [1,5]��
		���������������ཻ������ intersectVal ����Ϊ 0���� skipA �� skipB ����������ֵ��
	���ͣ�
		�����������ཻ����˷��� null�� 
	
	ע�⣺	
		�����������û�н��㣬���� null.
		�ڷ��ؽ���������������뱣��ԭ�еĽṹ��
		�ɼٶ���������ṹ��û��ѭ����
		���������� O(n) ʱ�临�Ӷȣ��ҽ��� O(1) �ڴ档
 */
public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 160. �ཻ����
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		for (; headA != null; headA = headA.next) {
			ListNode temp = headB;
			while (temp != null) {
				if (temp == headA) {
					return headA;
				} else if (temp.next != null) {
					temp = temp.next;
				} else {
					break;
				}
			}
			if (headA.next == null) {
				return null;
			}
		}
		return null;
	}

	// 1ms
	public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode h1 = headA;
		ListNode h2 = headB;
		// lenAΪA����ĳ��ȣ���ʼֵΪ1
		int lenA = 1;
		int lenB = 1;
		while (h1.next != null) {
			lenA++;
			h1 = h1.next;
		}
		while (h2.next != null) {
			lenB++;
			h2 = h2.next;
		}
		// ��A��Bβ��㲻ͬ����϶�û���ཻ��
		if (h1 != h2)
			return null;
		else {
			int count = Math.abs(lenA - lenB);
			// h1ָ��������ͷ��㡣
			if (lenA >= lenB) {
				h1 = headA;
				h2 = headB;
			} else {
				h1 = headB;
				h2 = headA;
			}
			for (int i = 0; i < count; i++)
				h1 = h1.next;
			while (h1 != null && h2 != null && h1 != h2) {
				h1 = h1.next;
				h2 = h2.next;
			}
		}
		// ��û�н��㣬��h1 Ϊnull
		return h1;

	}

}
