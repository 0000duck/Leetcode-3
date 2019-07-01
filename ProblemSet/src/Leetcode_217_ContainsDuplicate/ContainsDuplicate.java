package Leetcode_217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

//import java.lang.reflect.Array;
//import java.util.HashSet;
//import java.util.Set;

/*

	����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�	
	����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��
	
	ʾ�� 1:	
		����: [1,2,3,1]
		���: true
		
	ʾ�� 2:	
		����: [1,2,3,4]
		���: false
		
	ʾ�� 3:	
		����: [1,1,1,3,3,4,3,2,4,2]
		���: true	
*/
public class ContainsDuplicate {
	// 217. �����ظ�Ԫ��
	public boolean containsDuplicate(int[] nums) {
		if (nums != null && nums.length > 1) {
			Set<Integer> set = new HashSet<Integer>(nums.length);
			for (int i : nums) {
				if (set.contains(i)) {
					return true;
				} else {
					set.add(i);
				}
			}
		}
		return false;
	}

	// �����ⷨ
	public boolean containsDuplicate2(int[] nums) {
		// ����Ϊ0��1�϶���false
		if (nums.length == 0 || nums.length == 1) {
			return false;
		}
		// ���β���ǰ�����
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

}
