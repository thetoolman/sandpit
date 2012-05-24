package nz.geek.toolman.sandpit.minStack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import nz.geek.toolman.sandpit.minStack.impl.IntMinStack;
import nz.geek.toolman.sandpit.minStack.impl.MinStackAuxStack;
import nz.geek.toolman.sandpit.minStack.impl.MinStackEfficientAuxStack;

import org.junit.Test;

public class TestMinStackTest {

	private static final int DATA = 0;
	private static final int EXPECTED_MIN = 1;

	@Test
	public void intMinStack() {
		testMinStack(new IntMinStack());
	}

	@Test
	public void minStackAuxStack() {
		testMinStack(new MinStackAuxStack<Integer>());
	}

	@Test
	public void minStackEfficientAuxStack() {
		testMinStack(new MinStackEfficientAuxStack<Integer>());
	}

	public void testMinStack(MinStack<Integer> stack) {

		//push val, expected min
		Integer[][] data = { { 4, 4 }, { 3, 3 }, { 3, 3 }, {5, 3}, { 3, 3 }, { 2, 2 }, { 0, 0 }, { 0, 0 }, { -2, -2 } };

		assertNull(stack.getMin());

		// push all
		for (int i = 0; i < data.length; i++) {
			stack.push(data[i][DATA]);
			assertEquals(data[i][EXPECTED_MIN], stack.getMin());
		}

		// pop all
		for (int i = data.length - 1; i >= 0; --i) {
			assertEquals(data[i][EXPECTED_MIN], stack.getMin());
			assertEquals(data[i][DATA], stack.pop());
		}

		assertNull(stack.getMin());
	}
}
