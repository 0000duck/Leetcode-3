package Leetcode_819_MostCommonWord;

import java.util.HashMap;
import java.util.Set;

/*
	����һ������ (paragraph) ��һ�����õ����б� (banned)�����س��ִ�����࣬ͬʱ���ڽ����б��еĵ��ʡ���Ŀ��֤������һ���ʲ��ڽ����б��У����Ҵ�Ψһ��	
	�����б��еĵ�����Сд��ĸ��ʾ�����������š������еĵ��ʲ����ִ�Сд���𰸶���Сд��ĸ��
		
	ʾ����	
		����: 
			paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
			banned = ["hit"]
		���: "ball"
		����: 
			"hit" ������3�Σ�������һ�����õĵ��ʡ�
			"ball" ������2�� (ͬʱû���������ʳ���2��)���������Ƕ�������ִ������ģ��Ҳ��ڽ����б��еĵ��ʡ� 
			ע�⣬������Щ�����ڶ����ﲻ���ִ�Сд����������Ҫ���ԣ���ʹ�ǽ����ŵ���Ҳ���ԣ� ���� "ball,"���� 
			"hit"�������յĴ𰸣���Ȼ�����ִ������࣬�����ڽ��õ����б��С�	 
	
	˵����	
		1 <= ���䳤�� <= 1000.
		1 <= ���õ��ʸ��� <= 100.
		1 <= ���õ��ʳ��� <= 10.
		����Ψһ��, �Ҷ���Сд��ĸ (��ʹ�� paragraph ���Ǵ�д�ģ���ʹ��һЩ�ض������ʣ��𰸶���Сд�ġ�)
		paragraph ֻ������ĸ���ո�����б�����!?',;.
		������û�����ַ����ߴ������ַ��ĵ��ʡ�
		������ֻ������ĸ���������ʡ�ԺŻ������������š�
 */
public class MostCommonWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostCommonWord mc = new MostCommonWord();
		String paragraph = "Bob. hIt, baLl";
		String[] banned = { "bob", "hit" };
		System.out.println(mc.mostCommonWord(paragraph, banned));

	}

	// 819. ����ĵ���
	public String mostCommonWord(String paragraph, String[] banned) {
		// ������ʽ
		String[] para = paragraph.toLowerCase().split("\\s|\\!|\\'|\\;|\\?|\\.|\\,");
		HashMap<String, Integer> map = new HashMap<>();
		int maxNum = 1;
		for (int i = 0; i < para.length; i++) {
			while (para[i].equals("")) {
				i++;
			}
			if (map.containsKey(para[i])) {
				int temp = map.get(para[i]) + 1;
				map.put(para[i], temp);
				maxNum = Math.max(maxNum, temp);
			} else {
				// �����ڽ�ֹ����
				if (notBanned(banned, para[i]))
					map.put(para[i], 1);
			}
		}

		Set<String> set = map.keySet();
		String maxNumStr = "";
		for (String str : set) {
			if (map.get(str) == maxNum) {
				maxNumStr = str;
				break;
			}
		}
		return maxNumStr;
	}

	// �жϵ����Ƿ� �����ڽ�ֹ����
	public boolean notBanned(String[] banned, String str) {
		for (String ban : banned) {
			if (ban.equals(str))
				return false;
		}
		return true;
	}
}
