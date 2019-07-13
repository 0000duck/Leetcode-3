package Leetcode_1120_MaximumAverageSubtree;

import TreeNode.TreeNode;

/*
	����һ�ö������ĸ��ڵ� root���ҳ�������� ÿһ�� ������ ƽ��ֵ �е� ��� ֵ��	
	���������е�����ڵ���������к�����ɵļ��ϡ�	
	����ƽ��ֵ�����нڵ�ֵ���ܺͳ��Խڵ�����	 
	
	ʾ����
		https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/07/12/1308_example_1.png	
		���룺[5,6,1]
		�����6.00000
		���ͣ� 
		�� value = 5 �Ľڵ���Ϊ�����ĸ��ڵ㣬�õ���ƽ��ֵΪ (5 + 6 + 1) / 3 = 4��
		�� value = 6 �Ľڵ���Ϊ�����ĸ��ڵ㣬�õ���ƽ��ֵΪ 6 / 1 = 6��
		�� value = 1 �Ľڵ���Ϊ�����ĸ��ڵ㣬�õ���ƽ��ֵΪ 1 / 1 = 1��
		���Դ�ȡ���ֵ 6�� 
	
	��ʾ��	
		���еĽڵ������� 1 �� 5000֮�䡣
		ÿ���ڵ��ֵ���� 0 �� 100000 ֮�䡣
		���������׼�𰸵������� 10^-5����ô�ý��������Ϊ��ȷ�𰸡�
 */
public class MaximumAverageSubtree {
	// 1120. ���������ƽ��ֵ
	double res = Double.MIN_VALUE;

	public double maximumAverageSubtree(TreeNode root) {
		dfs(root);
		return res;
	}

	private double[] dfs(TreeNode root) {
		double[] ans = new double[2];
		if (root == null) {
			return ans;
		}
		double[] left = dfs(root.left);
		double[] right = dfs(root.right);
		ans[0] = (double) root.val + left[0] + right[0];
		ans[1] = (double) 1 + left[1] + right[1];

		res = Math.max(res, ans[0] / ans[1]);

		return ans;

	}
}
