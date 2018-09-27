package Leetcode_551_StudentAttendanceRecordI;
/*
	����һ���ַ���������һ��ѧ���ĳ��ڼ�¼�������¼���������������ַ���	
		'A' : Absent��ȱ��
		'L' : Late���ٵ�
		'P' : Present������
	���һ��ѧ���ĳ��ڼ�¼�в�����һ��'A'(ȱ��)���Ҳ���������������'L'(�ٵ�),��ô���ѧ���ᱻ���͡�
	
	����Ҫ�������ѧ���ĳ��ڼ�¼�ж����Ƿ�ᱻ���͡�
	
	ʾ�� 1:
		����: "PPALLP"
		���: True
	ʾ�� 2:	
		����: "PPALLL"
		���: False
*/
public class StudentAttendanceRecordI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentAttendanceRecordI sar1 = new StudentAttendanceRecordI();
		System.out.println(sar1.checkRecord("PPALLP"));
		System.out.println(sar1.checkRecord("PPALLL"));
	}
	public boolean checkRecord(String s) {
		//��¼A�ĸ���
		int countA = 0;
		//��¼L�ĸ���
		int countL = 0;
		if(s.charAt(0)=='A') {
			countA++;
		}
		if(s.charAt(0)=='L') {
			countL++;
		}
		for(int i = 1;i<s.length();i++) {
			//ȱ������
			if(s.charAt(i)=='A') {
        		countA++;
        		if(countA>1) {
        			return false;
        		}
        	}
			//�����ٵ�3��
			if(s.charAt(i)=='L') {
				if(s.charAt(i-1)=='L') {
					countL++;
					if(countL==3) {
						return false;
					}
				}else {
					countL=1;
				}
			}			
		}
		return true;
		
		
    }

}
