package other.LambdaExpression;

@FunctionalInterface
public interface Operation<T> {
	void sum(T value1, T value2);
}
