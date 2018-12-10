package Leetcode_575_DistributeCandies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
	����һ��ż�����ȵ����飬���в�ͬ�����ִ����Ų�ͬ������ǹ���ÿһ�����ִ���һ���ǹ���
	����Ҫ����Щ�ǹ�ƽ���ָ�һ���ܵܺ�һ�����á�
	�������ÿ��Ի�õ�����ǹ�����������
	
	ʾ�� 1:	
		����: candies = [1,1,2,2,3,3]
		���: 3
	����: 
		һ��������������ǹ���ÿһ�ֶ���������
		���ŷ��䷽�������û��[1,2,3],�ܵ�Ҳ���[1,2,3]������ʹ���û���ǹ�����������ࡣ
	
	ʾ�� 2 :	
		����: candies = [1,1,2,3]
		���: 2
	����: 
		���û���ǹ�[2,3],�ܻܵ���ǹ�[1,1]�����������ֲ�ͬ���ǹ����ܵ�ֻ��һ�֡�����ʹ�����ÿ��Ի�õ��ǹ���������ࡣ
	
	ע��:	
		����ĳ���Ϊ[2, 10,000]������ȷ��Ϊż����
		���������ֵĴ�С�ڷ�Χ[-100,000, 100,000]�ڡ�
 */
public class DistributeCandies {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	// 575. ���ǹ�
	public int distributeCandies(int[] candies) {
		Set<Integer> set = new HashSet<Integer>();
		for (int cand : candies) {
			set.add(cand);
			if (set.size() >= candies.length / 2) {
				return candies.length / 2;
			}
		}
		return set.size();

	}

	// 19ms
	public int distributeCandies0(int[] candies) {
		boolean[] b = new boolean[200001];
		int num = 0;
		for (int i : candies) {
			if (b[i + 100000] == false) {
				b[i + 100000] = true;
				num++;
			}
		}
		return Math.min(candies.length >> 1, num);

	}

}
