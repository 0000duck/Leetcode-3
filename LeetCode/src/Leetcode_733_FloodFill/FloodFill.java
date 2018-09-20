package Leetcode_733_FloodFill;

import UsualMethod.matrixOutput;

/*
	��һ���Զ�ά���������ʾ��ͼ����ÿһ��������ʾ��ͼ��������ֵ��С����ֵ�� 0 �� 65535 ֮�䡣
	����һ������ (sr, sc) ��ʾͼ����Ⱦ��ʼ������ֵ���� ���У���һ���µ���ɫֵ newColor������������ɫ���ͼ��
	Ϊ�������ɫ�������ӳ�ʼ���꿪ʼ����¼��ʼ��������������ĸ�����������ֵ���ʼ������ͬ���������ص㣬
	�����ټ�¼���ĸ������Ϸ������������ص������Ƕ�Ӧ�ĸ�����������ֵ���ʼ������ͬ���������ص㣬�������ظ��ù��̡�
	�������м�¼�����ص����ɫֵ��Ϊ�µ���ɫֵ��
	
	��󷵻ؾ�����ɫ��Ⱦ���ͼ��
	
	ʾ�� 1:	
		����: 
			image = [[1,1,1],[1,1,0],[1,0,1]]
			sr = 1, sc = 1, newColor = 2
		���: [[2,2,2],[2,2,0],[2,0,1]]
		����: 
			��ͼ������м䣬(����(sr,sc)=(1,1)),
			��·�������з������������ص����ɫ�������ĳ�2��
			ע�⣬���½ǵ�����û�и���Ϊ2��
			��Ϊ�����������������ĸ����������ʼ�����������ص㡣
	ע��:	
		image �� image[0] �ĳ����ڷ�Χ [1, 50] �ڡ�
		�����ĳ�ʼ�㽫���� 0 <= sr < image.length �� 0 <= sc < image[0].length��
		image[i][j] �� newColor ��ʾ����ɫֵ�ڷ�Χ [0, 65535]�ڡ�
*/
public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FloodFill ff = new FloodFill();
		int[][] image = { {0,0,0},{0,0,0} };
		int sr = 0;
		int sc = 0;
		int newColor = 2;
		ff.floodFill(image, sr, sc, newColor);
		
	}

	// 733. ͼ����Ⱦ
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {	
		//sr,scԭ������ɫ
		int old = image[sr][sc];
		
		if(image[sr][sc]==newColor) {
			return image;
		}
		// ������Ⱦ��sr��sc��		
		image[sr][sc] = newColor;
		
		
		// �ж���
		if ((sr > 0) && (image[sr - 1][sc] == old)) {
			floodFill(image, sr - 1, sc, newColor);
		}
		// �ж���
		if ((sr < image.length - 1) && (image[sr + 1][sc] == old)) {
			floodFill(image, sr + 1, sc, newColor);
		}
		// �ж���
		if ((sc > 0) && (image[sr][sc - 1] == old)) {
			floodFill(image, sr , sc- 1, newColor);
		}
		// �ж���
		if ((sc < image[0].length - 1) && (image[sr][sc + 1] == old)) {
			floodFill(image, sr , sc+ 1, newColor);
		}
		// �����ά����
		matrixOutput mo = new matrixOutput();
		mo.ArrayOutput(image);
		return image;
	}

}
