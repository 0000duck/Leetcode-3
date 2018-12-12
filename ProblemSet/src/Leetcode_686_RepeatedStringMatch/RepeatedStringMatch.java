package Leetcode_686_RepeatedStringMatch;

/*
	���������ַ��� A �� B, Ѱ���ظ������ַ���A����С������ʹ���ַ���B��Ϊ���Ӻ���ַ���A���Ӵ�������������򷵻� -1��
	
	�ٸ����ӣ�A = "abcd"��B = "cdabcdab"��	
	��Ϊ 3�� ��Ϊ A �ظ����������Ϊ ��abcdabcdabcd������ʱ B �����Ӵ���A �ظ����������Ϊ"abcdabcd"��B ���������Ӵ���
	
	ע��:	
	 	A �� B �ַ����ĳ�����1��10000���䷶Χ�ڡ�
*/
public class RepeatedStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedStringMatch rsm = new RepeatedStringMatch();
		System.out.println(rsm.repeatedStringMatch("abcd", "cdabcdab"));
	}

	// 686. �ظ������ַ���ƥ��
	public int repeatedStringMatch(String A, String B) {
		// ������
		int count = 1;
		StringBuilder abuilder = new StringBuilder(A);
		while (count <= B.length() / A.length() + 2) {
			if (abuilder.indexOf(B) != -1) {
				return count;
			}
			count++;
			abuilder.append(A);
		}
		return -1;
	}

	// 6ms
	public int repeatedStringMatch0(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		int indexA = 0;
		int indexB = 0;
		while (indexB < lenB) {
			if (lenA < lenB && indexA >= 2 * lenB) {
				return -1;
			}

			if (lenA >= lenB && indexA >= 2 * lenA) {
				return -1;
			}

			if (A.charAt(indexA % lenA) == B.charAt(indexB)) {
				indexA++;
				indexB++;
			} else if (indexB == 0) {
				indexA++;
			} else {
				// TODO find next ch(b)
				int i = indexA + 1;
				for (; i < indexA + 1 + lenB; i++) {
					if (A.charAt(i % lenA) == B.charAt(indexB)) {
						break;
					}
				}
				if (i == indexA + 1 + lenB)
					return -1;
				indexA = i - indexB;
				indexB = 0;
			}
		}
		return (indexA - 1) / lenA + 1;
	}

}
