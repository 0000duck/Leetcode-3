package Leetcode_658_FindKClosestElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

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
		int[] arr = { 1,2,3,4,5 };
		int k = 4;
		int x = -1;
		//System.out.println(Arrays.toString(fce.findClosestElements(arr, k, x)));
		List<Integer> list = fce.findClosestElements(arr,k,x);
		for(int i = 0;i<list.size();i++) {
			System.out.print(list.get(i)+",");
		}
	}

	// 658. �ҵ� K ����ӽ���Ԫ��
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		if(k==arr.length) {
			return arrToList(arr);
		}
		if(x<=arr[0]) {
			List<Integer> result = new ArrayList();
			for(int i = 0;i<k;i++) {
				result.add(arr[i]);
			}
			return result;
		}
		if(x>=arr[arr.length-1]) {
			List<Integer> result = new ArrayList();
			for(int i = arr.length-k;i<arr.length;i++) {
				result.add(arr[i]);
			}
			return result;
		}
		int left = 0;
		int right = arr.length-1;
		//�ҵ�x�ķ�Χ
		while(left+1<right) {
			int mid = left+(right-left)/2;
			if(arr[mid]>x) {
				right=mid;
			}else if(arr[mid]<x) {
				left = mid;
			}else {
				left=mid;
				right =mid;
				break;
			}
		}
		//�ӷ�Χ��ʼ�ҵ�k����
		int[] result = new int[k];
		int count = 0;
		while(count<k) {
			int temp = Math.abs(arr[left]-x);
			int temp2 = Math.abs(arr[right]-x);
			if(temp<=temp2) {
				result[count++] = arr[left--];
			}else {
				result[count++] = arr[right++];
			}
		}
		Arrays.sort(result);
		return arrToList(result);
		
	}
	
	//arr to list
	public List<Integer> arrToList(int[] arr) {
		List<Integer> result = new ArrayList();
		for(int i = 0;i<arr.length;i++) {
			result.add(arr[i]);
		}
		return result;
	}

}
