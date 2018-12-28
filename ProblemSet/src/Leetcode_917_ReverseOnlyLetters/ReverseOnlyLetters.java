package Leetcode_917_ReverseOnlyLetters;

import java.util.Arrays;

/*
	 ����һ���ַ��� S������ ����ת��ġ� �ַ�����
	 ���в�����ĸ���ַ���������ԭ�أ���������ĸ��λ�÷�����ת��
	
	 ʾ�� 1��	
		 ���룺"ab-cd"
		 �����"dc-ba"
	
	 ʾ�� 2��	
		 ���룺"a-bC-dEf-ghIj"
		 �����"j-Ih-gfE-dCba"
	
	 ʾ�� 3��	
		 ���룺"Test1ng-Leet=code-Q!"
		 �����"Qedo1ct-eeLg=ntse-T!"	
	 ��ʾ��	
		 1. S.length <= 100
		 2. 33 <= S[i].ASCIIcode <= 122 
		 3. S �в����� \ or "
 */
public class ReverseOnlyLetters {
	
	// 917. ������ת��ĸ
	public String reverseOnlyLetters(String S) {
		StringBuilder sb = new StringBuilder();
		int head = 0;
		int tail = S.length() - 1;
		int j = 0;

		while (head <= tail) {
			if (head == tail) {
				sb.insert(head, S.charAt(head));
				break;
			}
			if (isWord(S.charAt(head)) && (isWord(S.charAt(tail)))) {
				// ��ͷ��λ�����β
				sb.insert(head, S.charAt(tail));
				// ��β��λ�����ͷ
				sb.insert(sb.length() - j, S.charAt(head));
				j++;
				head++;
				tail--;
			} else if (!isWord(S.charAt(head))) {
				sb.insert(head, S.charAt(head));
				head++;
			} else if (!isWord(S.charAt(tail))) {
				sb.insert(sb.length() - j, S.charAt(tail));
				j++;
				tail--;
			}
		}
		return sb.toString();

	}

	private boolean isWord(char c) {
		if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {
			return true;
		}
		return false;
	}

	// 5ms
	public String reverseOnlyLetters0(String S) {
		int start = 0;
		int end = S.length() - 1;
		char[] c = S.toCharArray();
		while (start < end) {
			while (!((c[start] >= 65 && c[start] <= 90) || (c[start] >= 97 && c[start] <= 122)) && start < end) {
				start++;
			}
			while (!((c[end] >= 65 && c[end] <= 90) || (c[end] >= 97 && c[end] <= 122)) && start < end) {
				end--;
			}
			char temp = c[start];
			c[start++] = c[end];
			c[end--] = temp;
		}
		return String.valueOf(c);
	}

}
