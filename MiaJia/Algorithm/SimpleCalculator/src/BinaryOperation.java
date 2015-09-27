public interface BinaryOperation {
	public double resultFor(double left, double right);
}



class Addition implements BinaryOperation {
	public double resultFor(double left, double right) {
		return left + right;
	}
}


class Subtraction implements BinaryOperation {
	public double resultFor(double left, double right) {
		return left - right;
	}
}

class Multiplication implements BinaryOperation {
	public double resultFor(double left, double right) {
		return left * right;
	}
}

class Division implements BinaryOperation {
	public double resultFor(double left, double right) {
		return left / right;
	}
}


private Map<Character, BinaryOperation> operations;



BinaryOperation op = operations.get(operator);
if (op != null) {
	answer = op.resultFor(inputA, inputB);
}
else {
	System.out.println("Error: Unknown operator");
	]