package Leetcode_215_KthLargestElementinanArray;

import UsualMethod.ArrayUtil;

/*
	��δ������������ҵ��� k ������Ԫ�ء�
	��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
	
	ʾ�� 1:	
		����: [3,2,1,5,6,4] �� k = 2
		���: 5
	
	ʾ�� 2:	
		����: [3,2,3,1,2,4,5,5,6] �� k = 4
		���: 4
	
	˵��:	
		����Լ��� k ������Ч�ģ��� 1 �� k �� ����ĳ��ȡ�
 */
public class KthLargestElementinanArray {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		KthLargestElementinanArray klea = new KthLargestElementinanArray();
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		System.out.println(klea.findKthLargest(nums, k));
	}
	
	//215. �����еĵ�K�����Ԫ��
    public int findKthLargest(int[] nums, int k) {
        Quick3way(nums,0,nums.length-1,k);
        return nums[nums.length-k];
    }
    
    //��·����
    public void Quick3way(int[] nums,int left,int right,int k) {
    	
    	if(right<=left) {
    		return;
    	}
    	
    	int val = nums[left];//��׼    	
    	int l = left;//����С������߷ţ�l++,i++    	
    	int i = left+1;//��ǰ�Ƚ�λ��
    	int r = right;//����������ұ߷ţ�right--
    	//
    	while(i<=r) {
    		if(nums[i]<val) {
    			//����
    			ArrayUtil.exchange(nums,i,l);
    			//exchange(nums,i,l);
    			i++;
    			l++;
    		}else if(nums[i]>val) {
    			ArrayUtil.exchange(nums,i,r);
    			//exchange(nums,i,r);
    			r--;
    		}else {
    			i++;
    		}   		
    				
    	}
    	//��ʱ�������Ϊ����
		//left - l-1 \ l - r \ r+1 - right
		//�ж�k�ڵ�λ��
		//��1��
		if(k>right-l+1) {
			Quick3way(nums,left,l-1,k-(right-l+1));
		}else if(k>=right-r+1) {
			return ;
		}else {
			Quick3way(nums,r+1,right,k);
		}    
    	
    	
    }
    

}
