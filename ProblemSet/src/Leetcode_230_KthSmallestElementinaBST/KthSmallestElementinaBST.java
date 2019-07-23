package Leetcode_230_KthSmallestElementinaBST;

import TreeNode.TreeNode;
import TreeNode.TreeNodeUtils;

/*
	����һ����������������дһ������ kthSmallest ���������е� k ����С��Ԫ�ء�
	
	˵����
		����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����
	
	ʾ�� 1:	
		����: root = [3,1,4,null,2], k = 1
		   3
		  / \
		 1   4
		  \
		   2
		���: 1
	ʾ�� 2:	
		����: root = [5,3,6,2,4,null,null,1], k = 3
			       5
			      / \
			     3   6
			    / \
			   2   4
			  /
			 1
		���: 3
	���ף�
		��������������������޸ģ�����/ɾ����������������ҪƵ���ز��ҵ� k С��ֵ���㽫����Ż� kthSmallest ������
 */

//230.�����������е�KС��Ԫ��
public class KthSmallestElementinaBST {
	public static void main(String[] args) {
		String[] arr = { "3", "1", "4", "null", "2" };
		TreeNode root = TreeNodeUtils.createTree(arr);
		TreeNodeUtils.printTree(root);
		new KthSmallestElementinaBST().kthSmallest(root, 1);
	}

	public int kthSmallest(TreeNode root, int k) {
		int[] res = new int[2];
		// res[0]��ǰ�Ѿ������˶��ٽڵ�
		// res[1]��k��ֵ�Ƕ���
		traverse(root, k, res);
		return res[1];
	}

	// ������������Ҽ�¼�������ж��ٸ��ڵ�
	public void traverse(TreeNode root, int k, int[] res) {
		if (root == null) {
			return;
		}

		// �жϼ���
		if (res[0] < k) {
			traverse(root.left, k, res);
			res[0]++;
			if (res[0] == k) {
				res[1] = root.val;
				return;
			}
			traverse(root.right, k, res);
		}

	}
}
