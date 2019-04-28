package Leetcode_1036_EscapeaLargeMaze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
	��һ�� 10^6 x 10^6 �������У�ÿ������������Ϊ (x, y)������ 0 <= x, y < 10^6��
	
	���Ǵ�Դ���� source ��ʼ��������ͼ����Ŀ�귽�� target��
	ÿ���ƶ������Ƕ������ߵ����������ĸ����������ڵķ���ֻҪ�÷����ڸ����ķ����б� blocked �ϡ�
	
	ֻ���ڿ���ͨ��һϵ�е��ƶ�����Ŀ�귽��ʱ�ŷ��� true�����򣬷��� false��	 
	
	ʾ�� 1��	
		���룺blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
		�����false
		���ͣ�
		��Դ�����޷�����Ŀ�귽����Ϊ�����޷����������ƶ���
	ʾ�� 2��	
		���룺blocked = [], source = [0,0], target = [999999,999999]
		�����true
		���ͣ�
		��Ϊû�з��񱻷���������һ�����Ե���Ŀ�귽�� 
	
	��ʾ��	
		0 <= blocked.length <= 200
		blocked[i].length == 2
		0 <= blocked[i][j] < 10^6
		source.length == target.length == 2
		0 <= source[i][j], target[i][j] < 10^6
		source != target
 */

//1036.������Թ�
public class EscapeaLargeMaze {
	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		// û���谭
		if (blocked.length == 0) {
			return true;
		}
		HashSet<String> visited = new HashSet();
		HashSet<String> blockc = new HashSet();

		for (int[] block : blocked) {
			blockc.add(block[0] + "+" + block[1]);
		}

		Queue<int[]> travel = new LinkedList();
		travel.add(source);
		int level = 0;
		while (!travel.isEmpty()) {

			if (blockc.isEmpty() || blockc.size() < level + 1) {
				return true;
			}
			level++;
			int size = travel.size();
			while (size > 0) {
				size--;
				int[] current = travel.poll();

				String key = current[0] + "+" + current[1];
				if (visited.contains(key)) {
					continue;
				}

				if (blockc.contains(key)) {
					blockc.remove(key);
					visited.add(key);
					continue;
				}
				visited.add(key);
				for (int k = -1; k <= 1; k++) {
					for (int j = -1; j <= 1; j++) {
						if (Math.abs(k + j) == 1 && (current[0] + k) >= 0 && (current[1] + j) >= 0
								&& (current[0] + k) < 999999 && (current[1] + j) < 999999) {
							travel.add(new int[] { current[0] + k, current[1] + j });
						}
					}
				}
			}

		}

		return false;
	}

}
