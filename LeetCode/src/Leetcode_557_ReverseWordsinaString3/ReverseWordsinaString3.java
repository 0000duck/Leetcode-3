package Leetcode_557_ReverseWordsinaString3;
/*
����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��

ʾ�� 1:
	����: "Let's take LeetCode contest"
	���: "s'teL ekat edoCteeL tsetnoc" 
ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�
*/
public class ReverseWordsinaString3 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
	}
	public String reverseWords(String s) {
		//�ָ��ַ������ַ�����
		String[] strarr = s.split(" ");
		//����ַ���
		String result = "";
		//������ʷ�ת
		for(int i = 0;i<strarr.length;i++) {
			char[] chs = strarr[i].toCharArray();
			for(int j = 0;j<chs.length/2;j++) {
				char temp = chs[j];
				chs[j] = chs[chs.length-1-j];
				chs[chs.length-1-j] = temp;
			}
			result += String.valueOf(chs);
			if(i!=strarr.length-1) {
				result += " ";
			}
		}
		return result;
	}
	/*
	//�����ڴ����� 
	 
	public String reverseWords(String s) {
		String result = "";
		//���巴ת���ָ��ת���飬���
		s = reverseString(s);
		String[] strarr = s.split(" ");
		for(int i =0;i<strarr.length/2;i++) {
			String temp = strarr[i];
			strarr[i] = strarr[strarr.length-1-i];
			strarr[strarr.length-1-i] = temp;			
		}
		for(int i =0;i<strarr.length;i++) {
			result += strarr[i];
			if(i!=strarr.length-1) {
				result += " ";
			}
		}
		return result;
	}
	*/
	/*
	//��ʱ	
	public String reverseWords(String s) {
		String result = "";
		while(s.indexOf(" ")!=-1) {
			//��һ�οո���ֵ�����
			int index = s.indexOf(" ");
			//��ȡ��������,ǰ���str,����
			String str = s.substring(0, index);
			s = s.substring(index);
			//��תstr
			result += reverseString(str);
			result += " ";			
		}
		result += reverseString(s);
		return result;
        
    }
    
	//�ַ�����ת
	public String reverseString(String s) {
        char[] ch = s.toCharArray();
        for(int i = 0;i<ch.length/2;i++) {
        	char temp = ch[i];
        	ch[i] = ch[ch.length-1-i];
        	ch[ch.length-1-i] = temp;
        }
        return String.valueOf(ch);
    }
    */

}
