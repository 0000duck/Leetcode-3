package Leetcode_434_NumberofSegmentsinaString;

/*
	ͳ���ַ����еĵ��ʸ���������ĵ���ָ���������Ĳ��ǿո���ַ���
	
	��ע�⣬����Լٶ��ַ����ﲻ�����κβ��ɴ�ӡ���ַ���
	
	ʾ��:	
		����: "Hello, my name is John"
		���: 5
*/
public class NumberofSegmentsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofSegmentsinaString nss = new NumberofSegmentsinaString();
		System.out.println(nss.countSegments("Hello, my name is John"));
	}

	// 434. �ַ����еĵ�����
	public int countSegments(String s) {
		if(s.equals("")||s.equals(" ")) {
			return 0;
		}else if(s.length()==1){
			return 1;
		}
		int count = 0;		
		for (int i = 1; i < s.length(); i++) {
			if ((s.charAt(i - 1) != ' ') && (s.charAt(i) == ' ')) {
				count++;
			}
			
		}
		if(s.charAt(s.length() - 1) != ' ')  {
			count++;
		}
		return count;

	}

}
