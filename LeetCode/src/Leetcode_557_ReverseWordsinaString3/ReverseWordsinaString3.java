package Leetcode_557_ReverseWordsinaString3;

/*
����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��

ʾ�� 1:
	����: "Let's take LeetCode contest"
	���: "s'teL ekat edoCteeL tsetnoc" 
ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�
*/
public class ReverseWordsinaString3 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ReverseWordsinaString3 rws = new ReverseWordsinaString3();
		String s = "Let's take LeetCode contest";
		
		System.out.println("Let's take LeetCode contest");
		System.out.println(rws.reverseWords(s));
		
	}

	// 557.��ת����
	public String reverseWords(String s) {
		StringBuilder builder = new StringBuilder(s);
		StringBuilder result = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		//�ҳ���һ���ո�	
		int index;
		while((index =builder.indexOf(" "))!=-1) {
			//System.out.println(index);
			//��ȡ��һ������,��ӵ�temp�ַ�������������ת��ӵ�result��
			result.append(temp.append(builder.subSequence(0, index)).reverse()).append(" ");
			//���temp;
			temp.delete(0, temp.length());
			//ɾ����һ������
			builder.delete(0, index+1);			
		}
		//���һ������
		result.append(builder.reverse());
		return result.toString();
		
	}
	

}
