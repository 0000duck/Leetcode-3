package Leetcode_297_SerializeandDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	���л��ǽ�һ�����ݽṹ���߶���ת��Ϊ�����ı���λ�Ĳ�����
	�������Խ�ת��������ݴ洢��һ���ļ������ڴ��У�
	ͬʱҲ����ͨ�����紫�䵽��һ���������������ȡ�෴��ʽ�ع��õ�ԭ���ݡ�
	
	�����һ���㷨��ʵ�ֶ����������л��뷴���л���
	���ﲻ�޶�������� / �����л��㷨ִ���߼���
	��ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��
	
	ʾ��: 	
		����Խ����¶�������
		
		    1
		   / \
		  2   3
		     / \
		    4   5
	
		���л�Ϊ "[1,2,3,null,null,4,5]"
	
	��ʾ: 
		���� LeetCode Ŀǰʹ�õķ�ʽһ�£���������� LeetCode ���л��������ĸ�ʽ��
		�㲢�Ǳ����ȡ���ַ�ʽ����Ҳ���Բ��������ķ������������⡣
	
	˵��: 
		��Ҫʹ����ĳ�Ա / ȫ�� / ��̬�������洢״̬��������л��ͷ����л��㷨Ӧ������״̬�ġ�
 */
//297. �����������л��뷴���л�
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return rserialize(root, "");
	}

	public String rserialize(TreeNode root, String str) {
		// Recursive serialization.
		if (root == null) {
			str += "null,";
		} else {
			str += str.valueOf(root.val) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
		return str;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return rdeserialize(data_list);
	}

	public TreeNode rdeserialize(List<String> l) {
		// Recursive deserialization.
		if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);

		return root;
	}

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));