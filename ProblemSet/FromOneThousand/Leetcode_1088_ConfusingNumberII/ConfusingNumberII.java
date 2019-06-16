package Leetcode_1088_ConfusingNumberII;
/*
	�������ǻὫ������ת 180�� ������һ���µ����֡�
	���� 0��1��6��8��9 ��ת 180�� �Ժ����ǵõ��������ֱַ�Ϊ 0��1��9��8��6��
	2��3��4��5��7 ��ת 180�� ���� �޷� �õ��κ����ֵġ�
	�׻�������Confusing Number��ָ����һ��������������ת 180�� �Ժ��ܹ��õ�һ����ԭ�� ��ͬ �������������ֵ�ÿһλ��Ӧ������Ч�ġ�����ע�⣬��ת��õ��������ֿ��ܴ���ԭ���֣�
	���������� N�����㷵�� 1 �� N ֮���׻������ֵ������� 
	
	ʾ�� 1��
		���룺20
		�����6
		���ͣ�
			�׻�����Ϊ [6,9,10,16,18,19]��
			6 ת��Ϊ 9
			9 ת��Ϊ 6
			10 ת��Ϊ 01 Ҳ���� 1
			16 ת��Ϊ 91
			18 ת��Ϊ 81
			19 ת��Ϊ 61
	
	ʾ�� 2��
		���룺100
		�����19
		���ͣ�
		�׻�����Ϊ [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100]��
 */

//1088.�׻����� II
public class ConfusingNumberII {
	public static void main(String[] args) {
		System.out.println(new ConfusingNumberII().confusingNumberII(100));
	}	
	
    public int confusingNumberII(int N) {
        int num = 1;
        int count = 0;
        while(num<=N) {
        	if(isConfusing(num)) {        		
        		count++;        		
        	}
        	num = nextNum(num);
        }
        return count;
    }
    /**
     * ��һ����0,1,6,8,9��ɵ���
     * @param num
     * @return
     */
	private int nextNum(int num) {		
		if(num%10==0) {
			num+=1;
		}else if(num%10==1) {
			num+=5;
		}else if(num%10==6) {
			num+=2;
		}else if(num%10==8) {
			num+=1;
		}else {			
            num++;
            int temp = num;
            int multiple = 1;
            while (temp > 0) {
            	//�жϸ���λ�ǲ�����0,1,6,8,9���
                while (!isValid(temp % 10)) {
                	//��ǰλ������0,1,6,8,9
                    temp++;
                    num += multiple;
                }
                temp /= 10;
                multiple *= 10;
            }
			
		}
		return num;
	}

	private boolean isConfusing(int num) {
		String str1 = String.valueOf(num);
		char[] s1 = str1.toCharArray();
		char[] s2 = new char[s1.length];
		for(int i = 0;i<s1.length;i++) {			
			if(s1[i]=='6') {
				s2[s1.length-1-i] = '9';
			}else if(s1[i]=='9') {
				s2[s1.length-1-i] = '6';
			}else {
				s2[s1.length-1-i] = s1[i];
			}			
		}
		return !str1.equals(String.valueOf(s2));
		
	}
	private boolean isValid(int c) {
		return c==0||c==1||c==6||c==8||c==9;
	}
}
