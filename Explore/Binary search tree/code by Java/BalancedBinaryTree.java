package Leetcode_110_BalancedBinaryTree;

import TreeNode.TreeNode;

/*
	����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������	
	�����У�һ�ø߶�ƽ�����������Ϊ��	
		һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������1��
	
	ʾ�� 1:	
		���������� [3,9,20,null,null,15,7]	
			    3
			   / \
			  9  20
			    /  \
			   15   7
		���� true ��
	
	ʾ�� 2:	
		���������� [1,2,2,3,3,null,null,4,4]
		
		       1
		      / \
		     2   2
		    / \
		   3   3
		  / \
		 4   4
		���� false ��
 */
public class BalancedBinaryTree {
	// 110. ƽ�������
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int left = depth(root.left);
		int right = depth(root.right);

		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);

	}

	// �������
	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}

	// DFS�������
	public boolean isBalanced2(TreeNode root) {
		return dfsHeight(root) != -1;
	}

	private int dfsHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = dfsHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = dfsHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// 0ms
	public boolean isBalanced0(TreeNode root) {
		// -1�������ҽڵ����Ȳ��1
		return depth0(root) != -1;
	}

	private int depth0(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// left��right�ֱ��ʾ���ҽڵ����Ȳ��Ƿ񳬹�1��-1��ʾ����
		int left = depth0(root.left);
		if (left == -1) {
			return -1;
		}
		int right = depth0(root.right);
		if (right == -1) {
			return -1;
		}
		// ���ҽڵ���Ȳ��1
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		// ������1�������ֵ+1
		return Math.max(left, right) + 1;
	}

}
