package Leetcode_350_IntersectionofTwoArrays2;

import java.util.Arrays;

/*
	�����������飬��дһ���������������ǵĽ�����
	
	ʾ�� 1:	
		����: nums1 = [1,2,2,1], nums2 = [2,2]
		���: [2,2]
	ʾ�� 2:	
		����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		���: [4,9]
	˵����	
		��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
		���ǿ��Բ�������������˳��
	����:	
		��������������Ѿ��ź����أ��㽫����Ż�����㷨��
		��� nums1 �Ĵ�С�� nums2 С�ܶ࣬���ַ������ţ�
		��� nums2 ��Ԫ�ش洢�ڴ����ϣ������ڴ������޵ģ������㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿
*/
public class IntersectionofTwoArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//350. ��������Ľ��� II
    public int[] intersect(int[] nums1, int[] nums2) {
    	//�����������
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);        
    	//nums2��nums1С
    	//����С����
    	for(int i = 0;i<nums1.length;i++) {
    		//���ֲ���
    		
    	}
    	
    }

}
