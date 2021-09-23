public class HashMapImpl<T> {
	public static class Node<T> {
		private T data;
		private Node<T> next;

		public Node() {
			this.data = null;
			this.next = null;
		}

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T>[] buckets;
	private int size;

	public HashMapImpl() {
		this.size = 8;
		this.buckets = new Node<T>[size];
	}
	
	public HashMapImpl(int size) {
		this.size = size;
		this.buckets = new Node<T>[this.size];
	}
}