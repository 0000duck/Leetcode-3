package Leetcode_145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

	// 145. �������ĺ������
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

	// ����
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;
		TreeNode last = null;
		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.peek();
			if (cur.right == null || cur.right == last) {
				results.add(cur.val);
				stack.pop();
				// ��¼��һ�����ʵĽڵ�
				// �����жϡ����ʸ��ڵ�֮ǰ���������Ƿ��ѷ��ʹ���
				last = cur;
				// ��ʾ����Ҫת�򣬼�����ջ
				cur = null;
			} else {
				cur = cur.right;
			}
		}

		return results;
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
