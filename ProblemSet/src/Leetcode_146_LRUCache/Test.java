package Leetcode_146_LRUCache;

/*
	ʾ��:	
		LRUCache cache = new LRUCache( 2 /* ��������  );
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // ����  1
		cache.put(3, 3);    // �ò�����ʹ����Կ 2 ����
		cache.get(2);       // ���� -1 (δ�ҵ�)
		cache.put(4, 4);    // �ò�����ʹ����Կ 1 ����
		cache.get(1);       // ���� -1 (δ�ҵ�)
		cache.get(3);       // ����  3
		cache.get(4);       // ����  4
		["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 */
public class Test {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(0);
		String[] test = { "LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get" };
		int[][] value = { { 2, 0 }, { 1, 1 }, { 2, 2 }, { 1, 0 }, { 3, 3 }, { 2, 0 }, { 4, 4 }, { 1, 0 }, { 3, 0 },
				{ 4, 0 } };
		for (int i = 0; i < test.length; i++) {
			if (test[i].equals("LRUCache")) {
				lru = new LRUCache(value[i][0]);
				System.out.println("LRUCache cache = new LRUCache(" + value[i][0] + ")");
			}
			if (test[i].equals("put")) {
				lru.put(value[i][0], value[i][1]);
				System.out.println("put(" + value[i][0] + "," + value[i][1] + ")");
			}
			if (test[i].equals("get")) {
				lru.get(value[i][0]);
				System.out.println("get(" + value[i][0] + ")");
			}
		}
	}
}
