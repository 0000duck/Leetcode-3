package Leetcode_108_ConvertSortedArraytoBinarySearchTree;

import TreeNode.TreeNode;

/*
	��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
	
	�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
	
	ʾ��:	
		������������: [-10,-3,0,5,9],
	
		һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������	
				      0
				     / \
				   -3   9
				   /   /
				 -10  5
 */
public class ConvertSortedArraytoBinarySearchTree {
	// 108. ����������ת��Ϊ����������
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(nums[nums.length / 2]);
		root.left = sortedArrayToBST(root, 0, nums.length / 2 - 1, nums);
		root.right = sortedArrayToBST(root, nums.length / 2 + 1, nums.length - 1, nums);
		return root;
	}

	private TreeNode sortedArrayToBST(TreeNode root, int left, int right, int[] nums) {
		if (left == right) {
			return new TreeNode(nums[left]);
		}
		root.left = sortedArrayToBST(root, left, (left + right) / 2 + 1, nums);
		root.right = sortedArrayToBST(root, (left + right) / 2, right, nums);
	}

}
