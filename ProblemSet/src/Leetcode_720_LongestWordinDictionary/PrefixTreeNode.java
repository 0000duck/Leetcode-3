package Leetcode_720_LongestWordinDictionary;

public class PrefixTreeNode {

	/**
	 * ���������ַ���
	 */
	String word = "";

	/**
	 * ����ÿһ���ڵ���˵���������a-z�����е������ڵ����������������������ڵ��������ڵ�����ϵ �����wo������˵�����������ڵ�Ϊroot��'w' -
	 * 'a' = 22��root�ڵ��Ӧ������root.links[22] = null ��ʱ�½�һ���ڵ��ʾroot�ڵ��w����Ӧ�Ľڵ�������'o' -
	 * 'a' = 14������w����Ӧ�Ľڵ���w.links[14] = null ͬ���½�һ���ڵ�����ʾ�ڵ�'w'�ͽڵ�'o'����
	 */
	PrefixTreeNode[] links = new PrefixTreeNode[26];

	/**
	 * ʵ����ǰ׺���в���һ������
	 */
	public void insert(String s) {
		char[] chs = s.toCharArray();
		PrefixTreeNode curNode = this;
		// ������ǰ�����е�ÿһ���ַ�
		for (int i = 0; i < chs.length; i++) {
			// �жϵ�ǰ�ַ���Ӧ�Ľڵ��Ƿ���curNode�����������У��������������ַ���Ӧ�ڵ�
			int index = chs[i] - 'a';
			if (curNode.links[index] == null) {
				curNode.links[index] = new PrefixTreeNode();
			}
			// �ж���һ���ַ�
			curNode = curNode.links[index];
		}
		// ��ǰ�ڵ��Ӧ�ĵ���Ϊs
		curNode.word = s;
	}

}
