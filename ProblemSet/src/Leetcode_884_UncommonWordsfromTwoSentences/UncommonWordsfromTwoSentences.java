package Leetcode_884_UncommonWordsfromTwoSentences;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/*
	������������ A �� B �� ��������һ���ɿո�ָ��ĵ��ʡ�ÿ�����ʽ���Сд��ĸ��ɡ���	
	���һ������������һ��������ֻ����һ�Σ�����һ��������ȴû�г��֣���ô������ʾ��ǲ������ġ�	
	�������в����õ��ʵ��б�	
	�����԰��κ�˳�򷵻��б�	 
	
	ʾ�� 1��	
		���룺A = "this apple is sweet", B = "this apple is sour"
		�����["sweet","sour"]
	ʾ�� 2��	
		���룺A = "apple apple", B = "banana"
		�����["banana"]	 
	
	��ʾ��	
		0 <= A.length <= 200
		0 <= B.length <= 200
		A �� B ��ֻ�����ո��Сд��ĸ��
 */
public class UncommonWordsfromTwoSentences {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	// 884. ���仰�еĲ���������
	public String[] uncommonFromSentences(String A, String B) {
		List<String> list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		// String[] strA = ;
		// String[] strB = );
		for (String str : A.split(" ")) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for (String str : B.split(" ")) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for (String str : map.keySet()) {
			if (map.get(str) == 1) {
				list.add(str);
			}
		}
		return list.toArray(new String[list.size()]);

	}

	// 5ms
	public String[] uncommonFromSentences0(String A, String B) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : A.split(" ")) {
			if (!map.containsKey(str))
				map.put(str, 1);
			else
				map.put(str, map.get(str) + 1);
		}

		for (String str : B.split(" ")) {
			if (!map.containsKey(str))
				map.put(str, 1);
			else
				map.put(str, map.get(str) + 1);
		}
		ArrayList<String> list = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) == 1)
				list.add(key);
		}

		return list.toArray(new String[list.size()]);
	}

}
