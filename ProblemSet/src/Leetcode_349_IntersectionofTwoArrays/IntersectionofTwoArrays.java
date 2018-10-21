package Leetcode_349_IntersectionofTwoArrays;



//import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import UsualMethod.matrixOutput;



/*
	�����������飬��дһ���������������ǵĽ�����
	
	ʾ�� 1:	
		����: nums1 = [1,2,2,1], nums2 = [2,2]
		���: [2]
	ʾ�� 2:	
		����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		���: [9,4]
	˵��:	
		�������е�ÿ��Ԫ��һ����Ψһ�ġ�
		���ǿ��Բ�������������˳��
*/
public class IntersectionofTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		IntersectionofTwoArrays it = new IntersectionofTwoArrays();		
		//Arrays.toString( it.intersection(nums1, nums2));
		matrixOutput  mo = new matrixOutput();
		mo.ArrayOutput( it.intersection(nums1, nums2));
	}
	//349. ��������Ľ���
	//���ϵĴ���ʽ������set��map
	//set
    public int[] intersection(int[] nums1, int[] nums2) {
        //����set
    	Set<Integer> nums = new HashSet<Integer>();
    	Set<Integer> result = new HashSet<>();
    	//������nums2���뼯��nums
    	for(int i =0;i<nums2.length;i++) {
    		nums.add(nums2[i]);
    	}
    	//����nums1,�ҵ�����,���뼯��result
    	for(int i = 0;i<nums1.length;i++) {
    		if(nums.contains(nums1[i])) {
    			result.add(nums1[i]);
    		}
    	}
    	//������ת��Ϊ���飬ʹ�õ�����
    	int[] res= new int[result.size()];
    	//������
    	Iterator iter = result.iterator();
    	int i = 0;
    	while(iter.hasNext()) {
    		res[i++]=(int)iter.next();
    	}
    	return res;
    }
}
