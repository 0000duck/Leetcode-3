package Leetcode_1110_DeleteNodesAndReturnForest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	�����������ĸ��ڵ� root������ÿ���ڵ㶼��һ����ͬ��ֵ��	
	����ڵ�ֵ�� to_delete �г��֣����ǾͰѸýڵ������ɾȥ�����õ�һ��ɭ�֣�һЩ���ཻ�������ɵļ��ϣ���	
	����ɭ���е�ÿ����������԰�����˳����֯�𰸡�	 
	
	ʾ����	
		���룺root = [1,2,3,4,5,6,7], to_delete = [3,5]
		�����[[1,2,null,4],[6],[7]]	 
	
	��ʾ��	
		���еĽڵ������Ϊ 1000��
		ÿ���ڵ㶼��һ������ 1 �� 1000 ֮���ֵ���Ҹ�����ͬ��
		to_delete.length <= 1000
		to_delete ����һЩ�� 1 �� 1000��������ͬ��ֵ��
 */

//1110.ɾ�����
public class DeleteNodesAndReturnForest {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> res = new ArrayList<>();
		res.add(root);
		HashSet<Integer> delSet = new HashSet<>();
		for (int i : to_delete) {
			delSet.add(i);
		}

		// ���������
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			// ��ɾ���ڵ��Ҷ�ӽڵ����list
			if (delSet.contains(temp.val)) {
				if (res.contains(temp)) {
					res.remove(temp);
				}

				if (temp.left != null) {
					res.add(temp.left);
				}
				if (temp.right != null) {
					res.add(temp.right);
				}
			}
			// ��ɾ���Ľڵ����丸�ڵ�Ͽ�
			if (temp.left != null) {
				queue.add(temp.left);
				if (delSet.contains(temp.left.val)) {
					temp.left = null;
				}
			}
			if (temp.right != null) {
				queue.add(temp.right);
				if (delSet.contains(temp.right.val)) {
					temp.right = null;
				}
			}

		}
		return res;
	}
}
