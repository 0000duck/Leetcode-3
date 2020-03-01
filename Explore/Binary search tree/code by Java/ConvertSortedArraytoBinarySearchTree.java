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
		if (left > right) {
			return null;
		}
		TreeNode node = new TreeNode(nums[(right + left + 1) / 2]);
		node.left = sortedArrayToBST(node, left, (right + left + 1) / 2 - 1, nums);
		node.right = sortedArrayToBST(node, (right + left + 1) / 2 + 1, right, nums);
		return node;
	}

	// 0ms
	public TreeNode sortedArrayToBST0(int[] nums) {
		// ���ҵȷֽ��������������м�ڵ���Ϊ�������ڵ㣬�ݹ�ù���
		if (nums == null || nums.length == 0) {
			return null;
		}
		return buildTree0(nums, 0, nums.length - 1);
	}

	private TreeNode buildTree0(int[] nums, int l, int r) {
		if (l > r) {
			return null;
		}
		if (l == r) {
			return new TreeNode(nums[l]);
		}
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree0(nums, l, mid - 1);
		root.right = buildTree0(nums, mid + 1, r);
		return root;
	}

}
