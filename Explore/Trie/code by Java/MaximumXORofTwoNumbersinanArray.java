package Leetcode_421_MaximumXORofTwoNumbersinanArray;

/*
	����һ���ǿ����飬������Ԫ��Ϊ a0, a1, a2, �� , an-1������ 0 �� ai < 2^31 ��	
	�ҵ� ai ��aj ������� (XOR) ������������0 �� i,  j < n ��
	
	������O(n)��ʱ�������������
	
	ʾ��:	
		����: [3, 10, 5, 25, 2, 8]	
		���: 28	
		����: ���Ľ���� 5 ^ 25 = 28.
 */
//421. ��������������������ֵ
public class MaximumXORofTwoNumbersinanArray {
	public int findMaximumXOR(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		NumTrie nt = new NumTrie();
		nt.add(nums[0]);
		int res = Integer.MIN_VALUE;

		for (int i = 1; i < nums.length; i++) {
			res = Math.max(res, nt.maxXor(nums[i]));
			nt.add(nums[i]);
		}

		return res;
	}
}

//ǰ׺���ڵ�
class Node {
	Node[] nexts;

	Node() {
		nexts = new Node[2];
	}
}
//0 xor 0 = 0;1 xor 1 = 0
//0 xor 1 = 1;1 xor 0 = 1
//��ͬΪ1

//����ǰ׺��
class NumTrie {
	// ͷ���
	public Node head = new Node();

	// ��num��ǰ׺��
	public void add(int num) {
		Node cur = head;
		// path λ��λ
		for (int move = 31; move >= 0; move--) {
			int path = ((num >> move) & 1);
			cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
			cur = cur.nexts[path];
		}
	}

	// ����num���������
	public int maxXor(int num) {
		Node cur = head;
		int res = 0;
		// path �Ӹߵ���
		for (int move = 31; move >= 0; move--) {
			int path = (num >> move) & 1;
			// �����õ���ֵ

			// ���λ�������0
			// ����λ�������1
			int best = move == 31 ? path : (path ^ 1);
			// �����������ֵ��ȡ����ֵ��������ȡ���
			best = cur.nexts[best] != null ? best : (best ^ 1);
			res |= (path ^ best) << move;
			cur = cur.nexts[best];
		}
		return res;
	}

}