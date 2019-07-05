package Leetcode_242_ValidAnagram;

import java.util.Arrays;

/*
	���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ��һ����ĸ��λ�ʡ�
	
	ʾ�� 1:	
		����: s = "anagram", t = "nagaram"
		���: true
	
	ʾ�� 2:	
		����: s = "rat", t = "car"
		���: false
	
	˵��:
		����Լ����ַ���ֻ����Сд��ĸ��
	
	����:
		��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ�����������
 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 242. ��Ч����ĸ��λ��
	public boolean isAnagram(String s, String t) {
		// ���Ȳ��ȣ�����Ϊı
		if (s.length() != t.length()) {
			return false;
		}
		// ���ƹ�ϣ��
		int alphabet[] = new int[26];
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		// ����һ���ַ���������ĸ��
		for (int i = 0; i < sArr.length; i++) {
			alphabet[sArr[i] - 'a']++;
		}
		// ���ڶ����ַ���������ĸ��
		for (int i = 0; i < tArr.length; i++) {
			alphabet[tArr[i] - 'a']--;
		}
		// �����ҵ����
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] != 0) {
				return false;
			}
		}
		return true;

	}

	public boolean isAnagram2(String s, String t) {
		if ((s == null & t != null) || (t == null & s != null)) {
			return false;
		}
		if ((s == null && t == null) || (s.equals(t))) {
			return true;
		}

		if (s.length() != t.length()) {
			return false;
		}

		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();

		Arrays.sort(ss);
		Arrays.sort(tt);

		return String.valueOf(ss).equals(String.valueOf(tt));

	}

}
