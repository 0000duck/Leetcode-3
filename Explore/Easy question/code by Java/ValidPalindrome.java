package Leetcode_125_ValidPalindrome;

/*
	����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��	
	˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
	
	ʾ�� 1:	
		����: "A man, a plan, a canal: Panama"
		���: true
	ʾ�� 2:
		����: "race a car"
		���: false
*/
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println("0P");
		System.out.println(vp.isPalindrome("0P"));
	}

	// 125. ��֤���Ĵ�
	public boolean isPalindrome(String s) {
		// ���ַ�������true
		if (s.equals(" ")) {
			return true;
		}

		//
		for (int i = 0, j = s.length() - 1; (i <= j); i++, j--) {
			// �ж�i�Ƿ�����ĸ������
			while (!isnumorletter(s.charAt(i))) {
				i++;
				if (i == s.length()) {
					return false;
				}
			}
			while (!isnumorletter(s.charAt(j))) {
				j--;
			}
			// �ж�i��j�Ƿ���ȣ������ִ�Сд
			if ((s.charAt(i) >= '0') & (s.charAt(i) <= '9')) {
				if (s.charAt(i) != s.charAt(j)) {
					return false;
				}
			} else if ((s.charAt(i) == s.charAt(j)) || (s.charAt(i) - 32 == s.charAt(j))
					|| (s.charAt(i) + 32 == s.charAt(j))) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isnumorletter(char ch) {
		// �Ƿ�������
		if ((ch >= '0') & (ch <= '9')) {
			return true;
		} else if ((ch >= 'A') & (ch <= 'Z')) {
			// ��д��ĸ
			return true;
		} else if ((ch >= 'a') & (ch <= 'z')) {
			// Сд��ĸ
			return true;
		} else {
			return false;
		}

	}

}
