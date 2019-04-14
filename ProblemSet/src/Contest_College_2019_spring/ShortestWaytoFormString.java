package Contest_College_2019_spring;

/*
	�����κ��ַ��������ǿ���ͨ��ɾ������һЩ�ַ���Ҳ���ܲ�ɾ������������ַ����������С�	
	����Դ�ַ��� source ��Ŀ���ַ��� target��
	�ҳ�Դ�ַ�������ͨ�������γ�Ŀ���ַ����������е���С������
	����޷�ͨ������Դ�ַ����е�������������Ŀ���ַ������򷵻� -1��	 
	
	ʾ�� 1��	
		���룺source = "abc", target = "abcbc"
		�����2
		���ͣ�Ŀ���ַ��� "abcbc" ������ "abc" �� "bc" �γɣ����Ƕ���Դ�ַ��� "abc" �������С�
	
	ʾ�� 2��	
		���룺source = "abc", target = "acdbc"
		�����-1
		���ͣ�����Ŀ���ַ����а����ַ� "d"�������޷���Դ�ַ����������й���Ŀ���ַ�����
	
	ʾ�� 3��	
		���룺source = "xyz", target = "xzyxz"
		�����3
		���ͣ�Ŀ���ַ������԰����·�ʽ������ "xz" + "y" + "xz"��
	
	��ʾ��	
		source �� target �����ַ�����ֻ���� "a"-"z" ��Ӣ��Сд��ĸ��
		source �� target �����ַ����ĳ��Ƚ��� 1 �� 1000 ֮�䡣
 */
public class ShortestWaytoFormString {
	public static void main(String[] args) {
		String a = "abc";
		String target = "abcbc";
		int res = change(a, target);
		System.out.println(res);
	}

	private static int change(String source, String target) {
		int res = 0;
		char[] s = source.toCharArray();
		char[] t = target.toCharArray();
		for (int i = 0; i < t.length;) {
			boolean flag = false;
			for (int j = 0; j < s.length; j++) {
				if (t[i] == s[j]) {
					i++;
					flag = true;
				}
			}
			res++;
			if (!flag) {
				return -1;
			}
		}
		return res;
	}
}
