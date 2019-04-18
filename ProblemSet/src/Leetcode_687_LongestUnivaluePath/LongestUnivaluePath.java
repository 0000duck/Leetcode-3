package Leetcode_687_LongestUnivaluePath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	����һ�����������ҵ����·����
	���·���е�ÿ���ڵ������ֵͬ�� 
	����·�����Ծ���Ҳ���Բ��������ڵ㡣

	ע�⣺�����ڵ�֮���·������������֮��ı�����ʾ��
	
	Example 1:	
		Input:
		
		              5
		             / \
		            4   5
		           / \   \
		          1   1   5
		Output: 2	 
	
	Example 2:	
		Input:
		
		              1
		             / \
		            4   5
		           / \   \
		          4   4   5
		Output: 2 
	
	ע��: �����Ķ�����������10000����㡣 ���ĸ߶Ȳ�����1000.
 */
// 687. �ֵͬ·��
public class LongestUnivaluePath {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node24 = new TreeNode(4);
		TreeNode node25 = new TreeNode(5);
		TreeNode node34 = new TreeNode(4);
		TreeNode node324 = new TreeNode(4);
		TreeNode node35 = new TreeNode(5);
		root.left = node24;
		root.right = node25;
		node24.left = node34;
		node24.right = node324;
		node25.right = node35;
		LongestUnivaluePath lup = new LongestUnivaluePath();
		System.out.println(lup.longestUnivaluePath(root));

	}

	public int longestUnivaluePath(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		// ����
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// �ڵ���Ϣ
		HashMap<TreeNode, int[]> map = new HashMap<>();
		int res = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			int curres = 0;
			if (curNode.left != null) {
				queue.add(curNode.left);
			}
			if (curNode.right != null) {
				queue.add(curNode.right);
			}
			process(curNode, map);
			int left = map.get(curNode)[0];
			int right = map.get(curNode)[1];
			if (left != 0 && right != 0) {
				curres = left + right;
			} else {
				curres = Math.max(left, right);
			}
			res = Math.max(res, curres);

		}
		return res;
	}

	private int process(TreeNode curNode, HashMap<TreeNode, int[]> map) {
		// ��ֹ����
		if (curNode == null) {
			return 0;
		}
		// ��ǰ�ӵ��val
		int val = curNode.val;
		// ���
		int res = 0;
		// ���������
		int left = 0;
		// ���������
		int right = 0;
		if (map.containsKey(curNode)) {
			left = map.get(curNode)[0];
			right = map.get(curNode)[1];
			res = Math.max(left + 1, right + 1);
			return res;
		}

		if (curNode.left != null && curNode.left.val == val) {
			left = process(curNode.left, map);
		}
		if (curNode.right != null && curNode.right.val == val) {
			right = process(curNode.right, map);
		}
		map.put(curNode, new int[] { left, right });
		res = Math.max(left + 1, right + 1);
		return res;
	}

	// clean
	public int longestUnivaluePath0(TreeNode root) {
		// ȫ�ֱ���res
		int[] res = new int[1];
		if (root != null)
			dfs(root, res);
		return res[0];
	}

	private int dfs(TreeNode node, int[] res) {
		// ������������
		int l = node.left != null ? dfs(node.left, res) : 0;
		// ������������
		int r = node.right != null ? dfs(node.right, res) : 0;
		// ������+��ǰ�ڵ�
		int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
		// ������+��ǰ�ڵ�
		int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
		// ����ȫ�ֽ��
		res[0] = Math.max(res[0], resl + resr);
		// ��������ظ���һ��
		return Math.max(resl, resr); 
	}
}
