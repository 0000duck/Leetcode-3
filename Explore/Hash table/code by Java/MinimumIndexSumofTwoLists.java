package Leetcode_599_MinimumIndexSumofTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	����Andy��Doris�������ʱѡ��һ�Ҳ������������Ƕ���һ����ʾ��ϲ���������б�ÿ���������������ַ�����ʾ��	
	����Ҫ�������������ٵ��������ҳ����ǹ�ͬϲ���Ĳ����� ����𰸲�ֹһ������������д𰸲��Ҳ�����˳�� ����Լ������Ǵ���һ���𰸡�
	
	ʾ�� 1:	
		����:
			["Shogun", "Tapioca Express", "Burger King", "KFC"]
			["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
		���: ["Shogun"]
		����: ����Ψһ��ͬϲ���Ĳ����ǡ�Shogun����
	ʾ�� 2:	
		����:
			["Shogun", "Tapioca Express", "Burger King", "KFC"]
			["KFC", "Shogun", "Burger King"]
		���: ["Shogun"]
		����: ���ǹ�ͬϲ���Ҿ�����С�����͵Ĳ����ǡ�Shogun����������С��������1(0+1)��
	��ʾ:	
		1.�����б�ĳ��ȷ�Χ���� [1, 1000]�ڡ�
		2.�����б��е��ַ����ĳ��Ƚ���[1��30]�ķ�Χ�ڡ�
		3.�±��0��ʼ�����б�ĳ��ȼ�1��
		4.�����б�û���ظ���Ԫ�ء�
 */
public class MinimumIndexSumofTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 599. �����б����С�����ܺ�
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> resmap = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		int minIndex = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				resmap.put(list2[i], map.get(list2[i]) + i);
				if (minIndex > map.get(list2[i]) + i) {
					count = 1;
					minIndex = map.get(list2[i]) + i;
				} else if (minIndex == map.get(list2[i]) + i) {
					count++;
				}
			}
		}
		String[] result = new String[count];
		int i = 0;
		for (String x : resmap.keySet()) {
			if (resmap.get(x) == minIndex) {
				result[i++] = x;
			}
		}
		return result;
	}

	// 16ms
	public String[] findRestaurant2(String[] list1, String[] list2) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int index = 2000;
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		for (int i = 0; i < list2.length && i <= index; i++) {
			if (map.containsKey(list2[i])) {
				int tempIndex = map.get(list2[i]) + i;
				if (tempIndex < index) {
					result.clear();
					result.add(list2[i]);
					index = tempIndex;
				} else if (tempIndex == index) {
					result.add(list2[i]);
				}
			}
		}
		return result.toArray(new String[result.size()]);
	}

}
