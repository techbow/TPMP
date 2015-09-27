
public class Calculator {
	public String getAnwer(int lineCount) {

		//	        if (lineCount < 1) {
		//	            throw new IllegalArgumentException("行数不能小于1!");
		//	        }
		//	        if (lineCount > 20) {
		//	            throw new IllegalArgumentException("行数不能大于20!");
		//	        }

		// TODO 
		return null;
	}

}
private boolean isDigit( String s )
{
	boolean b;
	b = s.equals("0")||s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")
			||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8")||s.equals("9");
	return b;
}
private boolean isOperator(String s)
{
	return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/") ||s.equals("^")||s.equals("sqrt")||
		   s.equals("sin")||s.equals("cos")||s.equals("tan")||
		   s.equals("n!")||s.equals("(")||s.equals(")");
}
}