package Leetcode_410_SplitArrayLargestSum;

/*
	����һ���Ǹ����������һ������ m������Ҫ���������ֳ� m ���ǿյ����������顣���һ���㷨ʹ���� m ����������Ժ͵����ֵ��С��
	
	ע��:
		���鳤�� n ������������:	
		1 �� n �� 1000
		1 �� m �� min(50, n)
	ʾ��:	
		����:
			nums = [7,2,5,10,8]
			m = 2		
		���:
			18		
	����:
		һ�������ַ�����nums�ָ�Ϊ2�������顣
		������õķ�ʽ�ǽ����Ϊ[7,2,5] �� [10,8]��
		��Ϊ��ʱ��������������Եĺ͵����ֵΪ18���������������С��
*/
public class SplitArrayLargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitArrayLargestSum sals = new SplitArrayLargestSum();
		int[] nums = { 7, 2, 5, 10, 8 };
		int m = 2;
		System.out.println(sals.splitArray(nums, m));

	}

	// 410. �ָ���������ֵ
	public int splitArray(int[] nums, int m) {
		int low = nums[0];
		int high = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// �������ֵĺ�
			high += nums[i];
			// ������
			low = Math.max(low, nums[i]);
		}
		// ���ֲ��ң��ҵ��������к����ֵ����С���
		while (low < high) {
			//����ȷ���Ƿ��ܱ�����
			int mid = low + (high - low) / 2;
			// ����ܱ�����
			if (can_split(nums, mid, m)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	//Ϊʲô��
	public boolean can_split(int[] nums, int mid, int m) {
		int sum = 0;
		int cnt = 1;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// ���ڵ�ǰmid��ֵ����Ҫ���·�һ�飬cnt++
			if (sum > mid) {
				sum = nums[i];
				cnt++;
				if (cnt > m) {
					return false;
				}
			}
		}
		return true;
	}

}
