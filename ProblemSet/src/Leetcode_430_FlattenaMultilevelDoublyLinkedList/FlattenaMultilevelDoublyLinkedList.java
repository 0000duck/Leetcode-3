package Leetcode_430_FlattenaMultilevelDoublyLinkedList;

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


 */
public class FlattenaMultilevelDoublyLinkedList {
	public static void main(String[] args) {
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		Node node4 = new Node();
		Node node5 = new Node();
		Node node6 = new Node();
		Node node7 = new Node();
		Node node8 = new Node();
		Node node9 = new Node();
		Node node10 = new Node();
		Node node11 = new Node();
		Node node12 = new Node();
		node1 = new Node(1, null, node2, null);
		node2 = new Node(2, node1, node3, null);
		node3 = new Node(3, node2, node4, node7);
		node4 = new Node(4, node3, node5, null);
		node5 = new Node(5, node4, node6, null);
		node6 = new Node(6, node5, null, null);

		node7 = new Node(7, null, node8, null);
		node8 = new Node(8, node7, node9, node11);
		node9 = new Node(9, node8, node10, null);
		node10 = new Node(10, node9, null, null);

		node11 = new Node(11, null, node12, null);
		node12 = new Node(12, node11, null, null);

	}

	// 430. ��ƽ���༶˫������
	public Node flatten(Node head) {
		List<Node> list = new ArrayList<Node>();
		while ((head != null) && (head.next != null) && (head.child != null)) {
			
		}
	}

}
