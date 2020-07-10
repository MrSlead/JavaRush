package other.LambdaExpression;

public class Main {
	public static void main(String [] args) {
		DividedBy13 object = new DividedBy13() {		
			@Override
			public boolean dividedBy13(int number) {
				return number % 13 == 0;
			}
		};
		
		System.out.println(object.dividedBy13(26));
		
		
		DividedBy13 lambda = x -> x % 13 == 0;
		System.out.println(lambda.dividedBy13(26));
		
		DoubleStroke doubleStroke = stroke -> System.out.println(stroke + " " + stroke);
		doubleStroke.copy("Hello");
		
		
		Operation<Integer> operation = (val1, val2) -> System.out.println(val1 + val2);
		operation.sum(4, 5);
		
		Operation<String> operation2 = (val1, val2) -> System.out.println(val1 + val2);
		operation2.sum("4", "5");
	}
}
