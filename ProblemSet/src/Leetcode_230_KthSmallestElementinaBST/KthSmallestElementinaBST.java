package Leetcode_230_KthSmallestElementinaBST;

import TreeNode.TreeNode;

/*
	����һ����������������дһ������ kthSmallest ���������е� k ����С��Ԫ�ء�
	
	˵����
		����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����
	
	ʾ�� 1:	
		����: root = [3,1,4,null,2], k = 1
		   3
		  / \
		 1   4
		  \
		   2
		���: 1
	ʾ�� 2:	
		����: root = [5,3,6,2,4,null,null,1], k = 3
			       5
			      / \
			     3   6
			    / \
			   2   4
			  /
			 1
		���: 3
	���ף�
		��������������������޸ģ�����/ɾ����������������ҪƵ���ز��ҵ� k С��ֵ���㽫����Ż� kthSmallest ������
 */

//230.�����������е�KС��Ԫ��
public class KthSmallestElementinaBST {
	int count = 0;
	int result = Integer.MIN_VALUE;

	public int kthSmallest(TreeNode root, int k) {
		traverse(root, k);
		return result;
	}

	public void traverse(TreeNode root, int k) {
		if (root == null)
			return;
		traverse(root.left, k);
		count++;
		if (count == k)
			result = root.val;
		traverse(root.right, k);
	}
}
