package nz.geek.toolman.sandpit.minStack.impl;

import java.util.Stack;

import nz.geek.toolman.sandpit.minStack.MinStack;

/**
 * parlour trick to re-use stack for prevous min storage. trick only works with numbers.
 * 
 * @author toolman
 *
 */
public class IntMinStack extends Stack<Integer> implements MinStack<Integer> {

	private static final long serialVersionUID = 1L;
	private Integer min = null;

	@Override
	public Integer push(Integer value) {
		Integer pushVal = value;

		if (min == null) {
			min = value;
			
		} else if (value < min) {
			pushVal = value + value - min; // pushVal will *always* be < val (new min) here
			min = value;
		}

		return super.push(pushVal);
	}


	@Override
	public synchronized Integer pop() {
		Integer popVal = super.pop();
		Integer returnVal = popVal;

		if (popVal < min) {
			returnVal = min;
			min = min + min - popVal; //re-constitute old min
			
		} else if (this.size() == 0) {
			min = null;
		}

		return returnVal;
	}

	public Integer getMin() {
		return min;
	}
}
