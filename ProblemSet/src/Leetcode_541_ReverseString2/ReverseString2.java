package Leetcode_541_ReverseString2;
/*
	����һ���ַ�����һ������ k������Ҫ�Դ��ַ�����ͷ�����ÿ�� 2k ���ַ���ǰk���ַ����з�ת��
	���ʣ������ k ���ַ�����ʣ�������ȫ����ת��
	�����С�� 2k �����ڻ���� k ���ַ�����תǰ k ���ַ�������ʣ����ַ�����ԭ����
	
	ʾ��:
		����: s = "abcdefg", k = 2
		���: "bacdfeg"
	Ҫ��:
		���ַ���ֻ����Сд��Ӣ����ĸ��
		�����ַ����ĳ��Ⱥ� k ��[1, 10000]��Χ�ڡ�
*/
public class ReverseString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String reverseStr(String s, int k) {
		//�����ַ������飬����Ϊs.lengrh/2*k+1
		String result = "";
		int strcount = s.length()/(2*k)+1;
		String[] str = new String[strcount];
		
		
		for(int i = 0;i<strcount;i++) {
			if(i!=strcount-1) {
				str[i] = s.substring(2*i*k, 2*(i+1)*k);
				//System.out.println(str[i]);
				result+=reverseString(str[i],k);				
			}else {
				str[i] = s.substring(2*i*k);
				//System.out.println(str[i]);
				
				if(str[i].length()<=k) {
					result+=reverseString(str[i],str[i].length());					
				}else {
					result+=reverseString(str[i],k);
				}
				
			}			
		}
		
		return result;
	}

	// ��ת2k���ַ���ǰk��
	public String reverseString(String s, int k) {
		char[] ch = s.toCharArray();
		for (int i = 0; i < k / 2; i++) {
			char temp = ch[i];
			ch[i] = ch[k - 1 - i];
			ch[k - 1 - i] = temp;
		}
		return String.valueOf(ch);
	}

}
