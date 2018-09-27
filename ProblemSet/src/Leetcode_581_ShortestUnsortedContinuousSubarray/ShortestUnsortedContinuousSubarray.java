package Leetcode_581_ShortestUnsortedContinuousSubarray;

/*
	����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������
	���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�
	
	ʾ�� 1:	
		����: [2, 6, 4, 8, 10, 9, 15]
		���: 5
		����: ��ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
		
	˵�� :	
		��������鳤�ȷ�Χ�� [1, 10,000]��
		�����������ܰ����ظ�Ԫ�� �������������˼��<=��
*/
public class ShortestUnsortedContinuousSubarray {
	
	public int findUnsortedSubarray(int[] nums) {
		// ��ȡ����ĳ���
		int length = nums.length;
		if(length<=1) {
			return 0;
		}
		// ������Ҫ����ʼ������
		int beginindex = 0;
		
		// �������飬�ӿ�ʼ�����������ж��ǲ��ǱȺ���Ķ�С
		begin: for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] > nums[j]) {
					beginindex = i;					
					break begin;
				}
			}
		}
		//System.out.println("beginindex:"+beginindex);		
		// �Ӻ�������������ж��ǲ��Ǳ�ǰ��ģ���Ҫ��ʼ����ʼ������������
		int endindex = 0;
		end: for (int i = length - 1; i >= beginindex; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] < nums[j]) {
					endindex = i;
					break end;
				}
			}
		}
		//System.out.println("endindex:"+endindex);
		if((beginindex==0)&(endindex==0)) {
			return 0;
		}
		return endindex - beginindex + 1;
	}
}
