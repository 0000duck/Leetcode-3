package Leetcode_067_AddBinary;
/*
	���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
	
	����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0��
	
		ʾ�� 1:		
			����: a = "11", b = "1"
			���: "100"
			
		ʾ�� 2:		
			����: a = "1010", b = "1011"
			���: "10101"
 */
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("1010", "1011"));
	}
	
	//67. ���������
    public String addBinary(String a, String b) {
    	
    	int maxlength = Math.max(a.length(), b.length());
    	int minlength = Math.min(a.length(), b.length());
    	//������
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i<maxlength-minlength;i++) {
    		sb.append('0');
    	}
    	
    	if(a.length()>b.length()) {
    		//a��b��,����b
    		sb.append(b);
    		b = sb.toString();
    	}else {
    		//b��a��,����a
    		sb.append(a);
    		a = sb.toString();
    	}
    	
        //����
    	sb = new StringBuilder();    	
    	int flag= 0;//��λ��
    	for(int i = maxlength-1;i>=0;i--) {    	
    		int temp = a.charAt(i)+b.charAt(i)-96+flag;    		
    		if(temp>=2) {
    			temp -= 2;
    			flag = 1;
    		}else {
    			flag = 0;
    		}    		
    		sb.insert(0,temp);
    		if((i==0)&&(flag==1)) {
    			sb.insert(0, 1);
    		}
    		
    	}
    	return sb.toString();
    }

}
