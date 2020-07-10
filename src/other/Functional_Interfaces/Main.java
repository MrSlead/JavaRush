package other.Functional_Interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

	public static void main(String[] args) {
		Predicate<Double> isNegativeDouble = d -> d < 0;
		System.out.println(isNegativeDouble.test(-43.2));
		
		BinaryOperator<Integer> sum = (i1, i2) -> (i1 + i2);
		System.out.println(sum.apply(4, 32));
		
		UnaryOperator<String> doubleStroke = stroke -> stroke + stroke;
		System.out.println(doubleStroke.apply("World"));
		
		Function<String, Integer> toInteger = (s) -> (Integer.parseInt(s));
		System.out.println(toInteger.apply("-1000"));
		
		Consumer<Integer> square = i -> System.out.println(i*i);
		square.accept(23);
		
		Supplier<User> useFactory = () -> {
			String name = null;
			try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
				name = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return new User(name);
		};
		
		User user = useFactory.get();
		System.out.println(user);
	}
	
	public static class User {
		private String name;
		
		public User(String name) {
			this.name = name != null ? name : "default";
		}
		
		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "User [name=" + name + "]";
		}
		
	}

}
