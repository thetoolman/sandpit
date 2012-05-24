package nz.geek.toolman.sandpit.minStack;


public interface MinStack<T> {

	public abstract T pop();

	public abstract T push(T value);

	public abstract T getMin();

}