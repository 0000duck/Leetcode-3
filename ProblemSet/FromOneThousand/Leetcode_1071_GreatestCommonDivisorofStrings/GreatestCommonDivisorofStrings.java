package Leetcode_1071_GreatestCommonDivisorofStrings;

/*
	�����ַ��� S �� T��ֻ���� S = T + ... + T��T ���������� 1 �λ��Σ�ʱ�����ǲ��϶� ��T �ܳ��� S����
	�����ַ��� X��Ҫ������ X �ܳ��� str1 �� X �ܳ��� str2�� 
	
	ʾ�� 1��
		���룺str1 = "ABCABC", str2 = "ABC"
		�����"ABC"
	ʾ�� 2��
		���룺str1 = "ABABAB", str2 = "ABAB"
		�����"AB"
	ʾ�� 3��
		���룺str1 = "LEET", str2 = "CODE"
		�����""
	��ʾ��
		1 <= str1.length <= 1000
		1 <= str2.length <= 1000
		str1[i] �� str2[i] Ϊ��дӢ����ĸ 

 */

//1071.�ַ������������
public class GreatestCommonDivisorofStrings {
	public static void main(String[] args) {
		String str1 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String str2 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String out = new GreatestCommonDivisorofStrings().gcdOfStrings(str1, str2);
		System.out.println(out);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println(out.length());

	}

	public String gcdOfStrings0(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int length3 = gcd(length1, length2);
		String str3 = str1.substring(0, length3);
		if (isMatch(str1, str3) && (isMatch(str2, str3))) {
			return str3;
		} else {
			return "";
		}
	}

	/**
	 * �����Լ����շת�����
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int gcd(int a, int b) {
		int rem = 0;
		while (b != 0) {
			rem = a % b;
			a = b;
			b = rem;
		}
		return a;
	}

	private boolean isMatch(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i % s2.length())) {
				return false;
			}
		}
		return true;
	}

//----------------------------�Ľ���---------------------------------------	

	public String gcdOfStrings(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int minlength = Math.min(length1, length2);
		for (int i = 0; i < minlength; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return "";
			}
		}
		while (minlength > 0) {
			String t = str2.substring(0, minlength);
			if (length1 % minlength == 0 && length2 % minlength == 0 && isMatch(str1, t) && isMatch(str2, t)) {
				return t;
			}
			minlength--;
		}
		return "";

	}

//-----------------------------ԭʼ��--------------------------------------	
	public String gcdOfStrings2(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int minlength = Math.min(length1, length2);
		for (int i = 0; i < minlength; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return "";
			}
		}
		while (minlength > 0) {
			String t = str2.substring(0, minlength);
			if (length1 % minlength == 0 && length2 % minlength == 0 && sloution(length1 / minlength, str1, t)
					&& sloution(length2 / minlength, str2, t)) {
				return t;
			}
			minlength--;
		}
		return "";

	}

	private boolean sloution(int time, String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < time; i++) {
			sb.append(str2);
		}
		return sb.toString().equals(str1);
	}

}
