package Leetcode_394_DecodeString;

import java.util.Stack;

/*
	����һ������������ַ������������������ַ�����	
	�������Ϊ:
	 k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������	
	�������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�	
	���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻������� 3a �� 2[4] �����롣
	
	ʾ��:	
		s = "3[a]2[bc]", ���� "aaabcbc". 
		s = "3[a2[c]]", ���� "accaccacc".
		s = "2[abc]3[cd]ef", ���� "abcabccdcdcdef".
 */
public class DecodeString {
	// 394. �ַ�������
	public String decodeString(String s) {
		String res = "";
		// ��¼'['֮ǰ������
		Stack<Integer> countStack = new Stack<Integer>();
		// ��¼'['֮ǰ��������
		Stack<String> resStack = new Stack<String>();
		int idx = 0;// �ַ���λ��
		int curNum = 0;// ��ǰ����
		while (idx < s.length()) {
			char ch = s.charAt(idx);
			if (Character.isDigit(ch)) {
				while (Character.isDigit(s.charAt(idx)))
					curNum = 10 * curNum + (s.charAt(idx++) - '0');
			} else if (ch == '[') {
				// ����[��˵�������µĴ�����ԭ�����ַ���ѹ��ջ
				resStack.push(res);
				res = "";// �ÿ�
				// ���µĴ����ظ�����ѹ��ջ
				countStack.push(curNum);
				curNum = 0;// ����
				idx++;
			} else if (ch == ']') {
				// ����]����ǰ��res����
				// tempΪ֮ǰ�Ĵ�
				StringBuilder temp = new StringBuilder(resStack.pop());
				// ƴ�ӵ�ǰ�Ĵ�
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			} else {
				// ������ĸ��ƴ�ӵ���ǰ�Ĵ�
				res += s.charAt(idx++);
			}
		}
		return res;
	}

}
