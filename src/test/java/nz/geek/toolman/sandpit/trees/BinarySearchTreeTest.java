package nz.geek.toolman.sandpit.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void add() {
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();

		assertEquals("nothin in there yet", 0, myTree.size());

		myTree.add(5);
		assertEquals("one item", 1, myTree.size());

		myTree.add(3);
		assertEquals("two items", 2, myTree.size());

	}

	@Test
	public void removal() {
		BinarySearchTree<Integer> myTree = perfect3Tier();

		assertEquals("15 items in perfect 3 tier tree", 15, myTree.size());

		// remove non-existant
		myTree.remove(0);
		myTree.printInOrder();
		assertEquals("samesame", 15, myTree.size());

		// remove left-most leaf
		myTree.remove(1);
		myTree.printInOrder();
		assertEquals("one item", 14, myTree.size());

		// remove right-most leaf
		myTree.remove(15);
		myTree.printInOrder();
		assertEquals("one item", 13, myTree.size());

		// remove item with only left child
		myTree.remove(14);
		myTree.printInOrder();
		assertEquals("one item", 12, myTree.size());

		// remove item with only right child
		myTree.remove(2);
		myTree.printInOrder();
		assertEquals("one item", 11, myTree.size());

		// remove root
		myTree.remove(8);
		myTree.printInOrder();
		assertEquals("one item", 10, myTree.size());
	}

	private BinarySearchTree<Integer> perfect3Tier() {
		BinarySearchTree<Integer> myTree;

		// build perfect 3 tier tree
		myTree = new BinarySearchTree<Integer>();
		// 0
		myTree.add(8);
		// 1
		myTree.add(4);
		myTree.add(12);
		// 2
		myTree.add(2);
		myTree.add(6);

		myTree.add(10);
		myTree.add(14);
		// 3
		myTree.add(1);
		myTree.add(3);

		myTree.add(5);
		myTree.add(7);

		myTree.add(9);
		myTree.add(11);

		myTree.add(13);
		myTree.add(15);
		return myTree;
	}

	@Test
	public void print() {
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
		myTree.add(5);
		myTree.add(3);
		myTree.add(1);
		myTree.add(7);
		myTree.add(9);

		myTree.printInOrder();

	}
}
