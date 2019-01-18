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
		// Ԫ�ظ�������1�Ž�������Ĳ���
		if (nums != null && nums.length > 1) {
			// ����һ��hashSet
			// ��Ҫ����set��HashSet
			Set<Integer> set = new HashSet<Integer>(nums.length);
			// ��ǿfor
			for (int i : nums) {
				// ���Ԫ���Ѿ����ھͷ���true
				if (set.contains(i)) {
					return true;
				}
				// û�о���ӵ�Ԫ�ؼ�����
				else {
					set.add(i);
				}
			}
		}
		return false;
	}

	// ������
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

//	
//	//��ʱ
//	public boolean containsDuplicate3(int[] nums){		 	
//		//����Ƚ�ǰ������ֵ
//		for(int i = 0;i<nums.length-1;i++) {
//			for(int j = i+1;j<nums.length; j++) {
//				if(nums[i]>nums[j]) {
//					int temp= nums[i];
//					nums[i] = nums[j];
//					nums[j] = temp;
//				}				
//			}			
//			//System.out.println(nums[i]);
//		}
//		for(int i = 0;i<nums.length-1;i++) {
//			if(nums[i]==nums[i+11]) {
//				return true;
//			}
//		}
//		return false;
//	}

//	
//	//��ʱ
//	
//	public boolean containsDuplicate4(int[] nums) {
//		// ��������
//		for (int i = 0; i < nums.length - 1; i++) {
//			int count = 1;
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[i] == nums[j]) {
//					count++;
//					if (count > 1) {
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//
//	}

}
