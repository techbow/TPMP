package Array;

public class reverseString {
	public class Solution {
		/**
		 * @param s : A string
		 * @return : A string
		 */
		public String reverseWords(String s) {
			/*异常处理 注意return type
			 * 考虑只有一个空格和多个空格的特殊情况
			 * 用split()函数时，注意要考虑多个空格的情况，也为if (!arr[i].equals("")) check的情况
			 * eg：一个3个空格的string split后变成length为3但存储空字符串的String[]
			 * 
			 * 用substring函数时，最后返回的函数是包括start但不包括end的
			 */
			if( s == null || s.length() == 0 ){
				return "";
			}

			String[] arr = s.split(" ");
			
			StringBuilder sb = new StringBuilder();

			for(int i = arr.length - 1; i >= 0; i--){
				if (!arr[i].equals("")) {
					sb.append(arr[i]).append(" ");
				}
			}
			return sb.length() == 0? " ":sb.substring(0, sb.length() - 1);
		}
	}

}
