package Leetcode_657_RobotReturntoOrigin;
/*
	�ڶ�άƽ���ϣ���һ�������˴�ԭ�� (0, 0) ��ʼ�����������ƶ�˳���ж����������������ƶ����Ƿ��� (0, 0) ��������
	�ƶ�˳�����ַ�����ʾ���ַ� move[i] ��ʾ��� i ���ƶ���
	�����˵���Ч������ R���ң���L���󣩣�U���ϣ��� D���£���
	�����������������ж����󷵻�ԭ�㣬�򷵻� true�����򣬷��� false��
	
	ע�⣺
		�����ˡ��泯���ķ����޹ؽ�Ҫ�� ��R�� ��ʼ��ʹ�����������ƶ�һ�Σ���L�� ��ʼ�������ƶ��ȡ�
		���⣬����ÿ���ƶ������˵��ƶ�������ͬ��
	
	ʾ�� 1:
		����: "UD"
		���: true
	���ͣ������������ƶ�һ�Σ�Ȼ�������ƶ�һ�Ρ����ж�����������ͬ�ķ��ȣ���������ջص�����ʼ��ԭ�㡣��ˣ����Ƿ��� true��
	ʾ�� 2:	
		����: "LL"
		���: false
	���ͣ������������ƶ����Ρ�������λ��ԭ�����࣬��ԭ�������� ���ƶ��� �ľ��롣���Ƿ��� false����Ϊ�����ƶ�����ʱû�з���ԭ�㡣
*/
public class RobotReturntoOrigin {

	public static void main(String[] args) {
		
	}
	public boolean judgeCircle(String moves) {
		if(moves.length()%2==1) {
			return false;
		}
		
		int lcount = 0;
		int rcount = 0;
		int ucount = 0;
		int dcount = 0;
		for(int i = 0;i<moves.length();i++) {
			char ch = moves.charAt(i);
			if(ch=='L') {
				lcount++;
			}else if(ch=='R') {
				rcount++;
			}else if(ch=='U') {
				ucount++;
			}else{
				dcount++;
			}
		}
		if((lcount==rcount)&&(ucount==dcount)) {
			return true;
		}
		return false;
	}
	/*
	//��ʱ
	public boolean judgeCircle(String moves) {
		//��¼�����˵�λ������		
        int[] location = new int[2];
        //���ַ���ת��Ϊ�ַ�����
        char[] ch = moves.toCharArray();
        //�����ַ�������
        for(int i = 0;i<ch.length;i++) {        	
        	if(ch[i]=='R') {
        		//���ң�location[1]+1;
        		location[1]+=1;        		
        	}else if(ch[i]=='L') {
        		//����location[1]-1;
        		location[1]-=1;      
        	}else if(ch[i]=='U') {
        		//���ϣ�location[0]+1;
        		location[0]+=1;      
        	}else {
        		//���£�location[0]-1;
        		location[0]-=1;      
        	}
        }
        if((location[0]==0)&(location[1]==0)) {
        	return true;
        }
        return false;
    }
    */

}
