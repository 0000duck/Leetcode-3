package Leetcode_104_MaximumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;
import TreeNode.TreeNode;

/*
	����һ�����������ҳ��������ȡ�	
	�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����	
	˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
	
	ʾ����
		���������� [3,9,20,null,null,15,7]��
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		�������������� 3 ��
 */
public class MaximumDepthofBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		root.left = node9;
		root.right = node20;
		node20.left = node15;
		node20.right = node7;
		MaximumDepthofBinaryTree mdb = new MaximumDepthofBinaryTree();
		System.out.println(mdb.maxDepth(root));

	}

	// 104. ��������������
	public int maxDepth(TreeNode root) {
		int depth = 0;
		int result = 0;
		if (root == null) {
			return 0;
		}
		return getMaxDepth(root, depth + 1, result);
	}

	private int getMaxDepth(TreeNode root, int depth, int result) {
		if (root == null) {
			return result;
		}

		if (root.left == null && root.right == null) {
			result = Math.max(result, depth);
			return result;
		}

		result = getMaxDepth(root.left, depth + 1, result);
		result = getMaxDepth(root.right, depth + 1, result);
		return result;
	}

	// 0ms
	public int maxDepth0(TreeNode root) {
		return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	// ����DFS 
	public int maxDepth2(TreeNode root) {
		Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
		if(root!=null) {			
			queue.add(new Pair(root,1));
		}
		int depth = 0;
		while(!queue.isEmpty()) {
			Pair<TreeNode,Integer> cur = queue.poll();
			root = cur.getKey();
			int curDepth = cur.getValue();
			if(root!=null) {
				depth = Math.max(depth, curDepth);
				queue.add(new Pair(root.left,curDepth+1));
				queue.add(new Pair(root.right,curDepth+1));
			}
		}
		return depth;		
	}

	// �ݹ�
	public int maxDepth3(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left = maxDepth3(root.left);
		int right = maxDepth3(root.right);
		return Math.max(left, right)+1;
	}

}
