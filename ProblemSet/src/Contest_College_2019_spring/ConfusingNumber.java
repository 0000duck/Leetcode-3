package Contest_College_2019_spring;

/*
	����һ������ N��������������������ʱ�򷵻� true��	
	��ԭ������ת180���Ժ�õ��µ����֡�	
	�� 0, 1, 6, 8, 9 ��ת 180�� �Ժ󣬵õ����µ����� 0, 1, 9, 8, 6 ��	
	2, 3, 4, 5, 7 ��ת 180�� ��,�õ��Ĳ������֡�
	
	�׻������� (confusing number) ����һ��������ת180���Ժ󣬵õ���ԭ����ͬ�����֣��������ֵ�ÿһλ������Ч�ġ�	 
	
	ʾ�� 1��	
		���룺6
		�����true
		���ͣ� 
			�� 6 ��ת 180�� �Ժ�õ� 9��9 ����Ч������ 9!=6 ��
	ʾ�� 2��	
		���룺89
		�����true
		����: 
			�� 89 ��ת 180�� �Ժ�õ� 68��86 ����Ч������ 86!=89 ��
	ʾ�� 3��	
		���룺11
		�����false
		���ͣ�
			�� 11 ��ת 180�� �Ժ�õ� 11��11 ����Ч���ֵ���ֵ���ֲ��䣬���� 11 �����׻������֡� 
	ʾ�� 4��	
		���룺25
		�����false
		���ͣ�
			�� 25 ��ת 180�� �Ժ�õ��Ĳ������֡�
	 
	
	��ʾ��	
		0 <= N <= 10^9
		���Ժ��Ե���ת��õ���ǰ���㣬���磬���������ת��õ� 0008 ��ô�����־��� 8 ��
 */
public class ConfusingNumber {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i + ":" + confusingNumber(i));
		}
	}

	public static boolean confusingNumber(int N) {
		if (N == 0) {
			return false;
		}
		int old = N;
		int temp = 0;
		while (old != 0) {
			int cur = old % 10;
			if (cur == 2 || cur == 3 || cur == 4 || cur == 5 || cur == 7) {
				return false;
			}
			if (cur == 6) {
				temp = temp * 10 + 9;// 6->9
			} else if (cur == 9) {
				temp = temp * 10 + 6;// 9->6
			} else {
				temp = temp * 10 + cur;// 1,8���ֲ���
			}
			old /= 10;
		}

		return temp != N;
	}

}
