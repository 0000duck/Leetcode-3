package Leetcode_098_ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

/*
	����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
	
	����һ��������������������������	
		�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
		�ڵ��������ֻ�������ڵ�ǰ�ڵ������
		�������������������������Ҳ�Ƕ�����������
	ʾ�� 1:	
		����:
			    2
			   / \
			  1   3
		���: true
	ʾ�� 2:	
		����:
			    5
			   / \
			  1   4
			     / \
			    3   6
		���: false
	����: 
		����Ϊ: [5,1,4,null,null,3,6]��
		���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��
 */
public class ValidateBinarySearchTree {
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(5);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(6);
//		root.left = node1;
//		root.right = node4;
//		node4.left = node3;
//		node4.right = node6;
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		root.left = node1;
		root.right = node3;
		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
		vbst.isValidBST0(root);
	}

	// 98. ��֤����������
	public boolean isValidBST(TreeNode root) {
		if ((root == null) || (root.left == null && root.right == null)) {
			return true;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = inorder(list, root);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1)) {
				return false;
			}
		}
		return true;

	}
	// �������

	private ArrayList<Integer> inorder(ArrayList<Integer> list, TreeNode root) {
		if (root == null) {
			return list;
		}
		list = inorder(list, root.left);
		list.add(root.val);
		list = inorder(list, root.right);
		return list;
	}

	// 0ms
	int last = 0;// ǰ��
	boolean first = true;// flag

	public boolean isValidBST0(TreeNode node) {

		if (node == null) {
			return true;
		}
		// �������
		if (!isValidBST0(node.left)) {
			return false;
		}
		// ����ǵ�һ����
		if (first) {
			last = node.val;
			first = false;
		} else {
			if (last >= node.val) {
				return false;
			}
			last = node.val;
		}
		// �ж��ұ�
		if (!isValidBST0(node.right)) {
			return false;
		}
		return true;
	}

}
