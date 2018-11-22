package Leetcode_167_TwoSum2Inputarrayissorted;



/*

	����һ���Ѱ����������� ���������飬�ҵ�������ʹ���������֮�͵���Ŀ������
	����Ӧ�÷����������±�ֵ index1 �� index2������ index1 ����С�� index2��
	
	˵��:	
		���ص��±�ֵ��index1 �� index2�����Ǵ��㿪ʼ�ġ�
		����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
		
	ʾ��:	
		����: numbers = [2, 7, 11, 15], target = 9
		���: [1,2]
		����: 2 �� 7 ֮�͵���Ŀ���� 9 ����� index1 = 1, index2 = 2 ��

*/

public class TwoSum2 {

	public static void main(String[] args) {
		
	}

	// 167. ����֮�� II - ������������
	public int[] twoSum1(int[] numbers, int target) {

		int[] sum = new int[2];
		for (int i = 1; i < numbers.length; i++) {
			sum[1] = i + 1;
			for (int j = 0; j < i; j++) {
				if (numbers[i] + numbers[j] == target) {
					sum[0] = j + 1;
					return sum;
				}
			}
		}
		return sum;
	}

	// ���ֲ���
	public int[] twoSum(int[] numbers, int target) {
		// ����������
		int[] result = new int[2];
		// �ӵ�2�����ֿ�ʼ�����������
		for (int i = 1; i < numbers.length; i++) {
			// ��¼������λ��
			result[1] = i + 1;
			// ���ֲ���С����
			int left = 0;
			int right = i - 1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (numbers[mid] + numbers[i] == target) {
					result[0] = mid + 1;
					return result;
				} else if (numbers[mid] + numbers[i] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return result;
	}
}
