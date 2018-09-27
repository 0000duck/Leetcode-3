package Leetcode_605_CanPlaceFlowers;

/*
	��������һ���ܳ��Ļ�̳��һ���ֵؿ���ֲ�˻�����һ����ȴû�С����ǣ����ܲ�����ֲ�����ڵĵؿ��ϣ����ǻ�����ˮԴ�����߶�����ȥ��
	����һ����̳����ʾΪһ���������0��1������0��ʾû��ֲ����1��ʾ��ֲ�˻�������һ���� n ���ܷ��ڲ�������ֲ�������������� n �仨�����򷵻�True�������򷵻�False��
	
	ʾ�� 1:	
		����: flowerbed = [1,0,0,0,1], n = 1
		���: True
		
	ʾ�� 2:	
		����: flowerbed = [1,0,0,0,1], n = 2
		���: False
	
	ע��:	
		���������ֺõĻ�����Υ����ֲ����
		��������鳤�ȷ�ΧΪ [1, 20000]��
		n �ǷǸ��������Ҳ��ᳬ����������Ĵ�С��
*/
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // ��ȡ��̳�Ĵ�С
		int length = flowerbed.length;
		// ����ջ���ĸ���
		int count = 0;

		int sum = 0;

		// �����ж�
        
		for (int i = 0; i < length; i++) {
			
			// ͳ��0�ĸ���
			if (flowerbed[i] == 1) {
			    //count--;
				sum +=count / 2 ;
				i++;
				count=0;
			} else {
				count++;
			}
		}
		sum += (count+1)/2;
		if(sum>=n) {
			return true;
		}
		return false;
	}
}
