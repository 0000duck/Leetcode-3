package Leetcode_235_LowestCommonAncestorofaBinarySearchTree;

import TreeNode.TreeNode;

/*
	����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
	
	�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
	
	���磬�������¶���������:  
		root = [6,2,8,0,4,7,9,null,null,3,5]	
		ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png	 
	
	ʾ�� 1:	
		����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
		���: 6 
		����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
	ʾ�� 2:	
		����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
		���: 2
		����: �ڵ� 2 �ͽڵ� 4 ��������������� 2, ��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
 */
public class LowestCommonAncestorofaBinarySearchTree {
	// 235. �����������������������
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		return root;
	}

	// 5ms
	public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		// Ҫô����������Ҫô����������Ҫô���Ǹ��ڵ�
		while (root != null) {
			if (p.val > root.val && q.val > root.val)
				root = root.right;
			else if (p.val < root.val && q.val < root.val)
				root = root.left;
			else
				return root;
		}
		return root;
	}
}
