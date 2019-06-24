package Leetcode_1095_FindinMountainArray;

/*
	������һ�� ����ʽ���� ��	
	����һ�� ɽ������ mountainArr��
	���㷵���ܹ�ʹ�� mountainArr.get(index) ���� target ��С ���±� index ֵ��	
	����������������±� index�����뷵�� -1��	 
	
	��νɽ�����飬������ A ������һ��ɽ������Ļ�����Ҫ��������������	
	���ȣ�A.length >= 3	
	��Σ��� 0 < i < A.length - 1 �����£����� i ʹ�ã�	
		A[0] < A[1] < ... A[i-1] < A[i]
		A[i] > A[i+1] > ... > A[A.length - 1]	
	�㽫 ����ֱ�ӷ��ʸ�ɽ�����飬����ͨ�� MountainArray �ӿ�����ȡ���ݣ�	
		MountainArray.get(k) - �᷵������������Ϊk ��Ԫ�أ��±�� 0 ��ʼ��
		MountainArray.length() - �᷵�ظ�����ĳ���	 
	
	ע�⣺	
		�� MountainArray.get ���𳬹� 100 �ε��õ��ύ������Ϊ����𰸡�
		���⣬�κ���ͼ�������ϵͳ�Ľ�����������ᵼ�±����ʸ�ȡ����	
		Ϊ�˰�����Ҹ��õ���⽻��ʽ���⣬����׼����һ������ ���𰸡���
		https://leetcode-cn.com/playground/RKhe3ave��
		��ע���� ����һ����ȷ�𰸡�	 
	
	ʾ�� 1��	
		���룺array = [1,2,3,4,5,3,1], target = 3
		�����2
		���ͣ�3 �������г��������Σ��±�ֱ�Ϊ 2 �� 5�����Ƿ�����С���±� 2��
	
	ʾ�� 2��	
		���룺array = [0,1,2,4,2,1], target = 3
		�����-1
		���ͣ�3 ��������û�г��֣����� -1��	 
	
	��ʾ��	
		3 <= mountain_arr.length() <= 10000
		0 <= target <= 10^9
		0 <= mountain_arr.get(index) <= 10^9
 */
//1095. ɽ�������в���Ŀ��ֵ
public class FindinMountainArray {

	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 4, 2, 1 };
		MountainArray m = new MountainArrayImpl(array);
		System.out.println(new FindinMountainArray().findInMountainArray(3, m));

	}

	public int findInMountainArray(int target, MountainArray m) {
		int length = m.length();
		// ���ֲ������ֵ

		int l = 1;
		int r = length - 1;
		while (l < r) {
			int mid = (l + r + 1) / 2;

			int ml = m.get(mid - 1);
			int mm = m.get(mid);

			if (ml > mm) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}
		int peek = l;
		// System.out.println("���ֵ��" + m.get(peek));
		int count = -1;
		// ����ߵ�
		l = 0;
		r = peek;
		while (l <= r) {
			int mid = (l + r) / 2;
			int mm = m.get(mid);
			if (mm < target) {
				l = mid + 1;
			} else if (mm > target) {
				r = mid - 1;
			} else {
				return mid;
			}
		}
		// ���ұߵ�
		l = peek;
		r = length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			int mm = m.get(mid);
			if (mm < target) {
				r = mid - 1;
			} else if (mm > target) {
				l = mid + 1;
			} else {
				return mid;
			}
		}

		return count;

	}

}
