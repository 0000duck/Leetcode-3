package Leetcode_665_NondecreasingArray;

/*
	����һ������Ϊ n ���������飬����������ж������ı� 1 ��Ԫ�ص�����£��������ܷ���һ���ǵݼ����С�	
	��������������һ���ǵݼ����еģ� �������������е� i (1 <= i < n)������ array[i] <= array[i + 1]��
	
	ʾ�� 1:	
		����: [4,2,3]
		���: True
		����: �����ͨ���ѵ�һ��4���1��ʹ������Ϊһ���ǵݼ����С�
		
	ʾ�� 2:	
		����: [4,2,1]
		���: False
		����: �㲻����ֻ�ı�һ��Ԫ�ص�����½����Ϊ�ǵݼ����С�
	˵��:  n �ķ�ΧΪ [1, 10,000]��
*/
public class NondecreasingArray {
	public boolean checkPossibility(int[] nums) {
		// ��ȡ���鳤��
		int length = nums.length;
		// ������
		int count = 0;
		// ��������
		/*
		����ͷ���м��ң��ҳ��ϵ��λ��		 
		*/
		int i = 0;
		int j = length-1;
		while((i<j)&&(nums[i]<=nums[i+1])) {
			i++;
		}
		while((i<j)&&nums[j]>=nums[j-1]) {
			j--;
		}
		System.out.println("i:"+i+",j:"+j);
		if(j-i<=1) {
			if((i==0)|| (j==length-1)){
				return true;
			}
			if((nums[i-1]<=nums[j])|(nums[i]<=nums[j+1])){
				return true;
			}
		}
		return false;
	}
}
