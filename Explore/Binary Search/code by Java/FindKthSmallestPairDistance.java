package Leetcode_719_FindKthSmallestPairDistance;

import java.util.Arrays;

/*
	����һ���������飬������������֮��ĵ� k ����С���롣
	һ�� (A, B) �ľ��뱻����Ϊ A �� B ֮��ľ��Բ�ֵ��
	
	ʾ�� 1:	
		���룺
			nums = [1,3,1]
			k = 1
		�����0 
		���ͣ�
			�����������£�
			(1,3) -> 2
			(1,1) -> 0
			(3,1) -> 2
			��˵� 1 ����С����������� (1,1)������֮��ľ���Ϊ 0��
	��ʾ:	
		2 <= len(nums) <= 10000.
		0 <= nums[i] < 1000000.
		1 <= k <= len(nums) * (len(nums) - 1) / 2.
*/
public class FindKthSmallestPairDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKthSmallestPairDistance fspd = new FindKthSmallestPairDistance();
		int[] nums = { 1, 3, 1 };
		int k = 3;
		System.out.println(fspd.smallestDistancePair(nums, k));
	}

	// 719. �ҳ��� k С�ľ����
	public int smallestDistancePair(int[] nums, int k) {
		// ��������
		Arrays.sort(nums);
		// n������ĳ���
		int n = nums.length;
		// ���ֲ��ң�
		// �ҵ�����<=mid�ĸ���cnt,
		// cnt>=k,��Ҫ��С����right=mid
		// right�ǵ�k������
		int left = 0;
		// right Ϊ����ֵ�����һ�����ּ���һ��
		int right = nums[n - 1] - nums[0];

		while (left < right) {
			// midΪ����������С������м�ֵ
			int mid = left + (right - left) / 2;
			// ��¼С�ڵ���mid�ľ������
			int cnt = 0;
			// start�ǽ�С���ֵ�λ��
			int start = 0;
			// �������飬�Ƚ����С���ֵľ����mid�Ĵ�С
			for (int i = 0; i < n; i++) {
				while (start < n && nums[i] - nums[start] > mid) {
					// �������mid,��С��������
					start++;
				}
				// ����С�ڵ���mid,cnt����
				cnt += (i - start);
			}
			// cnt��kС�����ұ�
			if (cnt < k) {
				left = mid + 1;
			} else {
				// �����
				right = mid;
			}
		}
		//Ϊʲôrightֵ���ǵ�k����С���룿
		return right;
	}

}
