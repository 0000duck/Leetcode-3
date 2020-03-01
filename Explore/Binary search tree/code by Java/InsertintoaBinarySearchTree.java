package Leetcode_701_InsertintoaBinarySearchTree;

import TreeNode.TreeNode;

/*
	����������������BST���ĸ��ڵ��Ҫ�������е�ֵ����ֵ��������������� 
	���ز��������������ĸ��ڵ㡣 ��֤ԭʼ�����������в�������ֵ��
	
	ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ�
	 ����Է���������Ч�Ľ����
	
	����, 	
		��������������:
		
		        4
		       / \
		      2   7
		     / \
		    1   3
		
		�� �����ֵ: 5
		����Է����������������:
		
		         4
		       /   \
		      2     7
		     / \   /
		    1   3 5
		���������Ҳ����Ч��:
		
		         5
		       /   \
		      2     7
		     / \   
		    1   3
		         \
		          4
 */
public class InsertintoaBinarySearchTree {
	// 701. �����������еĲ������
	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode insertNode = new TreeNode(val);
		inserIntoBST(root, val, insertNode);
		return root;
	}

	private void inserIntoBST(TreeNode root, int val, TreeNode insertNode) {
		if (root.val < val) {
			if (root.right != null) {
				inserIntoBST(root.right, val, insertNode);
			} else {
				root.right = insertNode;
				return;
			}
		} else {
			if (root.left != null) {
				inserIntoBST(root.left, val, insertNode);
			} else {
				root.left = insertNode;
				return;
			}
		}
	}
}
