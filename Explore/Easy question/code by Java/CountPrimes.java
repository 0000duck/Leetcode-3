package Leetcode_204_CountPrimes;

/*
	ͳ������С�ڷǸ����� n ��������������
	
	ʾ��:	
		����: 10
		���: 4
		����: С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
 */
public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountPrimes().countPrimes(499979));
	}

	// 204. ��������
	public int countPrimes(int n) {
		// ��������ɸ��
		if (n <= 2) {
			return 0;
		}

		//
		int count = 0;
		boolean[] bool = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (bool[i] == false) {
				count++;
				for (int j = 2; j * i < n; j++) {
					bool[j * i] = true;
					// ��ʱ
//					if (j % i == 0) {
//						if (bool[j] == false) {
//							bool[j] = true;
//						}
//					}
				}
			}
		}

		return count;
	}

}
