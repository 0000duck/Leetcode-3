package Leetcode_387_FirstUniqueCharacterinaString;

/*
	����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��
	
	����:	
		s = "leetcode"
		���� 0.
	
		s = "loveleetcode",
		���� 2.
*/
public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstUniqueCharacterinaString fucs = new FirstUniqueCharacterinaString();
		System.out.println("cabccaddcd");
		System.out.println(fucs.firstUniqChar("cabccaddcd"));

	}
	//387.�ַ����еĵ�һ��Ψһ�ַ�
	public int firstUniqChar(String s) {
		// �ַ�������Ϊ1
		if (s.length() == 1) {
			return 0;
		}
		// �ַ�����
		char[] chs = s.toCharArray();
		int length = chs.length;
		int[] flag = new int[chs.length];
		for (int i = 0; i < length; i++) {
			// ǰ���Ƿ����
			if (i > 0) {
				if (flag[i - 1] == 0) {
					return i - 1;
				}
			}
			if (flag[i] != 0) {
				continue;
			}
			// ���һλ
			if (i == length - 1) {
				return i;
			}
			for (int j = i + 1; j < length; j++) {
				if (flag[j] != 0) {
					continue;
				}
				if (chs[i] == chs[j]) {
					flag[i]++;
					flag[j]++;
				}
			}

		}
		return -1;

	}

}
