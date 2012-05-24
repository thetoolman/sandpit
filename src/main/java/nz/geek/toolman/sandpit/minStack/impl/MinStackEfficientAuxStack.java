package nz.geek.toolman.sandpit.minStack.impl;

import java.util.Stack;

import nz.geek.toolman.sandpit.minStack.MinStack;

public class MinStackEfficientAuxStack<T extends Comparable<T>> extends Stack<T> implements MinStack<T> {

	Stack<T> auxMinStack = new Stack<T>();

	@Override
	public synchronized T pop() {
		T pop = super.pop();
		if ((auxMinStack.size() != 0) && pop.compareTo(auxMinStack.peek()) == 0) {
			auxMinStack.pop();
		}

		return pop;
	}

	@Override
	public T push(T item) {
		// push equal items so that multiple equal minimums are stored, and
		// simple equality removal works
		if ((auxMinStack.size() == 0) || item.compareTo(auxMinStack.peek()) <= 0) {
			auxMinStack.push(item);
		}

		return super.push(item);
	}

	public T getMin() {
		if (auxMinStack.size() == 0)
			return null;
		return auxMinStack.peek();
	}
}
