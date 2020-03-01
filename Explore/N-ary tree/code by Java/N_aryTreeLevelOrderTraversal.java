package Leetcode_429_N_aryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Node.Node;

/*
	����һ�� N ������������ڵ�ֵ�Ĳ�������� (�������ң�������)��
	
	���磬����һ�� 3���� :
	ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png	 
	
	������������:	
		[
		     [1],
		     [3,2,4],
		     [5,6]
		]
	
	˵��:	
		������Ȳ��ᳬ�� 1000��
		���Ľڵ��������ᳬ�� 5000��
 */
public class N_aryTreeLevelOrderTraversal {
	// 429. N�����Ĳ������
	// �ݹ�
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		function(root, list, 0);
		return list;
	}

	private void function(Node root, List<List<Integer>> list, int level) {
		if (root == null) {
			return;
		}
		if (list.size() <= level) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(root.val);
		for (Node node : root.children) {
			function(node, list, level + 1);
		}
	}

	// ����
	public List<List<Integer>> levelOrder2(Node root) {
		List<List<Integer>> ret = new LinkedList<>();

		if (root == null) {
			return ret;
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			// ÿһ��Ľ��
			List<Integer> curLevel = new LinkedList<Integer>();
			// ÿһ��ĳ���
			int len = queue.size();
			// ����ÿһ��
			for (int i = 0; i < len; i++) {
				Node curr = queue.poll();
				curLevel.add(curr.val);
				for (Node c : curr.children) {
					queue.offer(c);
				}
			}
			ret.add(curLevel);
		}
		return ret;
	}
}
