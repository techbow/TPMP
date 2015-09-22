package Basic;

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

			//quick way to reverse String in Java - Use StringBuffer
			String word = "HelloWorld";
			String reverse = new StringBuffer(word).reverse().toString();
			System.out.printf(" original String : %s , reversed String %s  %n", word, reverse);

			//another quick to reverse String in Java - use StringBuilder
			word = "WakeUp";
			reverse = new StringBuilder(word).reverse().toString();
			System.out.printf(" original String : %s , reversed String %s %n", word, reverse);

			//one way to reverse String without using StringBuffer or StringBuilder is writing
			//own utility method
			word = "Band";
			reverse = reverse(word);
			System.out.printf(" original String : %s , reversed String %s %n", word, reverse);
		}   


		public static String reverse(String source){
			if(source == null || source.isEmpty()){
				return source;
			}       
			String reverse = "";
			for(int i = source.length() -1; i>=0; i--){
				reverse = reverse + source.charAt(i);
			}

			return reverse;
		}

	}
}
