package BinarySearch_069_SqrtX;
/*
	ʵ�� int sqrt(int x) ������	
	���㲢���� x ��ƽ���������� x �ǷǸ�������	
	���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
	
	ʾ�� 1:	
		����: 4
		���: 2
	ʾ�� 2:	
		����: 8
		���: 2
		˵��: 8 ��ƽ������ 2.82842..., 
		     ���ڷ���������������С�����ֽ�����ȥ��
*/
public class SqrtX {
	//69.x��ƽ����
	public int mySqrt(int x) {
		// С��1
		if (x <= 1) {
			return 1;
		}
		// 0-x���ֲ���
		int left = 0;
		int right = x;	
		while (left < right) {
			int mid = (left + right) / 2;
			if(x/mid>=mid) {
				//mid̫С��
				left = mid +1;
			}else{
				//mid̫����
				right = mid;
			}
		}
		return right-1;
	}
}
