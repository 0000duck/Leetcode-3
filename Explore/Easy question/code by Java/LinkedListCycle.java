package Leetcode_141_LinkedListCycle;

import LinkedList.ListNode;

/*
	����һ�������ж��������Ƿ��л���	
	Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� 
	��� pos �� -1�����ڸ�������û�л���	
			  	
	ʾ�� 1��	
		���룺head = [3,2,0,-4], pos = 1
		�����true
		���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
				
		3-2-0-4
		  |---|
	
	ʾ�� 2��	
		���룺head = [1,2], pos = 0
		�����true
		���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
		
		1-2
		|-|	
	
	ʾ�� 3��	
		���룺head = [1], pos = -1
		�����false
		���ͣ�������û�л���
		
		1
			
	���ף�	
		������ O(1)�������������ڴ�����������
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node0 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		//ListNode node2 = new ListNode(0);
		//ListNode node3 = new ListNode(-4);
		node0.next = node1;
		//node1.next = node2;
		//node2.next = node3;
		//node3.next = node1;
		
		LinkedListCycle llc = new LinkedListCycle();
		System.out.println(llc.hasCycle(node0));
		
	}
	//141. ��������	
    public boolean hasCycle(ListNode head) {    	
    	if((head!=null)&&(head.next!=null)) {    		
    		ListNode fast = head.next;
        	ListNode slow = head.next;
        	while((fast!=null)&&(slow!=null)) {
        		if(slow.next!=null) {
        			slow = slow.next;
        		}else {
        			return false;
        		}
        		
        		if((fast.next!=null)&&(fast.next.next!=null)) {
        			fast = fast.next.next;
        		}else {
        			return false;
        		}
        		
        		if(fast==slow) {
        			return true;
        		}
        	}
        	return false;
    	}
    	return false;    	
    }
    
    //0ms
    public boolean hasCycle0(ListNode head) {
        ListNode fast = head;
		ListNode low = head;
		while (fast != null && fast.next != null) {
			low = low.next;
			fast = fast.next.next;
			if (fast == low) {
				return true;
			}
		}
		return false;
    }
}
