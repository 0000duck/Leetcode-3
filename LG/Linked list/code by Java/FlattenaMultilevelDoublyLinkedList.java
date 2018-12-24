package Leetcode_430_FlattenaMultilevelDoublyLinkedList;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import LinkedList.Node;

/*
	�������һ��˫������������һ����ǰһ��ָ��֮�⣬������һ����ָ�룬����ָ�򵥶���˫������
	��Щ���б������һ�������Լ�������������ƣ����ɶ༶���ݽṹ���������ʾ����ʾ��
	
	��ƽ���б�ʹ���н������ڵ���˫�����С���������б��һ����ͷ����	 
	
	ʾ��:	
		����:
			 1---2---3---4---5---6--NULL
			         |
			         7---8---9---10--NULL
			             |
			             11--12--NULL
		
		���:
			1-2-3-7-8-11-12-9-10-4-5-6-NULL
		 
		
		����ʾ����˵��:
				
			�������¶༶˫������:
				ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/multilevellinkedlist.png 			
			����Ӧ�÷���������ʾ�ı�ƽ˫������:
				ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/multilevellinkedlistflattened.png
		
		���룺
			3470--- 121--4724--4285---NULL
					 |     |
					 |    1753---NULL
				     |
				    917-- 721---NULL
		�����
			3470-121-917-721-4724-1753-4285-NULL
 */
public class FlattenaMultilevelDoublyLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1, null, null, null);
		Node node2 = new Node(2, head, null, null);
		Node node3 = new Node(3, node2, null, null);
		Node node4 = new Node(4, node3, null, null);
		Node node5 = new Node(5, node4, null, null);
		Node node6 = new Node(6, node5, null, null);

		Node node7 = new Node(7, null, null, null);
		Node node8 = new Node(8, node7, null, null);
		Node node9 = new Node(9, node8, null, null);
		Node node10 = new Node(10, node9, null, null);

		Node node11 = new Node(11, null, null, null);
		Node node12 = new Node(12, node11, null, null);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node3.child = node7;
		node4.next = node5;
		node5.next = node6;
		node7.next = node8;
		node8.next = node9;
		node8.child = node11;
		node9.next = node10;
		node11.next = node12;

		FlattenaMultilevelDoublyLinkedList fmdll = new FlattenaMultilevelDoublyLinkedList();
		fmdll.flatten(head);

	}

	// 430. ��ƽ���༶˫������
	public Node flatten(Node head) {
		if (head == null) {
			return head;
		}
		Node points = head;//
		Node next = null;
		while (points.next != null) {
			points.next.prev = points;//
			// ���ӽڵ����Ϊ��һ���ڵ�
			if (points.child != null) {
				next = points.next;
				points.child.prev = points;
				points.next = flatten(points.child);
				points.child = null;
				points = points.next;
			} else {
				points = points.next;
			}
		}
		if (next != null) {
			points.next = flatten(next);
		}

		return head;

	}

	// 2ms
	public Node flatten0(Node head) {
		Node dummy = head;
		if (head == null) {
			return head;
		}
		// �ǲ��ǵ����һ���ڵ�
		while (dummy.next != null) {
			Node child = dummy.child;// ��¼�ӽڵ㣬����Ϊnull
			Node next = dummy.next;// ��¼next�ڵ�
			// ���ӽڵ�
			if (child != null) {
				Node temp = flatten0(child);// �ݹ�
				dummy.child = null;// ɾ���ӽ��ָ��
				dummy.next = temp;// ���ӽ����Ϊnext�ڵ�
				temp.prev = dummy;// ����ǰ�ڵ�����Ϊprev�ڵ�
				Node last = getLast(temp);// ��ȡ�ӽ������һ���ڵ�
				last.next = next;// ������һ���ڵ��next�ڵ�����Ϊnext
				next.prev = last;
			}
			dummy = next;
		}

		// ��������������һ�ڵ����ӽ��
		if (dummy.next == null && dummy.child != null) {
			Node child = dummy.child;
			Node temp = flatten(child);
			dummy.next = temp;
			temp.prev = dummy;
			dummy.child = null;
		}

		return head;
	}

	// ��ȡ�ӽ������һ���ڵ�
	private static Node getLast(Node head) {
		Node result = head;
		while (result.next != null) {
			result = result.next;
		}
		return result;
	}

	// �ݹ�
	public Node flatten3(Node head) {
		if (head == null) {
			return head;
		}
		Node points = head;
		Node next = null;
		while (points.next != null) {
			points.next.prev = points;
			// ���ӽڵ����Ϊ��һ���ڵ�
			if (points.child != null) {
				next = points.next;
				points.child.prev = points;
				points.next = flatten(points.child);
				points.child = null;
				points = points.next;
			} else {
				points = points.next;
			}
		}
		if (next != null) {
			points.next = flatten(next);
		}

		return head;

	}

	public Node flatten2(Node head) {
		if (head == null) {
			return head;
		}
		List<Node> nextlist = new ArrayList<Node>();
		// Node result = new Node(0,null,head,null);
		Node points = head;
		while (points.next != null) {
			// ���ӽڵ����Ϊ��һ���ڵ�
			if (points.child != null) {
				nextlist.add(points.next);
				points.next = points.child;
				points.child = null;
				points.next.prev = points;
				points = points.next;
			} else {
				points = points.next;
			}
		}
		//
		for (int i = nextlist.size() - 1; i >= 0; i--) {
			points.next = nextlist.get(i);
			points.next.prev = points;
			points = points.next;
			while (points.next != null) {
				points = points.next;
			}
		}
		return head;

	}

}