package Stack;

import java.util.Stack;

/**
 * @author Mia Jia
 *
 */
public class ReversePolishNotation {   
    	/**
	 * @param exp
	 */
	public static String answer(String str) { 
		
		if( str.isEmpty()){
			return "";
		}
		
		
		String result = "";
		Stack<Character> S1 = new Stack<Character>();
		Stack<Character> S2 = new Stack<Character>();
		
		
		S2.push('#');
		for ( int i = 0; i < str.length(); i++ ){
			if( isDigit(str.charAt(i))){
				S1.push(str.charAt(i));
			} else{
				while( S2.peek() != '#' && S2.peek() == '*' && str.charAt(i) == '+' ){
					S1.push(S2.pop());
				}
				S2.push(str.charAt(i));
			}
		}
		while( S2.peek() != '#'){
			S1.push(S2.pop());
		}
		//pop '#' out of S2
		S2.pop();
		
		//reverse S1
		while( !S1.isEmpty()){
			S2.push(S1.pop());
		}

		while( !S2.isEmpty()){
			result += String.valueOf(S2.pop());
		}
		return result;
	}
	
	
	private static boolean isDigit(Character isNum) {
		return isNum.equals('0') || isNum.equals('1') || isNum.equals('2')
                || isNum.equals('3') || isNum.equals('4') || isNum.equals('5')
                || isNum.equals('6') || isNum.equals('7') || isNum.equals('8')
                || isNum.equals('9');
    }
	
	public static void main(String[] args) {

        String exp = "7+8*2";
        String rpnExp = ReversePolishNotation.answer(exp);
        System.out.println("Arithmetic expression：" + exp);
        System.out.println("Reverse Polish notation：" + rpnExp);
        
        exp = "2*4*3+9*3+5";
        rpnExp = ReversePolishNotation.answer(exp);
        System.out.println("Arithmetic expression：" + exp);
        System.out.println("Reverse Polish notation：" + rpnExp);
        
        exp = "";
        rpnExp = ReversePolishNotation.answer(exp);
        System.out.println("Arithmetic expression：" + exp);
        System.out.println("Reverse Polish notation：" + rpnExp);
        
        exp = "123124123";
        rpnExp = ReversePolishNotation.answer(exp);
        System.out.println("Arithmetic expression：" + exp);
        System.out.println("Reverse Polish notation：" + rpnExp);
        
        exp = "&*^*&";
        rpnExp = ReversePolishNotation.answer(exp);
        System.out.println("Arithmetic expression：" + exp);
        System.out.println("Reverse Polish notation：" + rpnExp);
 

    }
}
