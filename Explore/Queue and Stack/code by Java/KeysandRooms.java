package Leetcode_841_KeysandRooms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
	�� N �����䣬��ʼʱ��λ�� 0 �ŷ��䡣
	ÿ�������в�ͬ�ĺ��룺0��1��2��...��N-1�����ҷ����������һЩԿ����ʹ�������һ�����䡣
	
	����ʽ�ϣ�����ÿ������ i ����һ��Կ���б� rooms[i]��ÿ��Կ�� rooms[i][j] �� [0,1��...��N-1] �е�һ��������ʾ������ N = rooms.length�� 
	Կ�� rooms[i][j] = v ���Դ򿪱��Ϊ v �ķ��䡣
	
	������� 0 �ŷ�������������з��䶼����ס��	
	��������ɵ��ڷ���֮�������߶���	
	����ܽ���ÿ�����䷵�� true�����򷵻� false��
	
	ʾ�� 1��	
		����: [[1],[2],[3],[]]
		���: true
	����:  
		���Ǵ� 0 �ŷ��俪ʼ���õ�Կ�� 1��
		֮������ȥ 1 �ŷ��䣬�õ�Կ�� 2��
		Ȼ������ȥ 2 �ŷ��䣬�õ�Կ�� 3��
		�������ȥ�� 3 �ŷ��䡣
		���������ܹ�����ÿ�����䣬���Ƿ��� true��
		
	ʾ�� 2��	
		���룺[[1,3],[3,0,1],[2],[0]]
		�����false
	���ͣ����ǲ��ܽ��� 2 �ŷ��䡣
	
	��ʾ��	
		1.1 <= rooms.length <= 1000
		2.0 <= rooms[i].length <= 1000
		3.���з����е�Կ�������ܼƲ����� 3000��
 */
public class KeysandRooms {
	// 841. Կ�׺ͷ���
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		if (rooms.size() == 1) {
			return true;
		}
		boolean[] roomIsOpen = new boolean[rooms.size()];
		Set<Integer> keySet = new HashSet<Integer>();
		// ����+BFS
		Queue<Integer> keyQueue = new LinkedList<Integer>();
		for (int key : rooms.get(0)) {
			keyQueue.add(key);
			keySet.add(key);
			roomIsOpen[0] = true;
		}
		while (!keyQueue.isEmpty()) {
			int curKey = keyQueue.poll();
			// ��Կ�׿���
			if (!roomIsOpen[curKey]) {
				List<Integer> curRoom = rooms.get(curKey);
				roomIsOpen[curKey] = true;
				// ����ȡԿ��
				for (int keyTemp : curRoom) {
					if (keySet.contains(keyTemp)) {
						continue;
					} else {
						keySet.add(keyTemp);
						keyQueue.offer(keyTemp);
					}
				}
			} else {
				continue;
			}
		}

		for (boolean roomisopen : roomIsOpen) {
			if (!roomisopen) {
				return false;
			}
		}
		return true;
	}

	// 4ms
	public boolean canVisitAllRooms0(List<List<Integer>> rooms) {
		/* DFS */
		int size = rooms.size();
		boolean[] visited = new boolean[size];
		dfsVisit(rooms, 0, visited);
		for (int i = 0; i < size; ++i) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private void dfsVisit(List<List<Integer>> rooms, int in, boolean[] visited) {
		// �����in�����ȥ�ˣ��򷵻ء����򣬽���
		if (visited[in]) {
			return;
		}
		// �����Ѵ�
		visited[in] = true;
		// ȡ�����е�Կ��
		for (int temp : rooms.get(in)) {
			// ȡԿ�׿���
			if (!visited[temp]) {
				dfsVisit(rooms, temp, visited);
			}
		}
	}
}
