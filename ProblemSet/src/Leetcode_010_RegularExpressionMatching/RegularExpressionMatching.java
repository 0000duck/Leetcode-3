package Leetcode_010_RegularExpressionMatching;

/*
	����һ���ַ��� (s) ��һ���ַ�ģʽ (p)��ʵ��֧�� '.' �� '*' ��������ʽƥ�䡣
	
	'.' ƥ�����ⵥ���ַ���
	'*' ƥ���������ǰ���Ԫ�ء�
	ƥ��Ӧ�ø��������ַ��� (s) �������ǲ����ַ�����
	
	˵��:	
		s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
		p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
	ʾ�� 1:	
		����:
		s = "aa"
		p = "a"
		���: false
		����: "a" �޷�ƥ�� "aa" �����ַ�����
	ʾ�� 2:	
		����:
		s = "aa"
		p = "a*"
		���: true
		����: '*' �����ƥ���������ǰ���Ԫ��, ������ƥ�� 'a' �����, �ظ� 'a' һ��, �ַ����ɱ�Ϊ "aa"��
	ʾ�� 3:	
		����:
		s = "ab"
		p = ".*"
		���: true
		����: ".*" ��ʾ��ƥ���������('*')�����ַ�('.')��
	ʾ�� 4:	
		����:
		s = "aab"
		p = "c*a*b"
		���: true
		����: 'c' ���Բ����ظ�, 'a' ���Ա��ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
	ʾ�� 5:	
		����:
		s = "mississippi"
		p = "mis*is*p*."
		���: false
 */
//10. ������ʽƥ��
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return isMatch(s, p, 0, 0);
	}

	private boolean isMatch(String s, String p, int i, int j) {
		// p����
		if (j == p.length()) {
			// s�Ƿ����
			return i == s.length();
		}
		// j��p�����һ���ַ�������j+1��*
		// ��ʱ�����s����������false
		// [i]==[j]����[j]='.',��Ҫ�жϣ�i,j+1��
		if (j + 1 == p.length() || p.charAt(j + 1) != '*') {
			return i != s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') && isMatch(s, p, i + 1, j + 1);
		}
		//
		while (i != s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
			if (isMatch(s, p, i, j + 2)) {
				return true;
			}
			i++;
		}
		return isMatch(s, p, i, j + 2);
	}
}
