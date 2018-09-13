package Leetcode_520_DetectCapital;

/*
	����һ�����ʣ�����Ҫ�жϵ��ʵĴ�дʹ���Ƿ���ȷ��
	
	���Ƕ��壬���������ʱ�����ʵĴ�д�÷�����ȷ�ģ�
	
	ȫ����ĸ���Ǵ�д������"USA"��
	������������ĸ�����Ǵ�д������"leetcode"��
	������ʲ�ֻ����һ����ĸ��ֻ������ĸ��д�� ���� "Google"��
	�������Ƕ����������û����ȷʹ�ô�д��ĸ��
	
	ʾ�� 1:	
		����: "USA"
		���: True
	ʾ�� 2:	
		����: "FlaG"
		���: False
	ע��: �������ɴ�д��Сд������ĸ��ɵķǿյ��ʡ�
*/
public class DetectCapital {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String s = "USA";
		DetectCapital dc = new DetectCapital();
		System.out.println(dc.detectCapitalUse(s));
	}

	
	// 520.����д��ĸ
	public boolean detectCapitalUse(String word) {
		//�ַ��������ڻ���Ϊ���ַ���
		if ( word == null || word == "" )
	        return false;
	    //ͳ�ƴ�д��ĸ�ĸ�˵
	    int count = 0;
	    for (int i = 0; i < word.length(); i++) {
	        if (word.charAt(i) <= 'Z' && word.charAt(i) >= 'A')
	            count++;
	    }
	    //ȫ�Ǵ�д||count==1���ڵ�һ��||ȫ��Сд
	    if (count == word.length() || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') || count == 0) {
	    	return true;
	    }    
	    
	    return false;
	}
//	public boolean detectCapitalUse(String word) {
//		// ���ַ��������ַ�����
//		char[] w = word.toCharArray();
//		if(w.length==1) {
//			return (w[0] >= 'A') & (w[0] <= 'Z');
//		}
//		// ��һ���ַ��Ǵ�д
//		if ((w[0] >= 'A') & (w[0] <= 'Z')) {
//			//����ȫ��д����ȫСд
//			boolean flag = ((w[1] >= 'A') & (w[1] <= 'Z'));//�ڶ���Ϊture/false���涼һ����
//			for(int i =2;i<w.length;i++) {
//				if(((w[i] >= 'A') & (w[i] <= 'Z'))!=flag) {
//					return false;
//				}
//			}
//		}else {
//			//��һ����Сд
//			int i = 1;
//			while(i<w.length){
//				if((w[i] >= 'A') & (w[i] <= 'Z')) {
//					return false;
//				}
//				i++;
//			}
//		}
//		return true;

//	}

}
