package Leetcode_142_LinkedListCycle2;

import java.util.ArrayList;
import java.util.List;

import LinkedList.ListNode;

/*
	����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��	
	Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
		
	˵�����������޸ĸ���������	 
	
	ʾ�� 1��	
		���룺head = [3,2,0,-4], pos = 1
		�����tail connects to node index 1
		���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣	
	
	ʾ�� 2��	
		���룺head = [1,2], pos = 0
		�����tail connects to node index 0
		���ͣ���������һ��������β�����ӵ���һ���ڵ㡣	
	
	ʾ�� 3��	
		���룺head = [1], pos = -1
		�����no cycle
		���ͣ�������û�л���	 
	
	���ף�
		���Ƿ���Բ��ö���ռ������⣿
 */
public class LinkedListCycle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(-4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node1;
		
		LinkedListCycle2 llc2 = new LinkedListCycle2();
		System.out.println(llc2.detectCycle0(head).val);
		
	}
	//142. �������� II
    public ListNode detectCycle(ListNode head) {
    	if(head==null) {
    		return head;
    	}
    	//list
    	List<ListNode> list = new ArrayList<ListNode>();
    	while(true) {
    		if(list.contains(head)) {
    			return head;
    		}else if(head.next!=null){
    			list.add(head);
    			head = head.next;
    		}else {
    			break;
    		}
    	}
    	return null;    	
    }
    
    //0ms
    public ListNode detectCycle0(ListNode head) {
    	//��ָ��
        ListNode slow = head;
        //��ָ��
        ListNode fast = head;
        //�ж��Ƿ���ѭ��
        while (fast!=null && fast.next!=null){
        	//��ָ���Ƿ�սڵ������һ�ڵ�Ϊ��
            fast = fast.next.next;
            slow = slow.next;
            //��ָ��׷����ָ�룬���ڻ�
            if (fast == slow){
            	//?
                ListNode slow2 = head; 
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

}
