package Leetcode_075_SortColors;
/*
	����һ��������ɫ����ɫ����ɫ��һ�� n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
	
	�����У�����ʹ������ 0�� 1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
	
	ע��:
		����ʹ�ô�����е����������������⡣
	
	ʾ��:	
		����: [2,0,2,1,1,0]
		���: [0,0,1,1,2,2]
	���ף�	
		һ��ֱ�۵Ľ��������ʹ�ü������������ɨ���㷨��
		���ȣ����������0��1 �� 2 Ԫ�صĸ�����Ȼ����0��1��2��������д��ǰ���顣
		�������һ����ʹ�ó����ռ��һ��ɨ���㷨��
 */
public class SortColors {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SortColors sc = new SortColors();
		int[] nums = {2,0,2,1,1,0};
		sc.sortColors(nums);
	}
	
	//75. ��ɫ����
	
	//�����ռ�
	public void sortColors(int[] nums) {
		int index = 0;//��ǰλ��
		int color = 0;//��ǰ��ɫ
		while(index<nums.length) {
			if(nums[index]==color) {
				index++;
			}else {
				for(int i = index+1;i<nums.length;i++) {
					if(nums[i]==color) {
						int temp = nums[index];
						nums[index++] = color;
						nums[i] = temp;
					}
				}
				color++;
			}
		}
		
	}
	
	
	
	//��ʾ����
    public void sortColors2(int[] nums) {
    	int[] color = new int[3];
    	for(int i = 0;i<nums.length;i++) {
    		if(nums[i]==0) {
    			color[0]++;
    		}else if(nums[i]==1){
    			color[1]++;
    		}else {
    			color[2]++;
    		}
    	}
    	
    	int j=0;
    	for(int i = 0;i<color.length;i++) {
    		int count = 0;    		
    		while(count<color[i]) {
    			nums[j++] = i; 
    			count++;
    		}
    	}
    		
    }
        
    

}
