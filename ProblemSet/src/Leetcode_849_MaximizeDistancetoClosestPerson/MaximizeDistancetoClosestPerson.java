package Leetcode_849_MaximizeDistancetoClosestPerson;

/*
	��һ����λ�� seats���У�1 ��������������λ�ϣ�0 ������λ���ǿյġ�	
	������һ������λ����������һ��������λ�ϡ�	
	������˹ϣ������һ���ܹ�ʹ���������������֮��ľ���ﵽ��󻯵���λ�ϡ�	
	������������������˵������롣
	
	ʾ�� 1��	
		���룺[1,0,0,0,1,0,1]
		�����2
	���ͣ�
		���������˹���ڵڶ�����λ��seats[2]���ϣ���������������˵ľ���Ϊ 2 ��
		���������˹���������κ�һ����λ�ϣ���������������˵ľ���Ϊ 1 ��
		��ˣ���������������˵��������� 2 �� 
		
	ʾ�� 2��	
		���룺[1,0,0,0]
		�����3
	���ͣ� 
		���������˹�������һ����λ�ϣ�������������� 3 ����λԶ��
		���ǿ��ܵ������룬���Դ��� 3 ��
		
	��ʾ��	
		1 <= seats.length <= 20000
		seats ��ֻ���� 0 �� 1��������һ�� 0����������һ�� 1��
 */
public class MaximizeDistancetoClosestPerson {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	// 849. ��������˵�������
	public int maxDistToClosest(int[] seats) {
		int maxDistance = 0;
		int zerocount = 0;
		if (seats[0] == 0) {
			for (int i = 0; i < seats.length; i++) {
				if (seats[i] == 0) {
					zerocount++;
				} else {
					maxDistance = Math.max(maxDistance, zerocount);
					break;
				}
			}
		}
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 0) {
				zerocount++;
			} else {
				maxDistance = Math.max(maxDistance, (zerocount + 1) / 2);
				zerocount = 0;
			}
		}
		if (seats[seats.length - 1] == 0) {
			zerocount = 0;
			for (int i = seats.length - 1; i >= 0; i--) {
				if (seats[i] == 0) {
					zerocount++;
				} else {
					maxDistance = Math.max(maxDistance, zerocount);
					break;
				}
			}
		}
		return maxDistance;
	}

}
