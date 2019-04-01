package Leetcode_006_ZigZagConversion;

/*
	��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�	
	���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�	
	L   C   I   R
	E T O E S I I G
	E   D   H   N
	֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��	
	����ʵ��������ַ�������ָ�������任�ĺ�����	
		string convert(string s, int numRows);
	ʾ�� 1:	
		����: s = "LEETCODEISHIRING", numRows = 3
		���: "LCIRETOESIIGEDHN"
	ʾ�� 2:	
		����: s = "LEETCODEISHIRING", numRows = 4
		���: "LDREOEIIECIHNTSG"
	����:	
		L     D     R
		E   O E   I I
		E C   I H   N
		T     S     G
 */
public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();

		System.out.println(zzc.convert("PAYPALISHIRING", 3));
		System.out.println("LCIRETOESIIGEDHN");
	}

	// 6. Z ���α任
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (numRows == 1) {
			return s;
		}
		int length = s.length();
		int c = (length / (2 * numRows - 2)) * (numRows - 1);
		if (length % (2 * numRows - 2) > numRows) {
			c = c + 1 + length % (2 * numRows - 2) - numRows;
		} else {
			c += 1;
		}
		int col = c;
		char[][] temp = new char[numRows][col];
		int i = 0;
		int crow = 0;
		int ccol = 0;
		while (i < length) {
			// ����
			while (i < length && crow < numRows - 1) {
				temp[crow++][ccol] = s.charAt(i++);
			}
			// ����
			while (i < length && crow > 0) {
				temp[crow--][ccol++] = s.charAt(i++);
			}
		}
		// �����õ����
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < numRows; x++) {
			for (int y = 0; y < col; y++) {
				if (temp[x][y] != '\0') {
					sb.append(temp[x][y]);
				}
			}
		}
		return sb.toString();
	}

	public String convert0(String s, int nRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuffer();

		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
				sb[idx].append(c[i++]);
			for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
				sb[idx].append(c[i++]);
		}
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}
}
