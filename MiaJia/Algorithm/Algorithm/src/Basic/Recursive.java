package Basic;

public class Recursive {
	/*
	 * Recursion in computer science is a method where the solution to 
	 * a problem depends on solutions to smaller instances of the 
	 * same problem (wiki)
	 * 
	 * 
	 * Classic Example
	 * Fibonacci sequence
	 * 		1. base case  (N=0, N=1)
	 * 		2. f(n) = F(f(n-1))
	 * Climbing Stairs 可以从两方面理解
	 * Top down 最后一步可以有几种选择 1 走一步 2 走两步
	 * Bottom up 第一步有几种选择 1 走一步 2 走两步 异常处理 n=0
	 * 		F(n){
	 * 			if(n==0)return 0;
			if(n==1)return 1;
			if(n==2)return 2;
			return F(n-1) + F(n-2);
		}

	 * Factorial
	 */

	/*
	 * Decode Ways
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
	 */
	public int numDecodings(String s){
		if (s.length() == 0 || s == null) return 0;
		if (s.length() == 1 && s.equals(0)) return 0;
		return numDecodingsHelper(s);
	}
	int numDecodingsHelper(String s){
		//最后一步的几种情况
		if (s.length() == 0) return 1;
		if (s.length() == 1) return 1;
		//why - '0'charAt() method 得出的是ASCI码 需要减去0
		int firstDig = s.charAt(0) - '0';
		int secondDig = s.charAt(1) - '0';
		//注意这里判断的是第二个值
		if( secondDig == 0) 
			return  numDecodingsHelper(s.substring(2));
		if( (firstDig == 1) || (firstDig == 2 && secondDig <= 6))
			return  numDecodingsHelper(s.substring(1)) + numDecodingsHelper(s.substring(2));

		return numDecodingsHelper(s.substring(1));
	}



}
