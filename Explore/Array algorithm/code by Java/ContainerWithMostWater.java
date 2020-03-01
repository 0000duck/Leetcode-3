package Leetcode_011_ContainerWithMostater;

/*
	���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
	�������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
	�ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
	
	˵�����㲻����б�������� n ��ֵ����Ϊ 2��
	
	ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]��
	�ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ 49��
	
	 
	
	ʾ��:
		����: [1,8,6,2,5,4,8,3,7]
		���: 49
*/
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	// 11. ʢ���ˮ������
	public int maxArea(int[] height) {
		// ��ȡ����
		int n = height.length;
		// �������ֵ
		int max = 0;
		// ����
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			}
		}
		return max;
	}

}
