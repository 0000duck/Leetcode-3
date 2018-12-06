package Leetcode_706_DesignHashMap;

import java.util.HashMap;
import java.util.Map;

/*
	��ʹ���κ��ڽ��Ĺ�ϣ������һ����ϣӳ��
	
	�����˵��������Ӧ�ð������µĹ���	
		put(key, value)�����ϣӳ���в���(��,ֵ)����ֵ�ԡ��������Ӧ��ֵ�Ѿ����ڣ��������ֵ��
		get(key)�����ظ����ļ�����Ӧ��ֵ�����ӳ���в����������������-1��
		remove(key)�����ӳ���д����������ɾ�������ֵ�ԡ�
		
	ʾ����	
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		hashMap.get(1);            // ���� 1
		hashMap.get(3);            // ���� -1 (δ�ҵ�)
		hashMap.put(2, 1);         // �������е�ֵ
		hashMap.get(2);            // ���� 1 
		hashMap.remove(2);         // ɾ����Ϊ2������
		hashMap.get(2);            // ���� -1 (δ�ҵ�) 
	
	ע�⣺	
		���е�ֵ���� [1, 1000000]�ķ�Χ�ڡ�
		����������Ŀ��[1, 10000]��Χ�ڡ�
		��Ҫʹ���ڽ��Ĺ�ϣ�⡣
 */
//706. ��ƹ�ϣӳ��
class MyHashMap {
	private boolean[] keyArray;
	private int[] valueArray;

	/** Initialize your data structure here. */
	public MyHashMap() {
		keyArray = new boolean[1000001];
		valueArray = new int[1000001];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		keyArray[key] = true;
		valueArray[key] = value;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		if (keyArray[key]) {
			return valueArray[key];
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		keyArray[key] = false;

	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//89ms
class DesignHashMap {

	Map<Integer, Integer> map = null;

	/** Initialize your data structure here. */
	public DesignHashMap() {
		map = new HashMap<>();
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		map.put(key, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return -1;
		}
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		map.remove(key);
	}
}
