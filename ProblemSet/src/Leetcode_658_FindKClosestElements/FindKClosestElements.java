package Leetcode_658_FindKClosestElements;

import java.util.Arrays;

/*
	����һ������õ����飬�������� k �� x�����������ҵ���� x������֮����С���� k ������
	���صĽ������Ҫ�ǰ������źõġ�������������� x �Ĳ�ֵһ��������ѡ����ֵ��С���Ǹ�����
	
	ʾ�� 1:	
		����: [1,2,3,4,5], k=4, x=3
		���: [1,2,3,4]	 
	
	ʾ�� 2:	
		����: [1,2,3,4,5], k=4, x=-1
		���: [1,2,3,4]	 
	
	˵��:	
		k ��ֵΪ������������С�ڸ�����������ĳ��ȡ�
		���鲻Ϊ�գ��ҳ��Ȳ����� 10^4
		�������ÿ��Ԫ���� x �ľ���ֵ������ 10^4
*/
public class FindKClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKClosestElements fce = new FindKClosestElements();
		int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 5;
		System.out.println(Arrays.toString(fce.findClosestElements(arr, k, x)));
	}

	// 658. �ҵ� K ����ӽ���Ԫ��
	public int[] findClosestElements(int[] arr, int k, int x) {
		int[] result = new int[k];
		int count = 0;
		int left = 0;
		int right = arr.length - 1;	
		int mid = 0;
		
		while (left +1 < right) {
			mid = left + (right - left) / 2;
			//x��mid�ұ�
			if(arr[mid]<x) {
				left = mid;
			}else if(arr[mid]>x) {
				right = mid;
			}else {
				result[count++] = arr[mid];
				break;
			}
		}
		
		
		//�ҵ���x
		if(arr[mid]==x) {
			left=mid-1;
			right = mid+1;
			while(count<k) {
				int temp1 = Math.abs(arr[left]-x);
				int temp2 = Math.abs(arr[right]-x);
				if(temp1>temp2) {
					result[count++] = arr[right++];
				}else {
					result[count++] = arr[left--];
				}
				
			}
			Arrays.sort(result);
			return result;
		}
		//û�ҵ�x,����left x right
		while(count<k) {
			if(left==0) {
				for(int i = 0;i<k;i++) {
					result[i] = arr[i];
				}
				return result;
			}
			if(right ==arr.length-1) {
				for(int i = k-1;i>-1;i--) {
					result[i] = arr[i];
				}
				return result;
			}
			int temp1 = Math.abs(arr[left]-x);
			int temp2 = Math.abs(arr[right]-x);
			if(temp1>temp2) {
				result[count++] = arr[right++];
			}else {
				result[count++] = arr[left--];
			}
			
		}
		Arrays.sort(result);
		return result;
	}

}
