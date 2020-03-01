package Leetcode_209_MinimumSizeSubarraySum;
/*
	����һ������ n ���������������һ�������� s ���ҳ���������������� �� s �ĳ�����С�����������顣��������ڷ������������������飬���� 0��
	
	ʾ��: 	
		����: s = 7, nums = [2,3,1,2,4,3]
		���: 2
		����: 
			������ [4,3] �Ǹ������µĳ�����С�����������顣
	����:	
		������Ѿ������O(n) ʱ�临�ӶȵĽⷨ, �볢�� O(n log n) ʱ�临�ӶȵĽⷨ��
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//209. ������С��������
    public int minSubArrayLen(int s, int[] nums) {
        //�����㷨
    	int minlength=Integer.MAX_VALUE;
    	for(int i = 0;i<nums.length;i++) {
    		int sum = 0;
    		int count = 0;
    		for(int j = i;j<nums.length;j++) {    			
    			if(sum<s) {
    				sum += nums[j];
    				count++;
    			}
    			if(sum >= s) {
    				minlength = Math.min(minlength, count);
    				continue;
    			}
    			
    		}    		
    	}
    	if(minlength==Integer.MAX_VALUE) {
    		return 0;
    	}
    	return minlength;
    }

}
