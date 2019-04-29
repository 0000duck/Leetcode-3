package Leetcode_677_MapSumPairs;

import java.util.LinkedList;
import java.util.Queue;

/*
	ʵ��һ�� MapSum ���������������insert �� sum��
	
	���ڷ��� insert���㽫�õ�һ�ԣ��ַ������������ļ�ֵ�ԡ�
	�ַ�����ʾ����������ʾֵ��������Ѿ����ڣ���ôԭ���ļ�ֵ�Խ���������µļ�ֵ�ԡ�
	
	���ڷ��� sum���㽫�õ�һ����ʾǰ׺���ַ���������Ҫ���������Ը�ǰ׺��ͷ�ļ���ֵ���ܺ͡�
	
	ʾ�� 1:
	
	����: insert("apple", 3), ���: Null
	����: sum("ap"), ���: 3
	����: insert("app", 2), ���: Null
	����: sum("ap"), ���: 5
 */
//677. ��ֵӳ��
public class MapSum {
	private Node root;

	public MapSum() {
		root = new Node(0);
	}

	public void insert(String key, int val) {
		Node cur = root;
		for (int i = 0; i < key.length(); i++) {
			int temp = key.charAt(i) - 'a';
			if (cur.child[temp] == null) {
				Node node = new Node(0);
				cur.child[temp] = node;
			}
			cur = cur.child[temp];
		}
		cur.val = val;
	}

	public int sum(String prefix) {
		int sum = 0;
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			int temp = prefix.charAt(i) - 'a';
			if (cur.child[temp] == null) {
				return 0;
			}
			cur = cur.child[temp];
		}
		//
		Queue<Node> queue = new LinkedList<>();
		queue.add(cur);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			sum += temp.val;
			for (Node node : temp.child) {
				if (node != null) {
					queue.add(node);
					sum += node.val;
				}
			}

		}
		return sum;

	}
}

class Node {
	int val;
	Node[] child;

	Node(int val) {
		this.val = val;
		child = new Node[26];

	}
}