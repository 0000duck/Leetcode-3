package Leetcode_485_MaxConsecutiveOnes;

/*
	����һ�����������飬 ���������������1�ĸ�����

	ʾ�� 1:		
		����: [1,1,0,1,1,1]
		���: 3
		����: ��ͷ����λ��������λ��������1�������������1�ĸ����� 3.
		
	ע�⣺	
		���������ֻ���� 0 ��1��
		��������ĳ��������������Ҳ����� 10,000��
*/
public class MaxConsecutiveOnes {
	//485. �������1�ĸ���
	public int findMaxConsecutiveOnes(int[] nums) {
		// �����㿪ʼ��λ��
		int zerobeginindex = -1;
		// �����������λ��
		int zeroendindex = -1;
		// ����1�ĳ���
		int onelength = 0;
		int length = 0;

		// ��������,�ҳ����λ��
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zerobeginindex = zeroendindex;
				zeroendindex = i;
				System.out.print("��ʼλ�ã�" + zerobeginindex + ", ");
				System.out.print("����λ�ã�" + zeroendindex + ", ");
				length = (zeroendindex - zerobeginindex - 1);
				System.out.println("1�ĳ���Ϊ��" + length);
				// �жϳ����Ƿ����
				if (length > onelength) {
					onelength = length;
					System.out.println("1�ĳ���Ϊ��" + length);
				}

			}
			// �ж����һλ�������
			if (i == nums.length - 1) {
				length = (nums.length - 1 - zeroendindex);
				// �жϳ����Ƿ����
				if (length > onelength) {
					onelength = length;
					System.out.println("1�ĳ���Ϊ��" + length);
				}
			}

		}
		return onelength;
	}
}
