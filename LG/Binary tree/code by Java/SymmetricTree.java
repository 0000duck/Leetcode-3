package Leetcode_101_SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	����һ����������������Ƿ��Ǿ���ԳƵġ�
	
	���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�	
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
	����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
	
	    1
	   / \
	  2   2
	   \   \
	   3    3
 */
public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(3);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		SymmetricTree st = new SymmetricTree();
		st.isSymmetric2(root);
	}

	// 101. �Գƶ�����

	// �ݹ�
	public boolean isSymmetric0(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric0(root.left, root.right);
	}

	private boolean isSymmetric0(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if ((left != null && right == null) || (left == null && right != null) || (left.val != right.val)) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

	// ����
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.offer(root.left);
		queue2.offer(root.right);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
				return false;
			}
			if (node1 != null) {
				if (node1.val != node2.val) {
					return false;
				}
				queue1.offer(node1.left);
				queue1.offer(node1.right);
				queue2.offer(node2.right);
				queue2.offer(node2.left);
			}
		}
		return true;
	}

}
