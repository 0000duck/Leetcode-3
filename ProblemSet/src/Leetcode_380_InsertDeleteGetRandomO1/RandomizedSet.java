package Leetcode_380_InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
	���һ��֧����ƽ�� ʱ�临�Ӷ� O(1) �£�ִ�����²��������ݽṹ��
	
	insert(val)����Ԫ�� val ������ʱ���򼯺��в�����
	remove(val)��Ԫ�� val ����ʱ���Ӽ������Ƴ����
	getRandom������������м����е�һ�ÿ��Ԫ��Ӧ������ͬ�ĸ��ʱ����ء�
	
	ʾ�� :	
		// ��ʼ��һ���յļ��ϡ�
		RandomizedSet randomSet = new RandomizedSet();
		
		// �򼯺��в��� 1 ������ true ��ʾ 1 ���ɹ��ز��롣
		randomSet.insert(1);
		
		// ���� false ����ʾ�����в����� 2 ��
		randomSet.remove(2);
		
		// �򼯺��в��� 2 ������ true ���������ڰ��� [1,2] ��
		randomSet.insert(2);
		
		// getRandom Ӧ������� 1 �� 2 ��
		randomSet.getRandom();
		
		// �Ӽ������Ƴ� 1 ������ true ���������ڰ��� [2] ��
		randomSet.remove(1);
		
		// 2 ���ڼ����У����Է��� false ��
		randomSet.insert(2);
		
		// ���� 2 �Ǽ�����Ψһ�����֣�getRandom ���Ƿ��� 2 ��
		randomSet.getRandom();
 */

//380. ����ʱ����롢ɾ���ͻ�ȡ���Ԫ��
public class RandomizedSet {
	public static void main(String[] args) {
		// ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
		// [[],[1],[2],[2],[],[1],[2],[]]
		// [null,true,false,true,2,true,false,2]
		RandomizedSet rs = new RandomizedSet();
		rs.insert(-1);
		rs.remove(-2);
		rs.insert(-2);
		rs.getRandom();
		rs.remove(-1);
		rs.insert(-2);
	}

	private Set<Integer> set;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		set = new HashSet<Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (!set.contains(val)) {
			return set.add(val);
		} else {
			return false;
		}

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (set.contains(val)) {
			return set.remove(val);
		} else {
			return false;
		}

	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random r = new Random();
		int i = 0;
		int rand = r.nextInt(set.size());
		for (Integer x : set) {
			if (i == rand) {
				return x;
			}
			i++;
		}
		return -1;
	}
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */