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

	// ���ҵȷֽ��������������м�ڵ���Ϊ�������ڵ㣬�ݹ�ù���

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return buildTree(nums, 0, nums.length - 1);
	}

	private TreeNode buildTree(int[] nums, int l, int r) {
		if (l > r) {
			return null;
		}
		if (l == r) {
			return new TreeNode(nums[l]);
		}
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, l, mid - 1);
		root.right = buildTree(nums, mid + 1, r);
		return root;
	}

}
