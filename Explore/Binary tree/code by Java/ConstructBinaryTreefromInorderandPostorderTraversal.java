package Leetcode_106_ConstructBinaryTreefromInorderandPostorderTraversal;

import TreeNode.TreeNode;

/*
	����һ��������������������������������
	
	ע��:
		����Լ�������û���ظ���Ԫ�ء�
	
	���磬����	
		������� inorder = [9,3,15,20,7]
		������� postorder = [9,15,7,20,3]
		�������µĶ�������	
			    3
			   / \
			  9  20
			    /  \
			   15   7
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		int[] inorder = { 1, 2, 3, 4 };
		int[] postorder = { 3, 4, 2, 1 };
		ConstructBinaryTreefromInorderandPostorderTraversal cbtidt = new ConstructBinaryTreefromInorderandPostorderTraversal();
		cbtidt.buildTree(inorder, postorder);
	}

	// 106. �����������������й��������
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder, int in_left, int in_right, int post_left,
			int post_right) {
		if ((in_left > in_right) || (post_left > post_right)) {
			return null;
		}
		// ���ڵ��ֵ
		int rootVal = postorder[post_right];
		// ���ڵ������������������
		int rootIndex = findRoot(rootVal, inorder);
		// ��ߵĳ���
		int lenOrder = rootIndex - in_left;
		// �ұߵĵĳ���
		int lenPost = in_right - rootIndex;
		// �����ڵ�
		TreeNode root = new TreeNode(rootVal);
		// in_left ��������Ŀ�ʼ�ڵ㡪�� rootIndex-1=in_right
		root.left = buildTree(inorder, postorder, in_left, rootIndex - 1, post_left, post_left + lenOrder - 1);
		root.right = buildTree(inorder, postorder, rootIndex + 1, in_right, post_right - lenPost, post_right - 1);
		return root;
	}

	private int findRoot(int rootVal, int[] inorder) {
		int i;
		for (i = 0; i < inorder.length; i++) {
			if (rootVal == inorder[i]) {
				return i;
			}
		}
		return i;
	}

	// 1ms
	public TreeNode buildTree0(int[] inorder, int[] postorder) {
		return build(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
	}

	public TreeNode build(int[] post, int[] in, int postEnd, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		} else {
			TreeNode root = new TreeNode(post[postEnd]);
			int index = 0;
			for (int i = inEnd; i >= inStart; i--) {
				if (root.val == in[i]) {
					index = i;
					break;
				}
			}

			root.right = build(post, in, postEnd - 1, index + 1, inEnd);
			root.left = build(post, in, postEnd - 1 + index - inEnd, inStart, index - 1);
			return root;
		}
	}
}
