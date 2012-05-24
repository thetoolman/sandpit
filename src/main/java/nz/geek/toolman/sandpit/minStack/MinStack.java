package nz.geek.toolman.sandpit.minStack;


/** 
 * Simple stack interface with support for finding minimal in stack
 * 
 * @author toolman
 *
 * @param <T>
 */
public interface MinStack<T> {

	public abstract T peek();
	
	public abstract T pop();

	public abstract T push(T value);

	public abstract T getMin();

}