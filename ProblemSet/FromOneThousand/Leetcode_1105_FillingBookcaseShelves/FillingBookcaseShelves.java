package Leetcode_1105_FillingBookcaseShelves;

/*
	�����ļҾӳǴ������������һֱ���ǵĿɵ�����ܣ�������Լ����鶼�����µ�����ϡ�	
	���Ҫ�ڷŵ��� books ������ã�����һ����
	�������£��� i ����ĺ��Ϊ books[i][0]���߶�Ϊ books[i][1]��	
	��˳�� ����Щ��ڷŵ��ܿ��Ϊ shelf_width ������ϡ�	
	��ѡ�������������ϣ����ǵĺ��֮��С�ڵ�����ܵĿ�� shelf_width����Ȼ���ٽ�һ����ܡ�
	�ظ�������̣�ֱ�������е��鶼��������ϡ�	
	��Ҫע����ǣ����������̵�ÿ�������У��ڷ����˳����������õ�˳����ͬ�� 
	���磬��������� 5 ���飬��ô���ܵ�һ�ְڷ�����ǣ�
		��һ�͵ڶ�������ڵ�һ������ϣ�����������ڵڶ�������ϣ����ĺ͵��屾��������һ������ϡ�	
	ÿһ�����ڷŵ�������߶Ⱦ�����һ����ܵĲ�ߣ��������ĸ߶�Ϊ�����֮�͡�	
	�����ַ�ʽ������ܣ��������������ܵ���С�߶ȡ�
	 
	1
	��������������
	1 1|1 1
	1 1|1 1
	1 1|1 1
	��������������
	     |1
	1|1|1|1
	��������������
	ʾ����	
		���룺books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
		�����6
		���ͣ�
			3 ����ܵĸ߶Ⱥ�Ϊ 1 + 3 + 2 = 6 ��
			�� 2 ���鲻�ط��ڵ�һ������ϡ�	
	��ʾ��	
		1 <= books.length <= 1000
		1 <= books[i][0] <= shelf_width <= 1000
		1 <= books[i][1] <= 1000
 */

//1105. ������
public class FillingBookcaseShelves {
	public static void main(String[] args) {
		int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
		int shelf_width = 4;
		new FillingBookcaseShelves().minHeightShelves(books, shelf_width);
	}

	public int minHeightShelves(int[][] books, int shelf_width) {
		int length = books.length;
		// dp[i] : 0����i-1���� ���԰ڷŵ���С�߶�
		int[] dp = new int[length + 1];
		for (int i = 1; i <= length; i++) {
			// �ȷ�����һ��
			dp[i] = dp[i - 1] + books[i - 1][1];
			// ���ϲ�����
			int curWidth = 0;// ��ǰ��Ŀ��
			int maxHeight = 0;// ��ǰ������߶�
			for (int j = i - 1; j >= 0; j--) {
				curWidth += books[j][0];
				maxHeight = Math.max(maxHeight, books[j][1]);
				if (curWidth <= shelf_width) {
					// �ҳ����ŵĽ��
					dp[i] = Math.min(dp[i], dp[j] + maxHeight);
				} else {
					break;
				}
			}
		}
		return dp[length];
	}
}
