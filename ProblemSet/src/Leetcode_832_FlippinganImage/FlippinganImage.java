package Leetcode_832_FlippinganImage;

/*
	����һ�������ƾ��� A����������ˮƽ��תͼ��Ȼ��תͼ�񲢷��ؽ����	
	ˮƽ��תͼƬ���ǽ�ͼƬ��ÿһ�ж����з�ת��������
	���磬ˮƽ��ת [1, 1, 0] �Ľ���� [0, 1, 1]��	
	��תͼƬ����˼��ͼƬ�е� 0 ȫ���� 1 �滻�� 1 ȫ���� 0 �滻��
	���磬��ת [0, 1, 1] �Ľ���� [1, 0, 0]��
	
	ʾ�� 1:	
		����: [
				[1,1,0],
				[1,0,1],
				[0,0,0]]
		���: [
				[1,0,0],
				[0,1,0],
				[1,1,1]]
		����: 
			���ȷ�תÿһ��: [
							[0,1,1],
							[1,0,1],
							[0,0,0]]��
			Ȼ��תͼƬ: [
							[1,0,0],
							[0,1,0],
							[1,1,1]]
	
	ʾ�� 2:	
		����: [  
				[1,1,0,0],
				[1,0,0,1],
				[0,1,1,1],
				[1,0,1,0]]
		���: [
				[1,1,0,0],
				[0,1,1,0],
				[0,0,0,1],
				[1,0,1,0]]
		����: ���ȷ�תÿһ��: [[0,0,1,1],
						   [1,0,0,1],
						   [1,1,1,0],
						   [0,1,0,1]]��
		     Ȼ��תͼƬ: [	[1,1,0,0],
		     			[0,1,1,0],
		     			[0,0,0,1],
		     			[1,0,1,0]]
	
	˵��:	
		1 <= A.length = A[0].length <= 20
		0 <= A[i][j] <= 1
 */
public class FlippinganImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 832. ��תͼ��
	public int[][] flipAndInvertImage(int[][] A) {
		int[][] result = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					result[i][A.length - 1 - j] = A[i][j] - 1;
				} else {
					result[i][A.length - 1 - j] = A[i][j] + 1;
				}
			}
		}
		return result;
	}

	// 4ms
	public int[][] flipAndInvertImage2(int[][] A) {
		if (A.length <= 0) {
			return A;
		}
		for (int[] ints : A) {
			int l = ints.length - 1;
			int temp;
			for (int i = 0; i <= l / 2; i++) {
				temp = ints[i];
				ints[i] = ints[l - i] ^ 1;
				ints[l - i] = temp ^ 1;
			}
		}
		return A;
	}

}
