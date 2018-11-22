package Leetcode_696_CountBinarySubstrings;

/*
	����һ���ַ��� s�����������ͬ����0��1�ķǿ�(����)���ַ�����������������Щ���ַ����е�����0������1���������һ��ġ�	
	�ظ����ֵ��Ӵ�Ҫ�������ǳ��ֵĴ�����
	
	ʾ�� 1 :		
		����: "00110011"
		���: 6
		����: ��6���Ӵ�������ͬ����������1��0����0011������01������1100������10������0011�� �� ��01����	
	��ע�⣬һЩ�ظ����ֵ��Ӵ�Ҫ�������ǳ��ֵĴ�����	
	���⣬��00110011��������Ч���Ӵ�����Ϊ���е�0����1��û�������һ��
	
	ʾ�� 2 :	
		����: "10101"
		���: 4
		����: ��4���Ӵ�����10������01������10������01�������Ǿ�����ͬ����������1��0��
	ע�⣺	
		s.length ��1��50,000֮�䡣
		s ֻ������0����1���ַ���
 */
public class CountBinarySubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountBinarySubstrings cbs = new CountBinarySubstrings();
		cbs.countBinarySubstrings("00110");
	}

	// 696. �����������Ӵ�
	public int countBinarySubstrings(String s) {
		char[] charArr = s.toCharArray();
		int[] group = new int[2];
		int result = 0;
		group[1] = 1;
		for (int i = 1; i < charArr.length; i++) {
			if (charArr[i] == charArr[i - 1]) {
				group[1]++;
			} else {				
				result+=Math.min(group[0], group[1]);				
				group[0] = group[1];
				group[1] = 1;
			}
		}
		result+=Math.min(group[0], group[1]);
		return result;
	}
}
