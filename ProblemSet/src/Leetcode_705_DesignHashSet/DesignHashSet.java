package Leetcode_705_DesignHashSet;

import java.util.LinkedList;
import java.util.List;

/*
	��ʹ���κ��ڽ��Ĺ�ϣ������һ����ϣ����	
	�����˵��������Ӧ�ð������µĹ���	
		add(value)�����ϣ�����в���һ��ֵ��
		contains(value) �����ع�ϣ�������Ƿ�������ֵ��
		remove(value)��������ֵ�ӹ�ϣ������ɾ���������ϣ������û�����ֵ��ʲôҲ������
	
	ʾ��:	
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		hashSet.contains(1);    // ���� true
		hashSet.contains(3);    // ���� false (δ�ҵ�)
		hashSet.add(2);          
		hashSet.contains(2);    // ���� true
		hashSet.remove(2);          
		hashSet.contains(2);    // ����  false (�Ѿ���ɾ��)
	
	ע�⣺	
		���е�ֵ���� [1, 1000000]�ķ�Χ�ڡ�
		����������Ŀ��[1, 10000]��Χ�ڡ�
		��Ҫʹ���ڽ��Ĺ�ϣ���Ͽ⡣
 */
//705. ��ƹ�ϣ����
//public class MyHashSet {
public class DesignHashSet {
	// ��Ա����
	private boolean[] flag;
	
	/** Initialize your data structure here. */
	// ���캯��
	// public MyHashSet() {
	public DesignHashSet() {
		flag = new boolean[100000];
	}

	// ��Ա����
	public void add(int key) {
		flag[key] = true;
	}

	public void remove(int key) {
		flag[key] = false;
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return flag[key];
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
//79ms
class MyHashSet {

	// ��ά����
	// in worst case it will take size of 1000000
	int bucket = 1000, item = 1001;
	boolean[][] table;

	/** Initialize your data structure here. */
	public MyHashSet() {
		table = new boolean[bucket][];
	}

	// hashֵ
	public int hash(int i) {
		return i % bucket;
	}

	// i��Ͱ��λ��
	public int pos(int i) {
		return i / bucket;
	}

	public void add(int key) {
		int hash = hash(key);
		if (table[hash] == null)
			table[hash] = new boolean[item];
		table[hash][pos(key)] = true;
	}

	public void remove(int key) {
		int hash = hash(key);
		if (table[hash] != null)
			table[hash][pos(key)] = false;
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int hash = hash(key);
		return table[hash] != null && table[hash][pos(key)];
	}
}
