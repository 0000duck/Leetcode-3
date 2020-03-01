package Leetcode_268_MissingNumber;

/*
	����һ������ 0, 1, 2, ..., n �� n ���������У��ҳ� 0 .. n ��û�г����������е��Ǹ�����
	
	ʾ�� 1:	
		����: [3,0,1]
		���: 2
	
	ʾ�� 2:	
		����: [9,6,4,2,3,5,7,0,1]
		���: 8
	˵��:
		����㷨Ӧ��������ʱ�临�Ӷȡ����ܷ��ʹ�ö��ⳣ���ռ���ʵ��?
 */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 268. ȱʧ����
	public int missingNumber(int[] nums) {
		int length = nums.length;
		// ����������ܺ�
		int numssum = 0;
		// ����ȫ���е��ܺ�
		int sum = 0;
		for (int i = 1; i < length + 1; i++) {
			sum += i;
			numssum += nums[i - 1];
		}
		return (sum - numssum);
	}

}
