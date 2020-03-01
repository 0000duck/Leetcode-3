package Leetcode_026_RemoveDuplicatesfromSortedArray;

/*

	����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
	��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
	
	ʾ�� 1:	
		�������� nums = [1,1,2], 		
		����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��		
		�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
		
	ʾ�� 2:	
		���� nums = [0,0,1,1,1,2,2,3,3,4],		
		����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��		
		�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
*/
public class RemoveDuplicatesfromSortedArray {
	//26.ɾ�����������е��ظ���
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		// ���岻�ظ�Ԫ�ظ���
		int count = 0;
		// ����Ƚ�Ԫ��
		int now = nums[0];
		// ��������
		for (int i = 1; i < nums.length; i++) {
			// �ж��Ƿ���now��ͬ
			if (now != nums[i]) {
				// ��ͬ��������1�����ڱȽ����ı䣬��Ӧ��λ�û��ɵ�ǰ��ֵ
				count++;
				now = nums[i];
				nums[count] = nums[i];
			}
		}
		count++;
		return count;
	}
}
