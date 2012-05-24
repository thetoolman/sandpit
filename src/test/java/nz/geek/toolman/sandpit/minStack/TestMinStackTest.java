package nz.geek.toolman.sandpit.minStack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import nz.geek.toolman.sandpit.minStack.impl.IntMinStack;
import nz.geek.toolman.sandpit.minStack.impl.MinStackAuxStack;
import nz.geek.toolman.sandpit.minStack.impl.TrialIntMinStack;

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
	public void trialIntMinStack() {
		testMinStack(new TrialIntMinStack());
	}

	public void testMinStack(MinStack<Integer> stack) {

		Integer[][] data = { { 4, 4 }, { 3, 3 }, { 3, 3 }, { 3, 3 }, { 2, 2 }, { 0, 0 }, { 0, 0 }, { -2, -2 } };

		assertNull(stack.getMin());

		for (int i = 0; i < data.length; i++) {
			// System.out.println("push: " + data[i][DATA] +
			// ", expected minimum " + data[i][EXPECTED_MIN]);
			stack.push(data[i][DATA]);
			assertEquals(data[i][EXPECTED_MIN], stack.getMin());
		}

		for (int i = data.length - 1; i >= 0; --i) {
			assertEquals(data[i][EXPECTED_MIN], stack.getMin());
			assertEquals(data[i][DATA], stack.pop());
			// System.out.println("pop: old minimum " + data[i][EXPECTED_MIN]
			// +", pop value " + data[i][DATA] );
		}

		assertNull(stack.getMin());
	}
}
