package Leetcode_169_MajorityElement;

/*
	����һ����СΪ n �����飬�ҵ����е�������������ָ�������г��ִ������� [n/2]��Ԫ�ء�
	����Լ��������Ƿǿյģ����Ҹ������������Ǵ���������
	
	ʾ�� 1:	
		����: [3,2,3]
		���: 3
		
	ʾ�� 2:	
		����: [2,2,1,1,1,2,2]
		���: 2
*/
public class MajorityElement {
	public int majorityElement(int[] nums) {

		int i;
		// ���鳤��Ϊ1
		if (nums.length == 1) {
			return nums[0];
		}

		// �������������,�м�λ�õ���һ��������
		for (i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				// ��С����
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}

		}
		

		return nums[nums.length / 2];

	}
}
