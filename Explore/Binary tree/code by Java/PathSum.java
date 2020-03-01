package Leetcode_112_PathSum;

import TreeNode.TreeNode;

/*
	����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�	
	˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣	
	ʾ��: 
		�������¶��������Լ�Ŀ��� sum = 22��
		
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \      \
		        7    2      1
		���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��
 */
public class PathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.right = node9;

		PathSum ps = new PathSum();
		ps.hasPathSum0(root, 22);
	}

	// 112. ·���ܺ�
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if ((root.left == null) && (root.right == null) && (sum - root.val == 0)) {
			return true;
		}
		if (root.left != null) {
			if (hasPathSum(root.left, sum - root.val)) {
				return true;
			}
		}

		if (root.right != null) {
			if (hasPathSum(root.right, sum - root.val)) {
				return true;
			}
		}

		return false;

	}

	// 0ms
	boolean flag = false;
	int total = 0;

	void dfs(TreeNode root, int current) {
		if (root.left == null && root.right == null) { // �ж��ǲ���Ҷ�ӽڵ�
			if (current == total) {
				flag = true;
			}
		}
		if (root.left != null) {
			dfs(root.left, current + root.left.val);
		}
		if (root.right != null) {
			dfs(root.right, current + root.right.val);
		}
	}

	public boolean hasPathSum0(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		total = sum;
		dfs(root, root.val);
		return flag;
	}
}
