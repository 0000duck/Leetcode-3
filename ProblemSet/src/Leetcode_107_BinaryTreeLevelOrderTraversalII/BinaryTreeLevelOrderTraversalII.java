package Leetcode_107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
	
	���磺
		���������� [3,9,20,null,null,15,7],		
		    3
		   / \
		  9  20
		    /  \
		   15   7
	�������Ե����ϵĲ�α���Ϊ��		
		[
		  [15,7],
		  [9,20],
		  [3]
		]
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BinaryTreeLevelOrderTraversalII {

	// 107. �������Ĳ�α��� II

	// 3 ms 36.1 MB
	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		List<List<TreeNode>> nodes = new ArrayList<>();
		nodes.add(Arrays.asList(new TreeNode[] { root }));
		List<Integer> rootList = new ArrayList<>();
		rootList.add(root.val);
		res.add(rootList);
		for (int i = 0; i < nodes.size(); i++) {
			List<TreeNode> temp = nodes.get(i);
			for (TreeNode node : temp) {
				if (i == nodes.size() - 1) {
					List<TreeNode> list = new ArrayList<>();
					res.add(0, new ArrayList<Integer>());
					nodes.add(list);
				}
				if (node.left != null) {
					nodes.get(i + 1).add(node.left);
					res.get(0).add(node.left.val);
				}
				if (node.right != null) {
					nodes.get(i + 1).add(node.right);
					res.get(0).add(node.right.val);
				}
			}
		}
		if (res.get(0).size() == 0) {
			res.remove(0);
		}
		return res;
	}

	// 6 ms 37.6 MB
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		List<List<TreeNode>> nodes = new ArrayList<>();
		nodes.add(Arrays.asList(new TreeNode[] { root }));
		for (int i = 0; i < nodes.size(); i++) {
			List<TreeNode> temp = nodes.get(i);
			for (TreeNode node : temp) {
				if (i == nodes.size() - 1) {
					List<TreeNode> list = new ArrayList<>();
					nodes.add(list);
				}
				if (res.size() == i) {
					res.add(new ArrayList<Integer>());
				}
				res.get(0).add(node.val);
				if (node.left != null) {
					nodes.get(i + 1).add(node.left);
				}
				if (node.right != null) {
					nodes.get(i + 1).add(node.right);
				}
			}
		}

		return res;
	}

	// 4 ms 37.5 MB
	public List<List<Integer>> levelOrderBottom3(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		List<List<TreeNode>> nodes = new ArrayList<>();
		nodes.add(Arrays.asList(new TreeNode[] { root }));
		for (int i = 0; i < nodes.size(); i++) {
			List<TreeNode> temp = nodes.get(i);
			for (TreeNode node : temp) {
				if (i == nodes.size() - 1) {
					List<TreeNode> list = new ArrayList<>();
					nodes.add(list);
				}
				if (node.left != null) {
					nodes.get(i + 1).add(node.left);
				}
				if (node.right != null) {
					nodes.get(i + 1).add(node.right);
				}
			}
		}
		for (int i = nodes.size() - 1; i >= 0; i--) {
			List<TreeNode> temp = nodes.get(i);
			if (temp.size() != 0) {
				res.add(new ArrayList<Integer>());
			}
			for (TreeNode node : temp) {
				res.get(res.size() - 1).add(node.val);
			}
		}
		return res;
	}

	// 3 ms 37.2 MB
	public List<List<Integer>> levelOrderBottom4(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			res.addFirst(list);
		}
		return res;
	}

	// �ṹ��

	// 5 ms 36.8 MB
	class TreeNodeWithLevel {
		int level;
		TreeNode node;

		public TreeNodeWithLevel(int level, TreeNode node) {
			this.level = level;
			this.node = node;
		}
	}

	public List<List<Integer>> levelOrderBottom5(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNodeWithLevel> queue = new LinkedList<>();
		queue.add(new TreeNodeWithLevel(0, root));
		while (!queue.isEmpty()) {
			TreeNodeWithLevel curNode = queue.poll();
			if (curNode.level == res.size()) {
				res.add(0, new ArrayList<Integer>());
			}
			res.get(0).add(curNode.node.val);
			if (curNode.node.left != null) {
				queue.add(new TreeNodeWithLevel(curNode.level + 1, curNode.node.left));
			}

			if (curNode.node.right != null) {
				queue.add(new TreeNodeWithLevel(curNode.level + 1, curNode.node.right));
			}
		}
		return res;
	}

}
