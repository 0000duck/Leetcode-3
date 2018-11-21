package Leetcode_389_FindtheDifference;

/*
	���������ַ��� s �� t������ֻ����Сд��ĸ��	
	�ַ��� t ���ַ��� s ������ţ�Ȼ�������λ�����һ����ĸ��	
	���ҳ��� t �б���ӵ���ĸ��
	
	 
	
	ʾ��:	
		���룺
			s = "abcd"
			t = "abcde"		
		�����
			e		
		���ͣ�
			'e' ���Ǹ�����ӵ���ĸ��
 */
public class FindtheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindtheDifference fd = new FindtheDifference();

		System.out.println(fd.findTheDifference("abcd", "abcde"));

	}

	// 389. �Ҳ�ͬ
	public char findTheDifference(String s, String t) {
		char temp = 0x00;
		for (int i = 1; i < s.length(); i++) {
			temp = (char) (temp ^ s.charAt(i));
		}
		for (int i = 0; i < t.length(); i++) {
			temp = (char) (temp ^ t.charAt(i));
		}
		return temp;
	}

}
