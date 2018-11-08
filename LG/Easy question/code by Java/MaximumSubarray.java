package Leetcode_053_MaximumSubarray;

/*
	����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
	
	ʾ��:	
		����: [-2,1,-3,4,-1,2,1,-5,4],
		���: 6
		����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
	����:	
		������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new MaximumSubarray().maxSubArray(nums));
	}

	// 53. ��������
	public int maxSubArray(int[] nums) {
		
		// Kadane�㷨
		// ���������飬 �ڱ��������У� ����������Ԫ�������ۼ������� ���ۼӽ��С�ڻ����0ʱ�� ����һ��Ԫ�ؿ�ʼ�����¿�ʼ�ۼӡ�
		// �ۼӹ����У� Ҫ��һ������(max_so_far)��¼����ù������ֵ
		// һ�α���֮�� ���� max_so_far �д洢�ļ�Ϊ�����Ƭ�εĺ�ֵ��
		int sum = 0;
		int max_so_far = Integer.MIN_VALUE;
		for(int i = 0;i<nums.length;i++) {
			sum += nums[i];
			max_so_far = Math.max(max_so_far, sum);
			if(sum<=0) {
				sum = 0;
			}
		}
		return max_so_far;
	}

}
