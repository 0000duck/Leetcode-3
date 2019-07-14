package Leetcode_1123_LowestCommonAncestorofDeepestLeaves;

import TreeNode.TreeNode;

/*
	����һ���и��ڵ�Ķ��������ҵ��������Ҷ�ڵ������������ȡ�
	
	����һ�£�	
	Ҷ�ڵ� �Ƕ�������û���ӽڵ�Ľڵ�
	���ĸ��ڵ�� ��� Ϊ 0�����ĳһ�ڵ�����Ϊ d���������ӽڵ����Ⱦ��� d+1
	������Ǽٶ� A ��һ��ڵ� S �� ����������ȣ�S �е�ÿ���ڵ㶼���� A Ϊ���ڵ�������У��� A ����ȴﵽ�������¿��ܵ����ֵ��
	 
	
	ʾ�� 1��	
		���룺root = [1,2,3]
		�����[1,2,3]
	ʾ�� 2��	
		���룺root = [1,2,3,4]
		�����[4]
	ʾ�� 3��	
		���룺root = [1,2,3,4,5]
		�����[2,4,5]
	 
	
	��ʾ��	
		��������н��� 1 �� 1000 ���ڵ㡣
		����ÿ���ڵ��ֵ���� 1 �� 1000 ֮�䡣
 */

//1123.�ڵ�������������
public class LowestCommonAncestorofDeepestLeaves {
	class ResultType {
		TreeNode result;
		int maxLevel;

		ResultType(TreeNode result, int maxLevel) {
			this.result = result;
			this.maxLevel = maxLevel;
		}
	}

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) {
			return root;
		}
		ResultType resType = helper(root, 0);
		return resType.result;
	}

	private ResultType helper(TreeNode root, int level) {
		if (root == null) {
			return null;
		}
		ResultType left = helper(root.left, level + 1);
		ResultType right = helper(root.right, level + 1);
		if (left == null && right == null) {
			return new ResultType(root, level);
		} else if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			if (left.maxLevel > right.maxLevel) {
				return left;
			} else if (left.maxLevel < right.maxLevel) {
				return right;
			} else {
				return new ResultType(root, left.maxLevel);
			}
		}

	}
}
