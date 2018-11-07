package Leetcode_475_Heaters;

import java.util.Arrays;

/*
	�����Ѿ����١� ������������һ���й̶����Ȱ뾶�Ĺ�ů�������з��ݹ�ů��	
	���ڣ�����λ��һ��ˮƽ���ϵķ��ݺ͹�ů����λ�ã��ҵ����Ը������з��ݵ���С���Ȱ뾶��	
	���ԣ�������뽫���Ƿ��ݺ͹�ů����λ�á��㽫�����ů������С���Ȱ뾶��
	
	˵��:	
		�����ķ��ݺ͹�ů������Ŀ�ǷǸ����Ҳ��ᳬ�� 25000��
		�����ķ��ݺ͹�ů����λ�þ��ǷǸ����Ҳ��ᳬ��10^9��
		ֻҪ����λ�ڹ�ů���İ뾶��(�����ڱ�Ե��)�����Ϳ��Եõ���ů��
		���й�ů������ѭ��İ뾶��׼�����ȵİ뾶Ҳһ����
	ʾ�� 1:	
		����: [1,2,3],[2]
		���: 1
		����: ����λ��2����һ����ů����������ǽ����Ȱ뾶��Ϊ1����ô���з��ݾͶ��ܵõ���ů��
		
	ʾ�� 2:	
		����: [1,2,3,4],[1,4]
		���: 1
		����: ��λ��1, 4����������ů����������Ҫ�����Ȱ뾶��Ϊ1���������з��ݾͶ��ܵõ���ů��
*/
public class Heaters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses = { 1, 2, 3, 15 };

		int[] heaters = { 2, 15 };
		Heaters h = new Heaters();
		System.out.println(h.findRadius(houses, heaters));
	}

	// 475. ��ů��
	public int findRadius(int[] houses, int[] heaters) {
		// �Է�������
		Arrays.sort(houses);
		// �Լ���������
		Arrays.sort(heaters);
		// ���ӵĸ���
		int n = houses.length;
		// �������ĸ���
		int m = heaters.length;
		// �������
		int minimum = 0;
		// j������
		int j = 0;
		// ��������
		for (int i = 0; i < n; i++) {
			// Math.abs(heaters[j] - houses[i]);j����ǰ���ӵľ���
			// right = Math.abs(heaters[j+1] - houses[i]);j+1����ǰ���ӵľ���
			// j>=j+1,���������ƣ�ֱ��j<j+1,j���뵱ǰi������ļ�����
			while (j < m - 1 && ((Math.abs(heaters[j] - houses[i])) >= (Math.abs(heaters[j + 1] - houses[i])))) {
				j++;
			}
			// �жϵ�ǰ�ķ������ĸ������������������ߵļ������ȽϽ���������С�뾶Ϊ ��ǰ�� �� ����еĽϴ��
			// ������ұ߼������ȽϽ���������һ��������
			// ��[1,2,3,4],[1,4] 1��2��1����3��4��4��������������1
			minimum = Math.max(minimum, Math.abs(heaters[j] - houses[i]));
		}
		return minimum;

	}

}
