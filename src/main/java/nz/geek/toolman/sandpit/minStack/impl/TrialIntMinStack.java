package nz.geek.toolman.sandpit.minStack.impl;

import java.util.Stack;

import nz.geek.toolman.sandpit.minStack.MinStack;

public class TrialIntMinStack extends Stack<Integer> implements MinStack<Integer> {

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
			System.out.print("           ");
		} else if (value < min) {
			System.out.print(" min " + min);
			pushVal = (2 * value) - min;

			min = value;
			System.out.print(" -> " + min);
		} else {
			System.out.print("           ");
		}
		System.out.println("  internal push is " + pushVal);
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
			min = (2 * min) - popVal; // min + popval = 2 * value : min = 2*val
										// - pop val

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
