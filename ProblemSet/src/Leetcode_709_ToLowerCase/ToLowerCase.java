package Leetcode_709_ToLowerCase;

/*
 ʵ�ֺ��� ToLowerCase()���ú�������һ���ַ������� str���������ַ����еĴ�д��ĸת����Сд��ĸ��֮�󷵻��µ��ַ�����
	ʾ�� 1��
		����: "Hello"
		���: "hello"
	ʾ�� 2��
		����: "here"
		���: "here"
	ʾ�� 3��
		����: "LOVELY"
		���: "lovely"
 
*/
public class ToLowerCase {

	public String toLowerCase(String str) {
		char[] ch = new char[str.length()];
		ch = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] >= 'A' & ch[i] <= 'Z') {
				ch[i] += 32;
			}			
		}
		return String.valueOf(ch);
	}

}
