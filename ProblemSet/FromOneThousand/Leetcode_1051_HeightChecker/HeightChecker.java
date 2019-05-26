package Leetcode_1051_HeightChecker;

import java.util.Arrays;

/*
	
	ѧУ������ȼ�����ʱ��һ��Ҫ��ѧ������ �ǵݼ� �ĸ߶�˳�����С�	
	���㷵�������ж��ٸ�ѧ��û��վ����ȷλ��������������ָ���ǣ���������ѧ���� �ǵݼ� �߶����еı�Ҫ�ƶ�������	 
	
	ʾ����	
		���룺[1,1,4,2,1,3]
		�����3
		���ͣ�
		�߶�Ϊ 4��3 �����һ�� 1 ��ѧ����û��վ����ȷ��λ�á�	 
	
	��ʾ��	
		1 <= heights.length <= 100
		1 <= heights[i] <= 100

 */

//1051. �߶ȼ����
public class HeightChecker {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	public int heightChecker(int[] heights) {
		if (heights.length == 1) {
			return 0;
		}
		int[] h = Arrays.copyOf(heights, heights.length);
		Arrays.sort(heights);
		int result = 0;
		for (int i = 0; i < heights.length; i++) {
			if (h[i] != heights[i]) {
				result++;
			}
		}
		return result;
	}
}
