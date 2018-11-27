package Leetcode_893_GroupsofSpecialEquivalentStrings;

import java.util.Arrays;

/*
	�㽫�õ�һ���ַ������� A��
	�����������������ƶ���S == T����ô�����ַ��� S �� T ������ȼ۵ġ�
	һ���ƶ�����ѡ���������� i �� j���� i��2 == j��2�����ҽ��� S[j] �� S [i]��
	���ڹ涨��A �е�����ȼ��ַ������� A �ķǿ��Ӽ� S���������� S �е��κ��ַ����� S �е��κ��ַ�������������ȼ۵ġ�
	
	���� A ������ȼ��ַ������������
	
	ʾ�� 1��
		���룺["a","b","c","a","c","c"]
		�����3
		���ͣ�3 �� ["a","a"]��["b"]��["c","c","c"]
		
	ʾ�� 2��
		���룺["aa","bb","ab","ba"]
		�����4
		���ͣ�4 �� ["aa"]��["bb"]��["ab"]��["ba"]
		
	ʾ�� 3��
		���룺["abc","acb","bac","bca","cab","cba"]
		�����3
		���ͣ�3 �� ["abc","cba"]��["acb","bca"]��["bac","cab"]
		
	ʾ�� 4��
		���룺["abcd","cdab","adcb","cbad"]
		�����1
		���ͣ�1 �� ["abcd","cdab","adcb","cbad"]
		
	 
	
	��ʾ��
		1 <= A.length <= 1000
		1 <= A[i].length <= 20
		���� A[i] ��������ͬ�ĳ��ȡ�
		���� A[i] ��ֻ��Сд��ĸ��ɡ�
 */
public class GroupsofSpecialEquivalentStrings {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		GroupsofSpecialEquivalentStrings gses = new GroupsofSpecialEquivalentStrings();
		String[] A = { "abcd", "cdab", "adcb", "cbad" };

		System.out.println(gses.numSpecialEquivGroups(A));
	}

	// 893. ����ȼ��ַ�����(269 ms)
	public int numSpecialEquivGroups(String[] A) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != null) {
				count++;
				int j = i + 1;
				while (j < A.length) {
					if (A[i].equals(A[j])) {
						A[j] = null;
						j++;
						continue;
					}
					// �ж��Ƿ��ǵȼۣ��ȼ��ÿ�
					if (A[j] == null) {
						j++;
						continue;
					}
					if (A[i].length() == A[j].length()) {
						// A[i] A[j]
						// �ǵȼ��ַ���
						if (isSpecialEquivalent(A[i], A[j])) {
							A[j] = null;
						} else {
							j++;
							continue;
						}
					} else {
						j++;
						continue;
					}
				}
			}
		}
		return count;
	}

	private boolean isSpecialEquivalent(String a, String b) {
		// TODO Auto-generated method stub
		if (a.length() == 1) {
			return a.equals(b);
		}
		// ż��λ����
		char[] atemp = new char[(a.length() + 1) / 2];
		char[] btemp = new char[(a.length() + 1) / 2];
		// ����λ����
		char[] atemp2 = new char[a.length() / 2];
		char[] btemp2 = new char[a.length() / 2];

		int index1 = 0;
		int index2 = 0;

		for (int i = 0; i < a.length(); i++) {
			if (i % 2 == 0) {
				atemp[index1] = a.charAt(i);
				btemp[index1++] = b.charAt(i);

			} else {
				atemp2[index2] = a.charAt(i);
				btemp2[index2++] = b.charAt(i);
			}
		}
		// ����
		Arrays.sort(atemp);
		Arrays.sort(btemp);
		for (int i = 0; i < atemp.length; i++) {
			if (atemp[i] != btemp[i]) {
				return false;
			}
		}
		Arrays.sort(atemp2);
		Arrays.sort(btemp2);
		for (int i = 0; i < atemp2.length; i++) {
			if (atemp2[i] != btemp2[i]) {
				return false;
			}
		}
		return true;

	}

}
