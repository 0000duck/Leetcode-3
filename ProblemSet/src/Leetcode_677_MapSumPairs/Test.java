package Leetcode_677_MapSumPairs;

public class Test {
	public static void main(String[] args) {
		MapSum ms = new MapSum();
		ms.insert("apple", 3);
		//����: insert("apple", 3), ���: Null
		System.out.println(ms.sum("apple"));
		//����: sum("ap"), ���: 3
		ms.insert("app", 2);
		//����: insert("app", 2), ���: Null
		System.out.println(ms.sum("ap"));
		//����: sum("ap"), ���: 5
	}
}
