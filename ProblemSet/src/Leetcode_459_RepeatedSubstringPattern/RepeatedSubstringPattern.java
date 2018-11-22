package Leetcode_459_RepeatedSubstringPattern;

/*
	����һ���ǿյ��ַ������ж����Ƿ����������һ���Ӵ��ظ���ι��ɡ��������ַ���ֻ����СдӢ����ĸ�����ҳ��Ȳ�����10000��
	
	ʾ�� 1:	
		����: "abab"	
		���: True	
		����: �������ַ��� "ab" �ظ����ι��ɡ�
	
	ʾ�� 2:	
		����: "aba"	
		���: False
	
	ʾ�� 3:	
		����: "abcabcabcabc"	
		���: True	
		����: �������ַ��� "abc" �ظ��Ĵι��ɡ� (�������ַ��� "abcabc" �ظ����ι��ɡ�)
 */
public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babbabbabbabbab";
		RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
		rsp.repeatedSubstringPattern(s);
	}

	// 459. �ظ������ַ���
	public boolean repeatedSubstringPattern(String s) {
		for (int i = 1; i <= s.length() / 2; i++) {
			if (s.length() % i == 0) {
				String temp = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < s.length() / temp.length(); j++) {
					sb.append(temp);
				}
				if (sb.toString().equals(s)) {
					return true;
				}
			}
		}
		return false;
	}

}
