package Leetcode_690_EmployeeImportance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
	����һ������Ա����Ϣ�����ݽṹ����������Ա��Ψһ��id����Ҫ�� �� ֱϵ������id��	
	���磬Ա��1��Ա��2���쵼��Ա��2��Ա��3���쵼��������Ӧ����Ҫ��Ϊ15, 10, 5��
	��ôԱ��1�����ݽṹ��[1, 15, [2]]��Ա��2�����ݽṹ��[2, 10, [3]]��Ա��3�����ݽṹ��[3, 5, []]��
	ע����ȻԱ��3Ҳ��Ա��1��һ���������������ڲ�����ֱϵ���������û��������Ա��1�����ݽṹ�С�
	
	��������һ����˾������Ա����Ϣ���Լ�����Ա��id���������Ա������������������Ҫ��֮�͡�
	
	ʾ�� 1:	
		����: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
		���: 11
	����:
		Ա��1�������Ҫ����5����������ֱϵ����2��3������2��3����Ҫ�Ⱦ�Ϊ3�����Ա��1������Ҫ���� 5 + 3 + 3 = 11��
	
	ע��:	
		һ��Ա�������һ��ֱϵ�쵼�����ǿ����ж��ֱϵ����
		Ա������������2000��
 */
public class EmployeeImportance {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		EmployeeImportance ei = new EmployeeImportance();
		List<Employee> employees = new ArrayList<Employee>();
		// id Ϊ1 ��Ա��
		Employee em = new Employee();
		em.setId(1);
		em.setImportance(5);
		List<Integer> subordinates1 = Arrays.asList(2, 3);
		em.setSubordinates(subordinates1);
		employees.add(em);
		// id Ϊ2 ��Ա��
		Employee em2 = new Employee();
		em2.setId(2);
		em2.setImportance(3);
		List<Integer> subordinates2 = new ArrayList<Integer>();
		em2.setSubordinates(subordinates2);
		employees.add(em2);
		// id Ϊ 3 ��Ա��
		Employee em3 = new Employee();
		em3.setId(3);
		em3.setImportance(3);
		List<Integer> subordinates3 = new ArrayList<Integer>();
		em3.setSubordinates(subordinates3);
		employees.add(em3);

		ei.getImportance(employees, 1);

	}	

	// 690. Ա������Ҫ��
	public int getImportance(List<Employee> employees, int id) {
		int result = 0;
		// ����Ա���ҵ�idԱ��
		for (Employee em : employees) {
			if (em.id == id) {
				result += em.importance;
				if (em.subordinates.size() != 0) {
					for (Integer subid : em.subordinates) {
						result += getImportance(employees, subid);
					}
				}
			}

		}
		return result;
	}
	
	//7ms
	int importance =0;
    public int getImportance0(List<Employee> employees, int id) {
    	HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
    	for(Employee e: employees) {
    		map.put(e.id, e);
    	}
    	dfs(map.get(id), map);
    	return importance;
    }
    public void dfs(Employee e, HashMap<Integer, Employee> map) {
    	importance += e.importance;
    	for(Integer i: e.subordinates) {
    		dfs(map.get(i), map);
    	}
    }

}
