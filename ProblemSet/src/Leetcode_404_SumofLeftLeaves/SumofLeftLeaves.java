package Leetcode_404_SumofLeftLeaves;

import TreeNode.TreeNode;

/*
	���������������������Ҷ��֮�͡�
	
	ʾ����	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	������������У���������Ҷ�ӣ��ֱ��� 9 �� 15�����Է��� 24
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/sum-of-left-leaves
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SumofLeftLeaves {
	// 404. ��Ҷ��֮��
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int ans = 0;
		if (root.left != null) {
			// ����Ҷ�ӽڵ�
			if (root.left.left == null && root.left.right == null) {
				ans += root.left.val;
			} else {
				ans += sumOfLeftLeaves(root.left);
			}
		}
		ans += sumOfLeftLeaves(root.right);
		return ans;

	}
}
