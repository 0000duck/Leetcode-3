package Leetcode_028_ImplementstrStr;

/*
	ʵ�� strStr() ������
	����һ�� haystack �ַ�����һ�� needle �ַ�����
	�� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)��
	��������ڣ��򷵻�  -1��
	
	ʾ�� 1:
		����: haystack = "hello", needle = "ll"
		���: 2
	ʾ�� 2:
		����: haystack = "aaaaa", needle = "bba"
		���: -1
	
	˵��:	
	�� needle �ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣	
	���ڱ�����ԣ��� needle �ǿ��ַ���ʱ����Ӧ������ 0 ��
	����C���Ե� strstr() �Լ� Java�� indexOf() ���������
*/
public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ImplementstrStr issS = new ImplementstrStr();
		System.out.println(issS.strStr("mississippi", "pi"));		
		
	}
	//28.ʵ��strStr() 
	// ʵ��String.indexof(String str)�Ĺ���
	public int strStr(String haystack, String needle) {
		// needleΪ��ʱ����0
		if (needle.equals("")) {
			return 0;
		}
		// haystack�ĳ���
		int hlength = haystack.length();
		// needle�ĳ���
		int nlength = needle.length();
		if(nlength==hlength) {
			if(haystack.equals(needle)) {
				return 0;
			}
		}else if(nlength>hlength) {
			return -1;
		}
		StringBuffer haystackbuffer = new StringBuffer(haystack);
		
		for(int i =0;i<hlength-nlength+1;i++) {
			if(haystackbuffer.substring(i, i+nlength).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

}
