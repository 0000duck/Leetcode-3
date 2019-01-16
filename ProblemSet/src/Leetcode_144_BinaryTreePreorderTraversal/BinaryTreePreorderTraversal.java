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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.add(root.val);
		if (root.left != null) {
			list.addAll(preorderTraversal(root.left));
		}
		if (root.right != null) {
			list.addAll(preorderTraversal(root.right));
		}
		return list;
	}

	// ����
	public List<Integer> preorderTraversal2(TreeNode root) {
		ArrayList<Integer> results = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;
		while (cur != null || !stack.empty()) {
			while (cur != null) {
				results.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			// ת��
			cur = cur.right;
		}
		return results;
	}

	// 0ms
	List<Integer> res = new ArrayList<Integer>();

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
}
