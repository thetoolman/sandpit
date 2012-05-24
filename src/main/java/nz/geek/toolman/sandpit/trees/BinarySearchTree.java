package nz.geek.toolman.sandpit.trees;

public class BinarySearchTree<S extends Comparable<S>> {

	private BinaryTreeNode<S> root = null;

	public void add(S item) {
		root = add(item, root);

	}

	private BinaryTreeNode<S> add(S item, BinaryTreeNode<S> node) {
		if (node == null) {
			node = new BinaryTreeNode<S>();
			node.setValue(item);

		} else {

			int compareTo = node.getValue().compareTo(item);
			if (compareTo == 0) {// ignore, already inserted

			} else if (compareTo > 0) { // smaller -> left
				node.setLeft(add(item, node.getLeft()));

			} else { // larger -> right
				node.setRight(add(item, node.getRight()));
			}
		}
		return node;
	}

	public void remove(S item) {
		root = remove(item, root);

	}

	private BinaryTreeNode<S> remove(S item, BinaryTreeNode<S> node) {
		if (node == null) {
			return node;
		}
		S value = node.getValue();
		int compareTo = value.compareTo(item);
		BinaryTreeNode<S> left = node.getLeft();
		BinaryTreeNode<S> right = node.getRight();

		if (compareTo == 0) { // found item to remove
			if (left == null && right == null) { // just remove node
				return null;

			} else if (right == null) {
				return left;

			} else if (left == null) {
				return right;

			} else { // both child nodes exist, re-link leftmost and promote right
				BinaryTreeNode<S> leftMost = right;
				while (leftMost.getLeft() != null) {
					leftMost = leftMost.getLeft();
				}
				leftMost.setLeft(left);
				return right;

			}

		} else if (compareTo > 0) { // smaller -> left
			node.setLeft(remove(item, node.getLeft()));

		} else { // larger -> right
			node.setRight(remove(item, node.getRight()));

		}
		return node; // no change at parent
	}

	public int size() {

		return size(root);
	}

	private int size(BinaryTreeNode<S> node) {
		if (node == null)
			return 0;

		int size = 1; // this node
		size += size(node.getLeft());
		size += size(node.getRight());

		return size;
	}

	public void printInOrder() {
		printInOrder(root);
		System.out.println("\n---------\n");
	}

	private void printInOrder(BinaryTreeNode<S> node) {
		if (node == null)
			return;

		printInOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		printInOrder(node.getRight());

	}

	/****/

	private class BinaryTreeNode<T> {

		BinaryTreeNode<T> left;
		T value;
		BinaryTreeNode<T> right;

		public BinaryTreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(BinaryTreeNode<T> left) {
			this.left = left;
		}

		public BinaryTreeNode<T> getRight() {
			return right;
		}

		public void setRight(BinaryTreeNode<T> right) {
			this.right = right;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}
	}

}
