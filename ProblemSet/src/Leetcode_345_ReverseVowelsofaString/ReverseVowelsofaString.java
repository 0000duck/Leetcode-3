package Leetcode_345_ReverseVowelsofaString;

/*
	��дһ�����������ַ�����Ϊ���룬��ת���ַ����е�Ԫ����ĸ��
	
	ʾ�� 1:	
		����: "hello"
		���: "holle"
	
	ʾ�� 2:	
		����: "leetcode"
		���: "leotcede"
	˵��:
		Ԫ����ĸ��������ĸ"y"��

 */
public class ReverseVowelsofaString {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ReverseVowelsofaString rvs = new ReverseVowelsofaString();
		System.out.println(" apG0i4maAs::sA0m4i0Gp0");
		System.out.println(" ipG0A4mAas::si0m4a0Gp0");
		System.out.println(rvs.reverseVowels(" apG0i4maAs::sA0m4i0Gp0"));

	}

	// 345. ��ת�ַ����е�Ԫ����ĸ
	public String reverseVowels(String s) {
		char[] charr = s.toCharArray();
		int i = 0;
		int j = charr.length - 1;
		while (j > i) {
			while ((i < charr.length) && (!isYuan(charr[i]))) {
				i++;
			}
			while ((j >= 0) && (!isYuan(charr[j]))) {
				j--;
			}
			if (i <= j) {
				char temp = charr[i];
				charr[i] = charr[j];
				charr[j] = temp;
			}

			i++;
			j--;
		}
		return new String(charr);
	}

	// Ԫ����ĸ
	public boolean isYuan(char ch) {
		if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') || (ch == 'A') || (ch == 'E')
				|| (ch == 'I') || (ch == 'O') || (ch == 'U')) {
			return true;
		} else {
			return false;
		}
	}

}
