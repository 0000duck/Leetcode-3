package Leetcode_559_MaximumDepthofN_aryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Node.Node;

/*
	����һ�� N �������ҵ��������ȡ�	
	��������ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�������	
	���磬����һ�� 3���� :
		ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png	
	����Ӧ�����������ȣ�3��	
	˵��:	
		������Ȳ��ᳬ�� 1000��
		���Ľڵ��ܲ��ᳬ�� 5000��
 */
public class MaximumDepthofN_aryTree {
	public static void main(String[] args) {
		Node root = new Node(1, new ArrayList<Node>());
		Node node3 = new Node(3, new ArrayList<Node>());
		Node node2 = new Node(2, new ArrayList<Node>());
		Node node4 = new Node(4, new ArrayList<Node>());
		Node node5 = new Node(5, new ArrayList<Node>());
		Node node6 = new Node(6, new ArrayList<Node>());
		root.children.add(node3);
		root.children.add(node2);
		root.children.add(node4);
		node3.children.add(node5);
		node3.children.add(node6);

		MaximumDepthofN_aryTree mdnt = new MaximumDepthofN_aryTree();
		System.out.println(mdnt.maxDepth(root));
	}

	// 559. N������������
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		int result = 1;
		return getmaxDepth(root, 1, result);
	}

	// �Զ�����
	private int getmaxDepth(Node root, int depth, int result) {
		for (Node node : root.children) {
			result = Math.max(result, getmaxDepth(node, depth + 1, result));
		}
		return Math.max(result, depth);
	}

	// ����
	public int maxDepth0(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node current = queue.poll();
				for (Node child : current.children) {
					queue.offer(child);
				}
			}
			depth++;
		}
		return depth;
	}
}
