package Leetcode_707_DesignLinkedList;

import java.util.ArrayList;
import java.util.List;

/*
	��������ʵ�֡�������ѡ��ʹ�õ������˫����
	�������еĽڵ�Ӧ�þ����������ԣ�val �� next��val �ǵ�ǰ�ڵ��ֵ��next ��ָ����һ���ڵ��ָ��/���á�
	���Ҫʹ��˫����������Ҫһ������ prev ��ָʾ�����е���һ���ڵ㡣���������е����нڵ㶼�� 0-index �ġ�
	
	����������ʵ����Щ���ܣ�	
		get(index)����ȡ�����е� index ���ڵ��ֵ�����������Ч���򷵻�-1��
		addAtHead(val)��������ĵ�һ��Ԫ��֮ǰ���һ��ֵΪ val �Ľڵ㡣������½ڵ㽫��Ϊ����ĵ�һ���ڵ㡣
		addAtTail(val)����ֵΪ val �Ľڵ�׷�ӵ���������һ��Ԫ�ء�
		addAtIndex(index,val)��
			�������еĵ� index ���ڵ�֮ǰ���ֵΪ val  �Ľڵ㡣
			��� index ��������ĳ��ȣ���ýڵ㽫���ӵ������ĩβ����� index ���������ȣ��򲻻����ڵ㡣
		deleteAtIndex(index)��������� index ��Ч����ɾ�������еĵ� index ���ڵ㡣	 
	
	ʾ����	
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		linkedList.addAtIndex(1,2);   //�����Ϊ1-> 2-> 3
		linkedList.get(1);            //����2
		linkedList.deleteAtIndex(1);  //����������1-> 3
		linkedList.get(1);            //����3	 
	
	��ʾ��	
		����ֵ���� [1, 1000] ֮�ڡ�
		������������  [1, 1000] ֮�ڡ�
		�벻Ҫʹ�����õ� LinkedList �⡣
 */

//707. �������
class MyLinkedList {
	//��ArrayList ʵ��LinkedList
	List<Integer> list;	

    /** Initialize your data structure here. */
    public MyLinkedList() {
    	list = new ArrayList<Integer>();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) { 
    	if((index<0)||(index>=list.size())) {
    		return -1;
    	}
        return list.get(index);
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        list.add(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	list.add(list.size(), val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. 
     * If index equals to the length of linked list, the node will be appended to the end of linked list. 
     * If index is greater than the length, the node will not be inserted. 
     * 
     */
    public void addAtIndex(int index, int val) {
    	if((index<0)||(index>list.size())){
    		return;
    	}
        list.add(index, val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if((index<0)||(index>=list.size())) {
    		return;
    	}
        list.remove(index);
    }
}

//72ms
class MyLinkedList0 {

    DoublyListNode head;
    DoublyListNode tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList0() {
        head = new DoublyListNode(0);
        tail = new DoublyListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        DoublyListNode node = getNodeAtIndex(index);
        return (node == null || node == tail) ? -1 : node.val;
    }

    /**
     * �Զ���һ����������������Ҫ
     */
    public DoublyListNode getNodeAtIndex(int index) {
        if (index < 0) return null;
        DoublyListNode temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
            if (temp == null) return null;
        }
        return temp;//������len+1��Ӧtail
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        DoublyListNode node = new DoublyListNode(val);
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        DoublyListNode node = new DoublyListNode(val);
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        DoublyListNode node = getNodeAtIndex(index);
        if (node == null) return;
        if (node == tail) {
            addAtTail(val);
            return;
        }
        DoublyListNode newNode = new DoublyListNode(val);
        node.pre.next = newNode;
        newNode.pre = node.pre;
        newNode.next = node;
        node.pre = newNode;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        DoublyListNode node = getNodeAtIndex(index);
        if (node == null || node == tail) return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * ���õ�����ṹListNode
     */
    private class DoublyListNode {
        int val;
        DoublyListNode pre;
        DoublyListNode next;

        DoublyListNode(int val) {
            this.val = val;
        }
    }

    /**
     * ��ӡ����
     */
    public void printLinkedList() {
        DoublyListNode headTemp = head.next;
        StringBuilder sb = new StringBuilder();
        while (headTemp != tail) {
            sb.append(headTemp.val).append("-->");
            headTemp = headTemp.next;
        }
        String r = sb.toString();
        System.out.println(r.substring(0, sb.length() - 3));
    }

}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
