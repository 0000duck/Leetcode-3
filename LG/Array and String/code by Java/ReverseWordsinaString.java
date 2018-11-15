package Leetcode_151_ReverseWordsinaString;

/*
	����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
	
	ʾ��:  	
		����: "the sky is blue",
		���: "blue is sky the".
	˵��:	
		�޿ո��ַ�����һ�����ʡ�
		�����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
		����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
	����: 
		��ѡ��C���Ե��û�����ʹ�� O(1) �ռ临�Ӷȵ�ԭ�ؽⷨ��
 */
public class ReverseWordsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaString rws = new ReverseWordsinaString();
		String s = " ";		
		System.out.println(rws.reverseWords(s));
	}

	// 151. ��ת�ַ�����ĵ���
	public String reverseWords(String s) {
		if((s==null)||(s.length()==0)) {
			return s;
		}
        StringBuilder sb = new StringBuilder(s);        
        StringBuilder result = new StringBuilder();
        //ɾ����β�Ŀո�
        while((sb.length()>0)&&(sb.charAt(0)==' ')) {
        	sb.deleteCharAt(0);
        }
        while((sb.length()>0)&&(sb.charAt(sb.length()-1)==' ')){
        	sb.deleteCharAt(sb.length()-1);
        }
        if((sb.length()==0)&&(sb.indexOf(" ")==-1)){
    		return "";
    	}
        while(sb.length()>0) {
        	//��ȡ�ո��λ��
        	int index = sb.lastIndexOf(" ");
        	//���ڿո��Ҳ������
        	if((index!=-1)&&(index!=sb.length()-1)) {
        		result.append(sb.substring(index+1, sb.length()));
        		sb.delete(index, sb.length());
        		if(sb.length()!=0) {
        			result.append(" ");
        		}        		
        		
        	}else if(index==sb.length()-1) {
        		sb.deleteCharAt(index);
        	}else {
        		result.append(sb.toString());
        		break;
        	}
        }
        
        return result.toString();
        
    }

}
