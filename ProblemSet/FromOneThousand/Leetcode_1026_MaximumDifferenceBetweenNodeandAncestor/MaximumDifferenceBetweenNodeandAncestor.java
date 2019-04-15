package Leetcode_1026_MaximumDifferenceBetweenNodeandAncestor;

import java.util.Stack;

/*
	�����������ĸ��ڵ� root��
	�ҳ������ڲ�ͬ�ڵ� A �� B ֮������ֵ V��
	���� V = |A.val - B.val|���� A �� B �����ȡ�
	
	����� A ���κ��ӽڵ�֮һΪ B������ A ���κ��ӽڵ��� B �����ȣ���ô������Ϊ A �� B �����ȣ�
	
	 
	
	ʾ����	
	
	���룺[8,3,10,1,6,null,14,null,null,4,7,13]
	�����7
	���ͣ� 
		�����д����Ľڵ��������ȵĲ�ֵ������һЩ���£�
		|8 - 3| = 5
		|3 - 7| = 4
		|8 - 1| = 7
		|10 - 13| = 3
		�����п��ܵĲ�ֵ�У����ֵ 7 �� |8 - 1| = 7 �ó���
	 
	
	��ʾ��	
		���еĽڵ����� 2 �� 5000 ֮�䡣
		ÿ���ڵ��ֵ���� 0 �� 100000 ֮�䡣
 */
import TreeNode.TreeNode;
//1026.�ڵ����丸�ڵ�֮�������ֵ
public class MaximumDifferenceBetweenNodeandAncestor {
	public int maxAncestorDiff(TreeNode root) {
		int res = 0;
		if (root == null) {
			return res;
		}

		Stack<Integer> minNum = new Stack<Integer>();
		Stack<Integer> maxNum = new Stack<Integer>();
		Stack<TreeNode> sta = new Stack<TreeNode>();

		sta.push(root);
		minNum.push(root.val);
		maxNum.push(root.val);

		TreeNode cur = root.left;
		TreeNode pre = null;

		while (cur != null) {
			sta.push(cur);
			int tem = cur.val;
			minNum.push(Math.min(tem, minNum.peek()));
			maxNum.push(Math.max(tem, maxNum.peek()));
			cur = cur.left;
		}

		while (!sta.isEmpty()) {
			cur = sta.peek();
			if (cur.right == null || cur.right == pre) {
				int tem = cur.val;
				res = Math.max(res, Math.abs(tem - minNum.peek()));
				res = Math.max(res, Math.abs(tem - maxNum.peek()));
				sta.pop();
				minNum.pop();
				maxNum.pop();
				pre = cur;
			} else {
				cur = cur.right;
				while (cur != null) {
					sta.push(cur);
					int tem = cur.val;
					minNum.push(Math.min(tem, minNum.peek()));
					maxNum.push(Math.max(tem, maxNum.peek()));
					cur = cur.left;
				}
			}
		}
		return res;

	}
}
