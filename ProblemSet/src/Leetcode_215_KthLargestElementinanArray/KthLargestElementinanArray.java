package Leetcode_215_KthLargestElementinanArray;

import java.util.PriorityQueue;

/*
	��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
	
	ʾ�� 1:	
		����: [3,2,1,5,6,4] �� k = 2
		���: 5
	
	ʾ�� 2:	
		����: [3,2,3,1,2,4,5,5,6] �� k = 4
		���: 4
	
	˵��:	
		����Լ��� k ������Ч�ģ��� 1 �� k �� ����ĳ��ȡ�
 */

/*
	˼·��
		�����ҵ���k��
	�Ľ���
		ֻ�ŵ���K��
		����> ����
 */
public class KthLargestElementinanArray {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		KthLargestElementinanArray klea = new KthLargestElementinanArray();
		System.out.println(klea.findKthLargest(nums, k));

	}
	//215. �����еĵ�K�����Ԫ��
	
	
	//��·����:��ʱ
    public int findKthLargest(int[] nums, int k) {
    	//
    	Quick3way(nums,0,nums.length-1);
    	//���ص�K���Ԫ��
    	return nums[nums.length-k];
    }
    
    //��·����
    public void Quick3way(int[] nums,int lo,int hi) {
    	//�ݹ����
    	if(hi<=lo) {
    		return ;
    	}
    	
    	int lt = lo;
    	int i = lo+1;//a[i]<vʱ��lt++��i++
    	int gt = hi;//a[i]>vʱ��gt--
    	int v = nums[lo];//��׼
    	while(i<=gt) {
    		if(nums[i]<v) {
    			int temp = nums[i];
    			nums[i++] = nums[lt];
    			nums[lt++] = temp;
    		}else if(nums[i]>v) {
    			int temp = nums[i];
    			nums[i] = nums[gt];
    			nums[gt--] = temp;
    		}else {
    			i++;
    		}
    		Quick3way(nums,lo,lt-1);
    		Quick3way(nums,gt+1,hi);
    	}
    }

}
