package Leetcode_144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import TreeNode.TreeNode;

/*
	����һ������������������ ǰ�� ������
	
	ǰ�������
		���ڵ㣬����������������
	
	 ʾ��:	
		����: [1,null,2,3]  
		   1
		    \
		     2
		    /
		   3 
		
		���: [1,2,3]
	����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 */
public class BinaryTreePreorderTraversal {
	// 144. ��������ǰ�����
	// �ݹ�
	List<Integer> res = new ArrayList<Integer>();// ȫ�ֱ���

	public List<Integer> preorderTraversal0(TreeNode root) {
		loop(root);
		return res;
	}

	public void loop(TreeNode root) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		loop(root.left);
		loop(root.right);
	}

	// ����
	public List<Integer> preorderTraversal2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val);
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
		return res;
	}

}
