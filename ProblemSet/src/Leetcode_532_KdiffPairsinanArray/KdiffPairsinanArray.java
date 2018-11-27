package Leetcode_532_KdiffPairsinanArray;

import java.util.HashMap;

/*
	����һ�����������һ������ k, ����Ҫ���������ҵ���ͬ�� k-diff ���ԡ����ｫ k-diff ���Զ���Ϊһ�������� (i, j), ���� i �� j ���������е����֣�������֮��ľ���ֵ�� k.
	
	ʾ�� 1:	
		����: [3, 1, 4, 1, 5], k = 2
		���: 2
		����: ������������ 2-diff ����, (1, 3) �� (3, 5)��
		����������������1��������ֻӦ���ز�ͬ�����Ե�������
	
	ʾ�� 2:	
		����:[1, 2, 3, 4, 5], k = 1
		���: 4
		����: ���������ĸ� 1-diff ����, (1, 2), (2, 3), (3, 4) �� (4, 5)��
	
	ʾ�� 3:	
		����: [1, 3, 1, 5, 4], k = 0
		���: 1
		����: ������ֻ��һ�� 0-diff ���ԣ�(1, 1)��
	
	ע��:	
		���� (i, j) ������ (j, i) ������ͬһ���ԡ�
		����ĳ��Ȳ�����10,000��
		��������������ķ�Χ�� [-1e7, 1e7]��
 */
public class KdiffPairsinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KdiffPairsinanArray kpa = new KdiffPairsinanArray();
		int[] nums = { 3, 1, 4, 1, 5 };
		int k = 2;
		System.out.println(kpa.findPairs(nums, k));
	}

	// 532. �����е�K-diff����
	public int findPairs(int[] nums, int k) {
		if (k < 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		//
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] + k) && (map.get(nums[i] + k) != i)) {
				count++;
				map.remove(nums[i] + k);
			}
		}
		return count;

	}

}
