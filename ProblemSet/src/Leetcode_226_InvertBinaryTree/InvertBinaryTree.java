package Leetcode_226_InvertBinaryTree;

import TreeNode.TreeNode;

/*
	��תһ�ö�������
	
	ʾ����	
		���룺
		
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		�����
		
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/invert-binary-tree
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class InvertBinaryTree {
	// 226. ��ת������
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = right;
		root.right = left;
		invertTree(left);
		invertTree(right);
		return root;
	}
}
