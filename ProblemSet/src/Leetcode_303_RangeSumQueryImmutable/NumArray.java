package Leetcode_303_RangeSumQueryImmutable;



/*
	����һ����������  nums�������������� i �� j  (i �� j) ��Χ��Ԫ�ص��ܺͣ����� i,  j ���㡣
	
	ʾ����
		���� nums = [-2, 0, 3, -5, 2, -1]����ͺ���Ϊ sumRange()		
		sumRange(0, 2) -> 1
		sumRange(2, 5) -> -1
		sumRange(0, 5) -> -3
	˵��:
		����Լ������鲻�ɱ䡣
		���ε��� sumRange ������
*/
public class NumArray {
	/**
	 * Your NumArray object will be instantiated and called as such:
	 *  NumArray obj =new NumArray(nums); 
	 *  int param_1 = obj.sumRange(i,j);
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//["NumArray","sumRange","sumRange","sumRange"]:["NumArray"]		
		//[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]:[[[]]]
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray obj = new NumArray(nums);
		int param_1 = obj.sumRange(0, 2);
		int param_2 = obj.sumRange(2, 5);
		int param_3 = obj.sumRange(0, 5);
		System.out.println("1:" + param_1);
		System.out.println("-1:" + param_2);
		System.out.println("-3:" + param_3);
	}

	// 303. ����ͼ��� - ���鲻�ɱ�
	// �����Ա����
	private int[] arr;

	// ���췽��
	public NumArray(int[] nums) {
		if((nums==null)||(nums.length==0)) {
			arr = null;
			return;
		}
		arr = new int[nums.length];
		arr[0]=nums[0];
		for(int i=1;i<nums.length;i++ ) {
			arr[i]=arr[i-1]+nums[i];
		}
		
	}

	public int sumRange(int i, int j) {
		if(arr==null) {
			return 0;
		}
		if(i==0) {
			return arr[j];
		}else {
			return arr[j]-arr[i-1];
		}
		
		
	}

}
