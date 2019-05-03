
package Leetcode_341_FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
	����һ��Ƕ�׵������б����һ����������ʹ���ܹ�������������б��е�����������	
	�б��е������Ϊһ����������������һ���б�	
	ʾ�� 1:	
		����: [[1,1],2,[1,1]]
		���: [1,1,2,1,1]
		����: ͨ���ظ����� next ֱ�� hasNext ����false��next ���ص�Ԫ�ص�˳��Ӧ����: [1,1,2,1,1]��
	ʾ�� 2:	
		����: [1,[4,[6]]]
		���: [1,4,6]
		����: ͨ���ظ����� next ֱ�� hasNext ����false��next ���ص�Ԫ�ص�˳��Ӧ����: [1,4,6]��
 */

//341. ��ƽ��Ƕ���б������
public class NestedIterator implements Iterator<Integer> {

	Stack<NestedInteger> stack = new Stack<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger curr = stack.peek();
			if (curr.isInteger()) {
				return true;
			}
			stack.pop();
			for (int i = curr.getList().size() - 1; i >= 0; i--) {
				stack.push(curr.getList().get(i));
			}
		}
		return false;
	}

}

//����������Ƕ���б�Ľӿڡ�
//�㲻Ӧ��ʵ���������Ʋ�����ʵ��
