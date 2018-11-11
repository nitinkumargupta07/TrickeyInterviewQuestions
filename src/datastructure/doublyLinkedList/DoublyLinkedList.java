package datastructure.doublyLinkedList;

public class DoublyLinkedList {
	Node head, tail, sorted;
	int size;

	private static class Node {
		Node next, prev;
		int data;

		public Node(int data) {
			this.data = data;
			next = prev = null;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtFirst(40);
		list.addAtFirst(30);
		list.addAtFirst(20);
		list.addAtFirst(10);
		list.printALL();
		list.printALLReverseOrder();
		list.addAtLast(50);
		list.addAtLast(60);
		list.addAtLast(70);
		list.addAtLast(80);
		list.printALL();
		list.printALLReverseOrder();
		list.addAtNthPosition(5, 55);
		list.addAtNthPosition(6, 66);
		list.addAtNthPosition(10, 77);
		list.addAtNthPosition(12, 27);
		list.addAtLast(50);
		list.addAtLast(60);
		list.addAtNthPosition(13, 77);
		list.addAtNthPosition(11, 27);
		list.printALL();
		list.printALLReverseOrder();
		/*
		 * list.removeAtFirst(); list.printALL(); list.printALLReverseOrder();
		 * list.removeAtLast(); list.printALL(); list.printALLReverseOrder();
		 * list.removeAtPosition(3); list.printALLReverseOrder();
		 * list.removeAtPositionUp1(7); list.printALL(); list.printALLReverseOrder();
		 */
		/*
		 * Node node=list.printNthNodeFromLast(7); System.out.println("\n "+ node.data);
		 */
		/*
		 * list.removeNthNodeFromLast(7); list.printALL(); list.printALLReverseOrder();
		 */
		/*
		 * Node node = list.printNthNodeFromLastUp1(7); System.out.println("\n " +
		 * node.data);
		 */
		// list.reverse();
		/// list.deleteNode(70);
		//// list.removeDuplicate();
		//// list.deleteNodeUp1(list.head.next.next.next);
		// list.insertionSort();
		Node node3 = list.mergeSort(list.head);
		list.printAll12(node3);

	}

	private void printAll12(Node node3) {
		// TODO Auto-generated method stub
		Node tmp = node3;
		System.out.println();
		while (true) {
			if (tmp == null)
				return;
			else {
				System.out.print("  " + tmp.data);
				tmp = tmp.next;
			}
		}

	}

	// Split a doubly linked list (DLL) into 2 DLLs of
	// half sizes
	Node split(Node head) {
		Node fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}

	Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node second = split(node);

		// Recur for left and right halves
		node = mergeSort(node);
		second = mergeSort(second);

		// Merge the two sorted halves
		return merge(node, second);
	}

	// Function to merge two linked lists
	Node merge(Node first, Node second) {
		// If first linked list is empty
		if (first == null) {
			return second;
		}

		// If second linked list is empty
		if (second == null) {
			return first;
		}

		// Pick the smaller value
		if (first.data < second.data) {
			first.next = merge(first.next, second);
			first.next.prev = first;
			first.prev = null;
			return first;
		} else {
			second.next = merge(first, second.next);
			second.next.prev = second;
			second.prev = null;
			return second;
		}
	}

	public void insertionSort() {

		Node current = head;
		while (current != null) {
			Node next = current.next;
			sortedInsert(current);
			current = next;
		}
		// Update head_ref to point to sorted linked list
		head = sorted;
	}

	void sortedInsert(Node newnode) {
		/* Special case for the head end */
		if (sorted == null || sorted.data >= newnode.data) {
			newnode.next = sorted;
			sorted = newnode;
		} else {
			Node current = sorted;
			/* Locate the node before the point of insertion */
			while (current.next != null && current.next.data < newnode.data) {
				current = current.next;
			}
			newnode.next = current.next;
			current.next = newnode;
		}
	}

	private void deleteNodeUp1(Node node) {

		if (node == null || node.next == null) {
			return; // Failure
		}
		Node nextNode = node.next;
		Node prevNode = node.prev;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		size--;
		return;

	}

	private void removeDuplicate() {
		if (head == null)
			return;
		Node tmp = head;
		while (tmp != null) {
			Node current = tmp;
			while (current != null && current.next != null) {
				if (tmp.data == current.next.data) {
					Node nextNode = tmp.next;
					Node prevNode = tmp.prev;
					prevNode.next = nextNode;
					nextNode.prev = prevNode;
					size--;
					break;
				}
				current = current.next;
			}
			tmp = tmp.next;
		}

	}

	private void deleteNode(int data) {
		if (head == null)
			return;
		Node tmp = head;
		while (true) {
			if (data == tmp.data) {
				Node nextNode = tmp.next;
				Node prevNode = tmp.prev;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				size--;
				return;
			}
			tmp = tmp.next;
		}
	}

	private void reverse() {
		if (head == null)
			return;
		Node tmp = null;
		Node current = head;
		while (current != null) {
			tmp = current.prev;
			current.prev = current.next;
			current.next = tmp;
			current = current.prev;
		}
		if (tmp != null) {
			head = tmp.prev;
		}
	}

	public Node reverseUp1(Node node) {
		node.prev = node.next;
		node.next = node.prev;

		return node;
	} // end reverse

	private void removeNthNodeFromLast(int position) {
		if (head == null)
			return;
		Node tmp = tail;
		for (int j = 1; j <= position; j++) {
			System.out.println(j);
			if (position == j) {
				Node nextNode = tmp.next;
				Node prevNode = tmp.prev;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				size--;
				return;
			} else {
				if (tmp == null)
					return;
				tmp = tmp.prev;
			}
		}
	}

	private Node printNthNodeFromLastUp1(int position) {
		int length = 0;
		if (head == null)
			return null;

		Node tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		Node s = head;
		for (int i = 1; i <= length - position; i++) {
			s = s.next;
		}
		return s;
	}

	private Node printNthNodeFromLast(int position) {
		if (head == null)
			return null;
		Node tmp = tail;
		for (int j = 1; j < position; j++) {
			if (tmp == null)
				return null;
			tmp = tmp.prev;
		}
		return tmp;
	}

	private void removeAtPositionUp1(int position) {
		Node tmp = head;
		for (int i = 1; i <= size; i++) {
			if (position == i) {
				Node nextNode = tmp.next;
				Node prevNode = tmp.prev;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				size--;
				return;
			} else {
				tmp = tmp.next;
			}
		}
	}

	private void removeAtPosition(int position) {
		if (position == 1)
			removeAtFirst();
		else if (position == size)
			removeAtLast();
		else {
			Node tmp = head;
			for (int i = 1; i < size; i++) {
				if (position == i) {
					Node nextNode = tmp.next;
					Node prevNode = tmp.prev;
					prevNode.next = nextNode;
					nextNode.prev = prevNode;
					size--;
					return;
				} else {
					tmp = tmp.next;
				}
			}
		}
	}

	private void removeAtLast() {
		if (head == null)
			return;
		Node tmp = tail.prev;
		tmp.next = null;
		tail = tmp;
		size--;
	}

	private void removeAtFirst() {
		if (head == null)
			return;
		Node tmp = head.next;
		tmp.prev = null;
		head = tmp;
		size--;
	}

	private void addAtNthPosition(int position, int data) {
		Node node = new Node(data);
		if (position == 1)
			addAtFirst(data);
		else if (position == size + 1)
			addAtLast(data);
		else {
			Node tmp = head;
			int pos = position - 1;
			for (int i = 1; i <= size; i++) {
				if (i == pos) {
					Node ptr = tmp.next;
					tmp.next = node;
					node.prev = tmp;
					node.next = ptr;
					ptr.prev = node;
					size++;
					return;
				}
				tmp = tmp.next;
			}
		}
	}

	private void addAtLast(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			Node tmp = tail;
			tmp.next = node;
			node.prev = tmp;
			tail = node;
		}
		size++;
	}

	private void printALLReverseOrder() {
		Node tmp = tail;
		System.out.println();
		while (true) {
			if (tmp == null)
				return;
			System.out.print("  " + tmp.data);
			tmp = tmp.prev;
		}
	}

	private void printALL() {
		Node tmp = head;
		System.out.println();
		while (true) {
			if (tmp == null)
				return;
			System.out.print("  " + tmp.data);
			tmp = tmp.next;
		}
	}

	private void addAtFirst(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			Node tmp = head;
			node.next = tmp;
			tmp.prev = node;
			head = node;
		}
		size++;
	}

}
