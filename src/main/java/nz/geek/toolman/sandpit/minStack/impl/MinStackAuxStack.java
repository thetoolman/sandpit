package nz.geek.toolman.sandpit.minStack.impl;

import java.util.Stack;

import nz.geek.toolman.sandpit.minStack.MinStack;

/**
 * Keep an auxillery stack of the same depth, but with the current minimum on top. O(1) lookup of min :)
 * 
 * @author toolman
 *
 * @param <T>
 */
public class MinStackAuxStack<T extends Comparable<T>> extends Stack<T> implements MinStack<T> {

	Stack<T> auxMinStack = new Stack<T>();

	@Override
	public synchronized T pop() {
		T pop = super.pop();
		auxMinStack.pop(); // discard old min

		return pop;
	}

	@Override
	public T push(T item) {
		T newMin = (auxMinStack.size() == 0 || item.compareTo(auxMinStack.peek()) < 0) ? item : auxMinStack.peek();
		auxMinStack.push(newMin);

		return super.push(item);
	}

	public T getMin() {
		if (auxMinStack.size() == 0)
			return null;
		return auxMinStack.peek();
	}
}
