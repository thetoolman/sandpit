package nz.geek.toolman.sandpit.minStack.impl;

import java.util.Stack;

import nz.geek.toolman.sandpit.minStack.MinStack;

public class IntMinStack extends Stack<Integer> implements MinStack<Integer> {

	private static final long serialVersionUID = 1L;
	private Integer min = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see impl.MinStackInterface#push(java.lang.Integer)
	 */
	@Override
	public Integer push(Integer value) {
		Integer pushVal = value;

		System.out.print("push: external push was " + value);
		if (min == null) {
			min = value;
		} else if (value < min) {
			System.out.print(" switch! ");
			pushVal = value + value - min;
			min = value;
		} else {
			System.out.print("         ");
		}
		System.out.println(" min is " + min + " internal push is " + pushVal);
		return super.push(pushVal);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see impl.MinStackInterface#pop()
	 */
	@Override
	public synchronized Integer pop() {
		Integer popVal = super.pop();
		Integer returnVal = popVal;

		System.out.print("pop: internal pop was " + popVal + " min was " + min);
		if (popVal < min) {
			returnVal = min;
			min = min + min - popVal;
		} else if (this.size() == 0) {
			min = null;
		}
		System.out.println(" new min is " + min + " external pop is " + returnVal);

		return returnVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see impl.MinStackInterface#getMin()
	 */
	public Integer getMin() {
		return min;
	}
}
