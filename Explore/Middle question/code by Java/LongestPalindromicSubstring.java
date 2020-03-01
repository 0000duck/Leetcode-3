package Leetcode_005_LongestPalindromicSubstring;

/*
	����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
	
	ʾ�� 1��	
		����: "babad"
		���: "bab"
		ע��: "aba" Ҳ��һ����Ч�𰸡�
	ʾ�� 2��	
		����: "cbbd"
		���: "bb"
 */

//5.������Ӵ�
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "babad";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome0(s));

	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String temp = s.substring(i, j);
				if (isPalindromic(temp) && temp.length() > result.length()) {
					result = temp;
				}
			}
		}
		return result;
	}

	private boolean isPalindromic(String temp) {
		for (int i = 0; i < temp.length() / 2; i++) {
			if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	//6ms
	public String longestPalindrome0(String s) {
		int length = s.length();

		int[] range = new int[2];
		for (int i = 0; i < length; i++) {
			i = helper(s, range, i);
		}

		return s.substring(range[0], range[1]);
	}

	public int helper(String s, int[] range, int i) {
		int lo = i;
		int hi = i;
		//��������ͬ���ַ�
		while (hi < s.length() - 1 && s.charAt(hi) == s.charAt(hi + 1)) {
			hi++;
		}
		int ret = hi;
		
		//i-1,i+1,�һ���
		while (lo > 0 && hi < s.length() - 1 && s.charAt(lo - 1) == s.charAt(hi + 1)) {
			lo--;
			hi++;
		}
		//�жϳ��ȣ���¼���ķ�Χ
		if (hi - lo + 1 > range[1] - range[0]) {
			range[0] = lo;
			range[1] = hi + 1;
		}

		return ret;
	}
}
