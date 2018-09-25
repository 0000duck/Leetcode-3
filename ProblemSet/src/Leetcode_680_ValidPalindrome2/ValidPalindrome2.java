package Leetcode_680_ValidPalindrome2;
/*
	����һ���ǿ��ַ��� s�����ɾ��һ���ַ����ж��Ƿ��ܳ�Ϊ�����ַ�����
	
	ʾ�� 1:		
		����: "aba"
		���: True
	ʾ�� 2:	
		����: "abca"
		���: True
	����: �����ɾ��c�ַ���
	ע��:	
		�ַ���ֻ������ a-z ��Сд��ĸ���ַ�������󳤶���50000��
*/
public class ValidPalindrome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome2 vp2 = new ValidPalindrome2();
		String s = "abc";
		System.out.println(vp2.validPalindrome(s));
		
	}
	//680. ��֤�����ַ��� ��
    public boolean validPalindrome(String s) {
    	//�����ַ���������
    	StringBuilder builder = new StringBuilder(s);
    	if(s.equals(builder.reverse().toString())) {
    		return true;
    	}
    	int begindex = 0;
    	while(builder.length()!=0) {    		
        	int endindex = builder.length()-1;
        	if(builder.charAt(endindex)==builder.charAt(begindex)) {
        		builder.deleteCharAt(0);
        		builder.deleteCharAt(builder.length()-1);
        	}else {
        		char temp = builder.charAt(0);
        		String s1 = builder.deleteCharAt(0).toString();
        		if(s1.equals(builder.reverse().toString())) {
        			return true;
        		}else {        			
        			String s2 =builder.append(temp).deleteCharAt(0).toString();
        			return s2.equals(builder.reverse().toString());
        		}       		
        		
        	}    		
    	}
    	return true;
    	
    }
    
}


