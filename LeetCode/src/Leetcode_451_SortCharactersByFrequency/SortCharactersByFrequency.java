package Leetcode_451_SortCharactersByFrequency;
/*
	����һ���ַ������뽫�ַ�������ַ����ճ��ֵ�Ƶ�ʽ������С�
	
	ʾ�� 1:
		����:
			"tree"
		���:
			"eert"	
	����:
		'e'�������Σ�'r'��'t'��ֻ����һ�Ρ�
		���'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
		
	ʾ�� 2:
		����:
			"cccaaa"
		���:
			"cccaaa"
	����:
		'c'��'a'���������Ρ����⣬"aaaccc"Ҳ����Ч�Ĵ𰸡�
		ע��"cacaca"�ǲ���ȷ�ģ���Ϊ��ͬ����ĸ�������һ��
		
	ʾ�� 3:
		����:
			"Aabb"
		
		���:
			"bbAa"
	����:
		���⣬"bbaA"Ҳ��һ����Ч�Ĵ𰸣���"Aabb"�ǲ���ȷ�ġ�
		ע��'A'��'a'����Ϊ�����ֲ�ͬ���ַ���
*/
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortCharactersByFrequency scby = new SortCharactersByFrequency();
		System.out.println(scby.frequencySort("tree"));
	}
	//451. �����ַ�����Ƶ������
    public String frequencySort(String s) {
    	//�����ַ���������
    	StringBuffer buffer = new StringBuffer(s);//tree
    	StringBuffer result = new StringBuffer();
    	//ɾ���ظ��ַ�
    	for(int i = 0;i<buffer.length()-1;i++) {
    		for(int j =i+1;j<buffer.length();) {
    			if(buffer.charAt(i)==buffer.charAt(j)) {
    				buffer.deleteCharAt(j);
    			}else {
    				j++;
    			}
    		}
    	}
    	//ͳ���ַ���Ƶ�� tre
    	int[] requency = new int[buffer.length()];//112
    	for(int i = 0;i<buffer.length();i++) {
    		for(int j = 0;j<s.length();j++) {
    			if(buffer.charAt(i)==s.charAt(j)) {
    				requency[i]++;
    			}
    		}
    	}
    	//����Ƶ������//211 etr
    	for(int i = 0;i<requency.length-1;i++) {
    		for(int j=i+1;j<requency.length;j++) {
    			if(requency[i]<requency[j]) {
    				int temp = requency[i];
    				char tempchar = buffer.charAt(i);
    				requency[i] = requency[j];
    				buffer.deleteCharAt(i).insert(i, buffer.charAt(j));
    				requency[j]=temp;
    				buffer.deleteCharAt(j).insert(j, tempchar);    				
    			}
    		}
    		for(int m = 0;m<requency[i];m++) {
    			result.append(buffer.charAt(i));
    		}
    	}
    	
    	return result.toString();
    	
    }

}
