package Leetcode_703_KthLargestElementinaStream;

import TreeNode.TreeNode;

/*
	���һ���ҵ��������е�K��Ԫ�ص��ࣨclass����
	ע���������ĵ�K��Ԫ�أ����ǵ�K����ͬ��Ԫ�ء�
	
	��� KthLargest ����Ҫһ��ͬʱ�������� k ����������nums �Ĺ��������������������еĳ�ʼԪ�ء�
	ÿ�ε��� KthLargest.add�����ص�ǰ�������е�K���Ԫ�ء�
	
	ʾ��:	
		int k = 3;
		int[] arr = [4,5,8,2];
		KthLargest kthLargest = new KthLargest(3, arr);
		kthLargest.add(3);   // returns 4
		kthLargest.add(5);   // returns 5
		kthLargest.add(10);  // returns 5
		kthLargest.add(9);   // returns 8
		kthLargest.add(4);   // returns 8
	˵��: 
	����Լ��� nums �ĳ��ȡ� k-1 ��k �� 1��
 */
//703. �������еĵ�K��Ԫ��
public class KthLargest {
	TreeNode root;
	int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		for (int num : nums) {
			root = add(root, num);
		}
	}

	public int add(int val) {
		root = add(root, val);
		return findKthLargest();
	}

	private TreeNode add(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		root.count++;
		// val<root.val�����
		if (val < root.val) {
			root.left = add(root.left, val);
		} else {
			// val>root���ұ�
			root.right = add(root.right, val);
		}
		return root;
	}

	public int findKthLargest() {
		int count = k;
		TreeNode walker = root;

		while (count > 0) {
			// �ȼ���������нڵ�ĸ���
			int pos = 1 + (walker.right != null ? walker.right.count : 0);
			// �պ�==count,˵��walker�ǵ�k����
			if (count == pos) {
				break;
			}
			// ���count>pos��˵����k���������
			if (count > pos) {
				// ����count
				count -= pos;
				// ��walker.left���ҵ�count�����
				walker = walker.left;
			} else if (count < pos) {
				// count<pos˵����k��������ұ�
				walker = walker.right;
			}
		}
		return walker.val;
	}

	class TreeNode {
		int val;
		// ��¼�˽ڵ����ж����ӽڵ㣨�����Լ����ڣ�
		int count = 1;
		TreeNode left, right;

		TreeNode(int v) {
			val = v;
		}
	}
}
