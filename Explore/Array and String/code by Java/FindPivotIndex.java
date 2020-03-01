package Leetcode_724_FindPivotIndex;

/*
	����һ���������͵����� nums�����дһ���ܹ��������顰�����������ķ�����
	���������������������������ģ����������������������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
	������鲻����������������ô����Ӧ�÷��� -1����������ж��������������ô����Ӧ�÷��������ߵ���һ����
	
	ʾ�� 1:
		����: 
			nums = [1, 7, 3, 6, 5, 6]
		���: 3
		����: 
			����3 (nums[3] = 6) �������֮��(1 + 7 + 3 = 11)�����Ҳ���֮��(5 + 6 = 11)��ȡ�
			ͬʱ, 3 Ҳ�ǵ�һ������Ҫ�������������
		
	ʾ�� 2:
		����: 
			nums = [1, 2, 3]
		���: -1
		����: 
			�����в��������������������������
	˵��:
	
	nums �ĳ��ȷ�ΧΪ [0, 10000]��
	�κ�һ�� nums[i] ������һ����Χ�� [-1000, 1000]��������
*/
public class FindPivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPivotIndex fpi = new FindPivotIndex();
		int[] nums = { -1, -1, -1, 0, 1, 1 };
		System.out.println(fpi.pivotIndex(nums));
	}

	// 724. Ѱ���������������
	public int pivotIndex(int[] nums) {
		// ����
		int i = 0;
		while (i < nums.length) {
			// iǰ��ĺ�
			int fsum = 0;
			// i����ĺ�
			int bsum = 0;
			for (int m = 0; m < i; m++) {
				fsum += nums[m];
			}
			for (int n = i + 1; n < nums.length; n++) {
				bsum += nums[n];
			}
			if (fsum == bsum) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
