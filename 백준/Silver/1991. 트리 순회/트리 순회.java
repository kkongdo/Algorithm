import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Node node = new Node('A', null, null);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			insertNode(node, root, left, right);
		}
		preOrder(node);
		System.out.println();
		inOrder(node);
		System.out.println();
		postOrder(node);
		
	}

	private static void postOrder(Node node2) {
		if(node2 == null) {
			return;
		}
		postOrder(node2.left);
		postOrder(node2.right);
		System.out.print(node2.value);
	}

	private static void inOrder(Node node2) {
		if(node2 == null) {
			return;
		}
		inOrder(node2.left);
		System.out.print(node2.value);
		inOrder(node2.right);
	}

	private static void preOrder(Node node2) {
		if(node2 == null) { // 더이상 값이 없으면
			return;
		}
		System.out.print(node2.value);
		preOrder(node2.left);
		preOrder(node2.right);
	}

	private static void insertNode(Node tmpNode, char root, char left, char right) {
		if (tmpNode.value == root) {
			tmpNode.left = left == '.' ? null : new Node(left, null, null);
			tmpNode.right = right == '.' ? null : new Node(right, null, null);
		} else {
			if (tmpNode.left != null) {
				insertNode(tmpNode.left, root, left, right);
			}
			if (tmpNode.right != null) {
				insertNode(tmpNode.right, root, left, right);
			}
		}

	}

	public static class Node {
		char value;
		Node left;
		Node right;

		public Node(char value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

}