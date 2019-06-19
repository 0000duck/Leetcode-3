package Leetcode_1089_DuplicateZeros;

import java.util.Arrays;

/*
	����һ�����ȹ̶����������� arr�����㽫�������г��ֵ�ÿ���㶼��дһ�飬���������Ԫ������ƽ�ơ�	
	ע�⣺�벻Ҫ�ڳ��������鳤�ȵ�λ��д��Ԫ�ء�	
	Ҫ�������������� �͵� ���������޸ģ���Ҫ�Ӻ��������κζ�����	 
	
	ʾ�� 1��	
		���룺[1,0,2,3,0,4,5,0]
		�����null
		���ͣ����ú�������������齫���޸�Ϊ��[1,0,0,2,3,0,0,4]
	ʾ�� 2��	
		���룺[1,2,3]
		�����null
		���ͣ����ú�������������齫���޸�Ϊ��[1,2,3] 
	
	��ʾ��	
		1 <= arr.length <= 10000
		0 <= arr[i] <= 9
 */

//1089. ��д��
public class DuplicateZeros {
	public static void main(String[] args) {
		new DuplicateZeros().duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
	}
    public void duplicateZeros(int[] arr) {
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        int d = 0;
        for(int i = 0;i<arr.length;i++) {
        	if(i+d<arr.length) {
        		arr[i+d]=arr2[i];
        	}
        	if(arr2[i]==0) {
        		d++;
        		if(i+d<arr.length) {
        			arr[i+d] = 0;        	
        		}      			 		
        	}
        	
        }
    }
}
