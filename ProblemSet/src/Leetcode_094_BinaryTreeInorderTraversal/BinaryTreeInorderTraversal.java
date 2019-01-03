package Leetcode_094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

/*
	����һ���������������������� ������
	���������
		�����������ڵ㣬������
	
	ʾ��:	
		����: [1,null,2,3]
		   1
		    \
		     2
		    /
		   3
		
		���: [1,3,2]
	����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 */
public class BinaryTreeInorderTraversal {
	
	// 94. ���������������
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		loop(root);
		return list;
	}

	public void loop(TreeNode root) {
		if (root == null) {
			return;
		}

		loop(root.left);
		list.add(root.val);
		loop(root.right);
	}
}
