package Array;
/*
 * 这道题的几个点，
 * 一就是alphanumeric characters and ignoring cases，字母和数字，忽略大小写。 
 * 二就是考虑空字符串是否为回文，最好在面试时候问下面试官，这里是认为空字符串是回文。
 * 因为忽略大小写，所以就统一为小写。
 * 然后就判断当前检查字符是否符合范围，否则大小指针挪动。
 * 如果发现有大小指针指向的值有不同的，就返回false，否则，继续检查。
 * 最后返回true。 
 */

public class isPalindrone {
	/**
	 * @param s A string
	 * @return Whether the string is a valid palindrome
	 */
	public boolean isPalindrome(String s) {
		if(s == null || s.length() == 0) return true;
		int start = 0;
		int end = s.length() - 1;        //注意减1

		while (start < end){
			if (start == end) return true;
			//front < s.length() && !isvalid(s.charAt(front)
			//if (!s.charAt(start).isvalid()) start++; java语法？
			//注意控制变量范围    
			if (start == s.length()-1)    return true; // for emtpy string “.,,,”
			//注意考虑多个非字母在一起的情况
			while (!isvalid(s.charAt(start)) && start < s.length() ) start++;
			while (!isvalid(s.charAt(end)) && end >= 0 ) end--;
			// if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
			//     start++;
			//     end--;
			// }else {
			//     break;
			// }
			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				break;
			} else {
				start++;
				end--;
			}
		}
		return false;

	}

	private boolean isvalid (char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}
}



//            

//         return end <= front; 
//     }

//     private boolean isvalid (char c) {
//         return Character.isLetter(c) || Character.isDigit(c);
//     }
// }
