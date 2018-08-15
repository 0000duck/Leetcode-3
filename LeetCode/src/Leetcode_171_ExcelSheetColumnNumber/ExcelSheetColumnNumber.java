package Leetcode_171_ExcelSheetColumnNumber;
/*
	����һ��Excel����е������ƣ���������Ӧ������š�
	
	���磬	
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
	    ...
	    
	ʾ�� 1:		
		����: "A"
		���: 1
		
	ʾ�� 2:	
		����: "AB"
		���: 28
		
	ʾ�� 3:	
		����: "ZY"
		���: 701
*/
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        //��ȡ�ַ����ĳ���
		int length = s.length();
		int sum = 0;
		//�����ַ���
		for(int i = 0;i<length;i++) {
			int temp = s.charAt(i)-64;
			sum += Math.pow(26, length-1-i)*temp;
		}
		return sum;
		
    }
}
