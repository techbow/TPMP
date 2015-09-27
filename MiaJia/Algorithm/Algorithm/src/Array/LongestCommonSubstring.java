package Array;

public class LongestCommonSubstring {
	/**
	 * @param A, B: Two string.
	 * @return: the length of the longest common substring.
	 */
	public static int longestCommonSubstring(String A, String B) {
		// write your code here
		int lcs = 0;
		int xlen = A.length();
		int ylen = B.length();
		for(int i = 0; i < xlen; ++i)
		{
			for(int j = 0; j < ylen; ++j)
			{
				// 注意这个循环的方式，len每一次都要置0
				int len = 0;
				while (i + len < xlen && j + len < ylen && A.charAt(i + len) == B.charAt(j + len)){
					len ++;
				}
				lcs = Math.max(lcs,len);
			}
		}
		return lcs;
	}
	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("abcsdf","asdfabc"));
	}
}