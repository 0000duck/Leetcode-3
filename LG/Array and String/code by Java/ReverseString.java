package Leetcode_344_ReverseString;

/*
	��дһ���������������ǽ�������ַ�����ת������
	
	ʾ�� 1:
		����: "hello"
		���: "olleh"
	ʾ�� 2:
		����: "A man, a plan, a canal: Panama"
		���: "amanaP :lanac a ,nalp a ,nam A"
*/
public class ReverseString {
	// 344.��ת�ַ���
	public String reverseString(String s) {
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length / 2; i++) {
			char temp = ch[i];
			ch[i] = ch[ch.length - 1 - i];
			ch[ch.length - 1 - i] = temp;
		}
		return String.valueOf(ch);
	}

	// ���ǲ���
	public static String myReverse(String s) {
		// ����һ�����ַ���
		String result = "";
		// ���ַ���ת���ַ�����
		char[] chs = s.toCharArray();
		// ���ű����ַ������õ�ÿһ���ַ�
		for (int x = chs.length - 1; x >= 0; x--) {
			// �����ַ�����ÿһ���ַ�ƴ������
			result += chs[x];
		}
		return result;
	}

}
