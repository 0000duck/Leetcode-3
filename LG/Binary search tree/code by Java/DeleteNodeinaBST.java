package Leetcode_450_DeleteNodeinaBST;

import TreeNode.TreeNode;

/*
	����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е� key ��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣
	���ض������������п��ܱ����£��ĸ��ڵ�����á�
	
	һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺	
		�����ҵ���Ҫɾ���Ľڵ㣻
		����ҵ��ˣ�ɾ������
	˵���� Ҫ���㷨ʱ�临�Ӷ�Ϊ O(h)��h Ϊ���ĸ߶ȡ�
	
	ʾ��:	
		root = [5,3,6,2,4,null,7]
		key = 3
		
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
	
	������Ҫɾ���Ľڵ�ֵ�� 3���������������ҵ� 3 ����ڵ㣬Ȼ��ɾ������
	
	һ����ȷ�Ĵ��� [5,4,6,2,null,null,7], ����ͼ��ʾ��	
		    5
		   / \
		  4   6
		 /     \
		2       7
	
	��һ����ȷ���� [5,2,6,null,4,null,7]��	
		    5
		   / \
		  2   6
		   \   \
		    4   7
 */
public class DeleteNodeinaBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		root.left = node3;
		root.right = node6;
		node3.left = node2;
		node3.right = node4;
		node6.right = node7;
		DeleteNodeinaBST dnbst = new DeleteNodeinaBST();
		dnbst.deleteNode(root, 3);

	}

	// 450. ɾ�������������еĽڵ�
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			// left��right����Ϊ��
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			TreeNode minNode = findMin(root.right);
			// ������������Сֵ�ڵ����rootλ��
			root.val = minNode.val;
			// ɾ���������е���Сֵ�ڵ�
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}

	// �ҵ��������е���Сֵ
	private TreeNode findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
