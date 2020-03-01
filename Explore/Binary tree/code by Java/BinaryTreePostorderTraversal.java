package Leetcode_145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

/*
	����һ������������������ ���� ������
	���������
		�������������������ڵ�
	
	ʾ��:	
		����: [1,null,2,3]  
		   1
		    \
		     2
		    /
		   3 
		
		���: [3,2,1]
	����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 */
public class BinaryTreePostorderTraversal {
	
	//145. �������ĺ������
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorderTraversal(TreeNode root) {
		loop(root);
		return list;
	}

	private void loop(TreeNode root) {
		if (root == null) {
			return;
		}

		loop(root.left);
		loop(root.right);
		list.add(root.val);

	}

	// 0ms
	public List<Integer> postorderTraversal0(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		pos(root, res);
		return res;
	}

	public void pos(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		pos(root.left, res);
		pos(root.right, res);
		res.add(root.val);
	}
}
