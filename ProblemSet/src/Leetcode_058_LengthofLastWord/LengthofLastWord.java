package Leetcode_058_LengthofLastWord;
/*
	����һ����������Сд��ĸ�Ϳո� ' ' ���ַ��������������һ�����ʵĳ��ȡ�
	
	������������һ�����ʣ��뷵�� 0 ��
	
	˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����
	
	ʾ��:	
		����: "Hello World"
		���: 5
*/
public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " ";
		System.out.println(new LengthofLastWord().lengthOfLastWord(s));
		//" "5 length=11 11-1-5=5
	}
	//58. ���һ�����ʵĳ���
    public int lengthOfLastWord(String s) { 
    	if(s.length()==0) {    		
     		return 0;
     	}
    	//�����ַ����ռ�
    	StringBuilder  builder =  new StringBuilder(s);
    	//���һ�����ʵĳ���
    	int length = 0;
    	//���һ��" "������
    	int lastspace = builder.lastIndexOf(" ");
    	//������һ����" "��ɾ��
    	while(lastspace==builder.length()-1) {
    		builder.deleteCharAt(builder.length()-1);
    		if(builder.length()==0) {    		
         		return 0;
    		}
    		lastspace = builder.lastIndexOf(" ");
    	}
    	//�������һ������
     	length = builder.length()-1-lastspace;
     	  
        return length;
    }

}
