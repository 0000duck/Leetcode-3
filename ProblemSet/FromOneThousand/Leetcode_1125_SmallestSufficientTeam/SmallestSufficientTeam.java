package Leetcode_1125_SmallestSufficientTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
	��Ϊ��Ŀ������滮��һ������ļ����嵥 req_skills��
	������ӱ�ѡ��Ա���� people ��ѡ��Щ�����һ������Ҫ�Ŷӡ�
	�� ���Ϊ i �ı�ѡ��Ա people[i] ����һ�ݸñ�ѡ��Ա���յļ����б���
	
	��ν����Ҫ�Ŷӡ�������������Ŷ��У�
	����������ļ����б� req_skills ���г���ÿ��ܣ�
	�Ŷ���������һ����Ա�Ѿ����ա�
	
	���ǿ�����ÿ���˵ı������ʾ�Ŷ��еĳ�Ա��
	���磬�Ŷ� team = [0, 1, 3] ��ʾ���ռ��ֱܷ�Ϊ 
	people[0]��people[1]���� people[3] �ı�ѡ��Ա��
	
	���㷵�� ��һ ��ģ��С�ı�Ҫ�Ŷӣ��Ŷӳ�Ա����Ա��ű�ʾ��
	����԰�����˳�򷵻ش𰸣����Ᵽ֤�𰸴��ڡ�
	
	 
	
	ʾ�� 1��	
		���룺
			req_skills = ["java","nodejs","reactjs"], 
			people = [["java"],["nodejs"],["nodejs","reactjs"]]
		�����[0,2]
	
	ʾ�� 2��	
		���룺
			req_skills = ["algorithms","math","java","reactjs","csharp","aws"], 
			people = [	["algorithms","math","java"],
						["algorithms","math","reactjs"],
						["java","csharp","aws"],
						["reactjs","csharp"],
						["csharp","math"],
						["aws","java"]]
		�����[1,2] 
	
	��ʾ��
		1 <= req_skills.length <= 16
		1 <= people.length <= 60
		1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16
		req_skills �� people[i] �е�Ԫ�طֱ������ͬ
		req_skills[i][j], people[i][j][k] ����СдӢ����ĸ���
		���Ᵽ֤����Ҫ�Ŷӡ�һ������
 */

//1125.��С�ı�Ҫ�Ŷ�
public class SmallestSufficientTeam {
	public static void main(String[] args) {
		String[] req_skills = { "algorithms", "math", "java", "reactjs", "csharp", "aws" };
		String[][] peo = { { "algorithms", "math", "java" }, { "algorithms", "math", "reactjs" },
				{ "java", "csharp", "aws" }, { "reactjs", "csharp" }, { "csharp", "math" }, { "aws", "java" } };
		List<List<String>> people = new ArrayList<List<String>>();
		for (int i = 0; i < peo.length; i++) {
			people.add(Arrays.asList(peo[i]));
		}
		new SmallestSufficientTeam().smallestSufficientTeam(req_skills, people);

	}

	public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
		int ns = skills.length;
		int np = people.size();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < ns; i++) {
			map.put(skills[i], i);
		}
		List<Integer>[] dp = new List[1 << ns];
		dp[0] = new ArrayList<Integer>();
		for (int i = 0; i < np; i++) {
			int skill = 0;
			for (String str : people.get(i)) {
				skill |= (1 << map.get(str));
			}
			for (int prev = 0; prev < dp.length; prev++) {
				if (dp[prev] == null) {
					continue;
				}
				int comb = prev | skill;
				if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
					dp[comb] = new ArrayList<Integer>(dp[prev]);
					dp[comb].add(i);
				}
			}
		}
		int i = 0;
		List<Integer> list = dp[dp.length - 1];
		int[] res = new int[list.size()];
		for (Integer x : list) {
			res[i++] = x;
		}
		return res;
	}

}
