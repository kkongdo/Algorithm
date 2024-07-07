import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<String>();

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("push")) {
				stack.push(st.nextToken());
			} else {
				switch (input) {
				case "pop":
					try {
						sb.append(stack.pop()).append("\n");
					} catch (EmptyStackException e) {
						sb.append("-1").append("\n");
					}
					break;
				case "top":
					try {
						sb.append(stack.peek()).append("\n");
					} catch (EmptyStackException e) {
						sb.append("-1").append("\n");
					}
					break;
				case "empty":
					if (stack.isEmpty()) {
						sb.append(1 + "\n");
					} else {
						sb.append(0 + "\n");
					}
					break;
				case "size":
					sb.append(stack.size() + "\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}