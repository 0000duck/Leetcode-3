package Leetcode_080_RemoveDuplicatesfromSortedArray2;
/*
	����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�
	��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
	
	ʾ�� 1:
		���� nums = [1,1,1,2,2,3],
		����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3 ��
		�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
	
	ʾ�� 2:
		���� nums = [0,0,1,1,1,1,2,3,3],	
		����Ӧ�����³��� length = 7, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 0, 0, 1, 1, 2, 3, 3 ��	
		�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
		
	˵��:
		Ϊʲô������ֵ��������������Ĵ���������?
		��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
	����������ڲ���������:
		// nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
		int len = removeDuplicates(nums);
		
		// �ں������޸�����������ڵ������ǿɼ��ġ�
		// ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
		for (int i = 0; i < len; i++) {
		    print(nums[i]);
		}
 */
public class RemoveDuplicatesfromSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//80. ɾ�����������е��ظ��� II
    public int removeDuplicates(int[] nums) {
    	int i = 0;
    	int j = 1;
    	int count = 1;
    	int temp = nums[0];
    	int length = 0;
    	while(i<nums.length-length) {
    		if(nums[j]==nums[j-1]) {
    			count++;   			
    		}else {
    			count = 1;
    		}
    		if(count >2) {
    			move(nums,j);
    		}
    	}
    	
    }
    //��ǰ�ƶ�
    public int[] move(int[] nums, int i) {
    	
    }

}
