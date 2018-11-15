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
		RemoveDuplicatesfromSortedArray2 rdfsa2 = new RemoveDuplicatesfromSortedArray2();
		int[] nums = {1,2,2};
		rdfsa2.removeDuplicates(nums);
	}
	//80. ɾ�����������е��ظ��� II
    public int removeDuplicates(int[] nums) {
    	if(nums.length<=2) {
    		return nums.length;
    	}
    	int i = 0;
    	int j = 1;
    	int count = 1;    
    	int length = 0;
    	while(i<nums.length-length-1) {
    		if(nums[j]==nums[j-1]) {
    			count++;    			
    		}else {
    			count = 1;
    		}
    		//�ж��Ƿ����2
    		if(count >2) {
    			move(nums,j);
    			length++;
    		}else {
    			j++;
        		i++;
    		}
    		    		
    	}
    	return nums.length-length;
    	
    }
    //��ǰ�ƶ�
    public void move(int[] nums, int i) {
    	for(int j = i+1;j<nums.length;j++) {
    		nums[j-1] = nums[j];
    	}    	
    }

}
