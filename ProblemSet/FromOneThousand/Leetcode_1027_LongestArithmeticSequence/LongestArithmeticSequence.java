package Leetcode_1027_LongestArithmeticSequence;

import java.util.HashMap;
import java.util.HashSet;

/*
	����һ���������� A������ A ����Ȳ������еĳ��ȡ�	
	����һ�£�A �����������б� A[i_1], A[i_2], ..., A[i_k] 
	���� 0 <= i_1 < i_2 < ... < i_k <= A.length - 1��
	������� B[i+1] - B[i]( 0 <= i < B.length - 1) ��ֵ����ͬ����ô���� B �ǵȲ�ġ�	 
	
	ʾ�� 1��	
		���룺[3,6,9,12]
		�����4
		���ͣ� 
		���������ǹ���Ϊ 3 �ĵȲ����С�
	ʾ�� 2��	
		���룺[9,4,7,2,10]
		�����3
		���ͣ�
		��ĵȲ��������� [4,7,10]��
	ʾ�� 3��	
		���룺[20,1,15,3,10,5,8]
		�����4
		���ͣ�
		��ĵȲ��������� [20,15,10,5]��
	
	��ʾ��	
		2 <= A.length <= 2000
		0 <= A[i] <= 10000
 */

//1027. ��Ȳ�����
public class LongestArithmeticSequence {
	public int longestArithSeqLength(int[] A) {
		int n = A.length;
		HashSet<Integer> h = new HashSet<>();
		int ans = 2;
		for (int a : A) {
			h.add(a);
		}
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				// �Ȳ�d
				int d = (A[j] - A[i]);
				// �������ֵ���һ����t
				int t = A[j] + d;
				// ��ʼ�ĳ���Ϊ2
				int l = 2;
				// ������t
				if (!h.contains(t))
					continue;
				// ����t
				// ��j+1��λ�ÿ�ʼ��
				for (int k = j + 1; k < n; ++k) {
					if (A[k] == t) {
						t += d;
						++l;
					}
				}
				ans = Math.max(ans, l);

			}
		}
		return ans;
	}

	// 24ms
	public int longestArithSeqLength0(int[] A) {
		int len = A.length;
		HashMap<Integer, Integer> map[] = new HashMap[len];
		for (int i = 0; i < len; i++) {
			map[i] = new HashMap<>();
		}
		int rs = 0;
		// key:d -> value:l
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				int d = A[i] - A[j];
				int temp = map[j].get(d) == null ? 0 : map[j].get(d);
				int l = temp + 1;
				map[i].put(d, l);
				rs = rs > l ? rs : l;
			}
		}
		return rs + 1;
	}
}
