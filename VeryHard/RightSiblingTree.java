import java.util.*;

class Program {
	// O(n) time | O(d) space
  public static BinaryTree rightSiblingTree(BinaryTree root) {
    // Write your code here.
		convertToRightSiblingTree(root, null, false);
    return root;
  }
	
	private static void convertToRightSiblingTree(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
		if (node == null) {
			return;
		}
		BinaryTree left = node.left;
		BinaryTree right = node.right;
		convertToRightSiblingTree(left, node, true);
		if (parent == null) {
			node.right = null;
		} else if (isLeftChild) {
			node.right = parent.right;
		} else {
			if (parent.right == null) {
				node.right = null;
			} else {
				node.right = parent.right.left;
			}
		}
		convertToRightSiblingTree(right, node, false);
	}

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
