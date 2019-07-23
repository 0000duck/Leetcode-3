package Leetcode_437_PathSumIII;

import TreeNode.TreeNode;

/*
	����һ��������������ÿ����㶼�����һ������ֵ��	
	�ҳ�·���͵��ڸ�����ֵ��·��������	
	·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��	
	������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������
	
	ʾ����	
		root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
		
		      10
		     /  \
		    5   -3
		   / \    \
		  3   2   11
		 / \   \
		3  -2   1
	
	���� 3���͵��� 8 ��·����:	
		1.  5 -> 3
		2.  5 -> 2 -> 1
		3.  -3 -> 11
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/path-sum-iii
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

//437. ·���ܺ� III
public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
		// ������root
		if (root == null) {
			return 0;
		}
		int res = findPath(root, sum);

		res += pathSum(root.left, sum);
		res += pathSum(root.right, sum);

		return res;

	}

	private int findPath(TreeNode root, int sum) {

		if (root == null) {
			return 0;
		}
		int res = 0;
		// ���ڸ������ܻ����������Ľ��������ֱ�ӷ���
		if (sum == root.val) {
			res += 1;
		}
		res += findPath(root.left, sum - root.val);
		res += findPath(root.right, sum - root.val);
		return res;

	}

}
