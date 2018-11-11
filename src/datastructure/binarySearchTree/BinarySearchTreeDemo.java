package datastructure.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeDemo {
	protected Node root, sorted;

	static class Node {
		Node left, right;
		int data;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		BinarySearchTreeDemo demo = new BinarySearchTreeDemo();
		demo.add(20);
		demo.add(91);
		demo.add(8);
		demo.add(17);
		demo.add(61);
		demo.add(5);
		demo.add(41);
		demo.add(13);
		demo.add(21);
		demo.add(14);
		demo.add(11);
		demo.add(10);
		demo.add(10);
		demo.add(5);
		demo.add(8);
		demo.add(7);
		demo.add(6);
		demo.add(5);
		demo.add(4);
		demo.add(3);
		demo.add(2);
		demo.add(1);
		demo.add(11);
		demo.add(10);
		System.out.println();
		demo.traverseInOrder(demo.root);
		System.out.println();
		demo.traversePreOrder(demo.root);
		System.out.println();
		demo.traversePostOrder(demo.root);
		System.out.println();
		demo.levelOrderTraverse(demo.root);
		int height = demo.height(demo.root);
		System.out.println("\n" + height);
		System.out.println();
		demo.printLeafNodes(demo.root);
		int count = demo.countNodes(demo.root);
		System.out.println(" \n" + count);
		boolean flag = demo.searchNode(demo.root, 21);
		System.out.println(" \n" + flag);
		demo.delete(21);
		demo.delete(1);
		demo.delete(2);
		System.out.println();
		demo.traverseInOrder(demo.root);
		System.out.println();
		demo.traverseZigZag(demo.root);

	}

	private void traverseZigZag(Node node) {
		if (node == null)
			return;
		// declare two stacks
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();

		// push the root
		currentLevel.push(node);
		boolean leftToRight = true;
		while (!currentLevel.isEmpty()) {
			// pop out of stack
			Node tmp = currentLevel.pop();

			// print the data in it
			System.out.print(tmp.data + "  ");

			// store data according to current
			// order.
			if (leftToRight) {
				if (tmp.left != null) {
					nextLevel.push(tmp.left);
				}

				if (tmp.right != null) {
					nextLevel.push(tmp.right);
				}
			} else {
				if (tmp.right != null) {
					nextLevel.push(tmp.right);
				}

				if (tmp.left != null) {
					nextLevel.push(tmp.left);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}

	}

	private int findSmallestValue(Node root) {
		return root.left == null ? root.data : findSmallestValue(root.left);
	}

	private int findLargestValue(Node root) {
		return root.right == null ? root.data : findLargestValue(root.right);
	}

	int maxValue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.right != null) {
			current = current.right;
		}
		return (current.data);
	}

	int minvalue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current.data);
	}

	

	public void delete(int data) {
		root = deleteRecursive(root, data);
	}

	private Node deleteRecursive(Node current, int data) {
		if (current == null) {
			return null;
		}

		if (data == current.data) {
			if (current.left == null && current.right == null) {
				return null;
			}
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}
		}
		if (data < current.data) {
			current.left = deleteRecursive(current.left, data);
			return current;
		} else {
			current.right = deleteRecursive(current.right, data);
			return current;
		}
	}

	private boolean searchNode(Node node, int key) {
		if (node == null)
			return false;
		if (key == node.data) {
			return true;
		}
		return key < node.data ? searchNode(node.left, key) : searchNode(node.right, key);
	}

	private int countNodes(Node r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}

	private void printLeafNodes(Node node) {
		// base case
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			System.out.printf("%d ", node.data);
		}
		printLeafNodes(node.left);
		printLeafNodes(node.right);
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		/* use the larger one */
		if (lheight > rheight)
			return (lheight + 1);
		else
			return (rheight + 1);
	}

	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int minDepth(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static boolean isBalanced(Node root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	private void levelOrderTraverse(Node node) {
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(node);
		while (!nodes.isEmpty()) {
			Node node1 = nodes.remove();
			System.out.print("  " + node1.data);
			if (node1.left != null) {
				nodes.add(node1.left);
			}
			if (node1.right != null) {
				nodes.add(node1.right);
			}
		}

	}

	// Left -right -root
	private void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print("  " + node.data);
		}
	}

	// root -left-right
	private void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print("  " + node.data);
			traverseInOrder(node.left);
			traverseInOrder(node.right);
		}
	}

	// left-root-right.
	private void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print("  " + node.data);
			traverseInOrder(node.right);
		}
	}

	private void add(int data) {
		root = addResursive(root, data);
	}

	private Node addResursive(Node current, int data) {
		if (current == null)
			return new Node(data);
		if (data < current.data)
			current.left = addResursive(current.left, data);
		else if (data > current.data)
			current.right = addResursive(current.right, data);
		else
			return current;
		return current;
	}

	Node mirror(Node node) {
		if (node == null)
			return node;

		/* do the subtrees */
		Node left = mirror(node.left);
		Node right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	// Write Code to Determine if Two Trees are Identical
	/*
	 * Given two trees, return true if they are structurally identical
	 */
	boolean identicalTrees(Node a, Node b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty -> compare them */
		if (a != null && b != null)
			return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));

		/* 3. one empty, one not -> false */
		return false;
	}

	boolean isFoldable(Node node) {
		boolean res;

		/* base case */
		if (node == null)
			return true;

		/* convert left subtree to its mirror */
		mirror(node.left);

		/*
		 * Compare the structures of the right subtree and mirrored left subtree
		 */
		res = isStructSame(node.left, node.right);

		/* Get the originial tree back */
		mirror(node.left);

		return res;
	}

	boolean isStructSame(Node a, Node b) {
		if (a == null && b == null)
			return true;
		if (a != null && b != null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right))
			return true;

		return false;
	}

	// Iterative
	private void addIterative(int value) {
		Node current = root;
		Node node = new Node(value);
		Node present = null;
		if (root == null) {
			root = node;
		} else {
			while (current != null) {
				present = current;
				if (value < current.data) {
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if (value < present.data) {
				present.left = node;
			} else {
				present.right = node;
			}
		}
	}

	public void inOrderWithoutRecursion() {
		Stack<Node> nodes = new Stack<>();
		Node current = root;
		while (!nodes.isEmpty() || current != null) {
			if (current != null) {
				nodes.push(current);
				current = current.left;
			} else {
				Node node = nodes.pop();
				System.out.printf("%s ", node.data);
				current = node.right;
			}
		}
	}

	private boolean iterativeSearch(int value) {
		// Traverse untill root reaches to dead end
		while (root != null) { // pass right subtree as new tree
			if (value > root.data)
				root = root.right;
			// pass left subtree as new tree
			else if (value < root.data)
				root = root.left;
			else
				return true;// if the key is found return 1
		}
		return false;
	}
}
