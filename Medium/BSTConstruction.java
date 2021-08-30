import java.util.*;

class Program {
	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		// Average: O(log(n)) time | O(log(n)) space
		// Worst O(n) time | O(n) space
		public BST insert(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			if (value < this.value) {
				if (left == null) {
					BST newBST = new BST(value);
					left = newBST;
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					BST newBST = new BST(value);
					right = newBST;
				} else {
					right.insert(value);
				}
			}
			return this;
		}

		// Average: O(log(n)) time | O(log(n)) space
		// Worst O(n) time | O(n) space
		public boolean contains(int value) {
			// Write your code here.
			if (value < this.value) {
				if (left == null) {
					return false;
				} else {
					return left.contains(value);
				}
			} else if (value > this.value) {
				if (right == null) {
					return false;
				} else {
					return right.contains(value);
				}
			} else {
				return true;
			}
		}

		// Average: O(log(n)) time | O(log(n)) space
		// Worst O(n) time | O(n) space
		public BST remove(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			remove(value, null);
			return this;
		}

		private void remove(int value, BST parent) {
			if (value < this.value) {
				if (left != null) {
					left.remove(value, this);
				}
			} else if (value > this.value) {
				if (right != null) {
					right.remove(value, this);
				}
			} else {
				if (left != null && right != null) {
					this.value = right.getMinValue();
					right.remove(this.value, this);
				} else if (parent == null) {
					if (left != null) {
						this.value = left.value;
						right = left.right;
						left = left.left;
					} else if (right != null) {
						this.value = right.value;
						left = right.left;
						right = right.right;
					} else {
						// do nothing
					}
				} else if (parent.left == this) {
					parent.left = left != null ? left : right;
				} else if (parent.right == this) {
					parent.right = left != null ? left : right;
				}
			}
		}

		private int getMinValue() {
			if (left == null) {
				return this.value;
			} else {
				return left.getMinValue();
			}
		}
	}
}
