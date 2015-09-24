package Basic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class reverse {
	/**
	 *
	 * Java program to reverse String in Java. 
	 * StringBuffer has a reverse() method which return StringBuffer with reversed contents. 
	 *
	 * you can also use StringBuilder to reverse String in Java. StringBuilder is non thread-safe
	 * version of StringBuffer and provides similar API. You can use StringBuilder's reverse()
	 * method to reverse content and then convert it back to String
	 *
	 * Points to Keep in Mind Before attempting the Solution:
	 * 1. String class in java do not have reverse() method
	 * 2. Only String class have toCharArray() method.
	 */
	public static class StringReverseExample {


		public static void main(String args[]) {
			String word;
			String reverse;

			//quick way to reverse String in Java - Use StringBuffer/StringBuilder
			word = "HelloWorld";
			reverse = new StringBuffer(word).reverse().toString();
			System.out.printf(" original String : %s , reversed String %s  %n", word, reverse);
			reverse = new StringBuilder(word).reverse().toString();
			System.out.printf(" original String : %s , reversed String %s  %n", word, reverse);
			
			//if cannot use build-in method
			//notice that you need to new a StringBuilder
			word = "HelloWorld";
			StringBuilder reverseb = new StringBuilder();
			for(int i = word.length() - 1; i >= 0; i--){
				reverseb.append(word.charAt(i));
			}
			System.out.printf(" original String : %s , reversed String %s %n", word, reverseb);


			//Way to reverse String without using StringBuffer or StringBuilder is writing
			//own utility method
			word = "HelloWorld";
			reverse = reverse1(word);
			System.out.printf(" original String : %s , reversed String %s %n", word, reverse);
			reverse = reverse2(word);
			System.out.printf(" original String : %s , reversed String %s %n", word, reverse);
			reverse = reverse3(word);
			System.out.printf(" original String : %s , reversed String %s %n", word, reverse);
			reverse = reverse4(word);
			System.out.printf(" original String : %s , reversed String %s %n", word, reverse);
	
		}   

		//Method 1: use String +; waste a lot of space
		public static String reverse1(String source){
			if(source == null || source.isEmpty()){
				return source;
			}       
			String reverse = "";
			for(int i = source.length() -1; i>=0; i--){
				reverse = reverse + source.charAt(i);
			}

			return reverse;
		}
		//Method 2 swap
		//note how to convert String to char[] and vice versa
		public static String reverse2(String source){
			if(source == null || source.isEmpty()){
				return source;
			}       
			char[] temp = source.toCharArray();
			int left = 0;
			int right = source.length() - 1;
			//don't need to worry about odd and even, when left == right, we don't need to swap
			for( left = 0; left < right; left++, right--){
				//swap value of left and right
				char temparray = temp[left];
				temp[left] = temp[right];
				temp[right] = temparray;
			}	
			String reverse = String.valueOf(temp);

			return reverse;
		}
		
		//Method 3 reverse
		public static String reverse3(String source){
			if(source == null || source.isEmpty()){
				return source;
			}       
			char[] temp = source.toCharArray();
			List<Character> src = new LinkedList<Character>();
			for(char c: temp){
				src.add(c);
			}
			Collections.reverse(src);
			String reverse = "";
			

			for(Character c: src){
				 reverse = reverse + c;
			}
//			直接用这句的话会输出[d, l, r, o, W, o, l, l, e, H] 			
//		    reverse = String.valueOf(src);
			return reverse;
		}
	//Method 4 
	/*
	 * 1. The last method is converting string into bytes .  getBytes()  method  is
	 *    used to convert the input string into bytes[].
	 * 2. Then we will create a temporary byte[]  of length equal to the length 
	 *    of the input string.
	 * 3. We will store the bytes(which we get by using getBytes() method) in reverse 
	 *    order into the temporary byte[] .
	 */
		public static String reverse4(String source){
			if(source == null || source.isEmpty()){
				return source;
			}       
			byte[] temp = source.getBytes();
			byte[] result = new byte [temp.length];

			for(int i = 0; i < temp.length; i++){
				result[i] = temp[temp.length-1-i];
			}
			String reverse = new String(result);
//			for(Character c: src){
//				 reverse = reverse + c;
//			}
//			直接用这句的话会输出[d, l, r, o, W, o, l, l, e, H] 			
//		    reverse = String.valueOf(result).toString();
			return reverse;
		}

	}
}
