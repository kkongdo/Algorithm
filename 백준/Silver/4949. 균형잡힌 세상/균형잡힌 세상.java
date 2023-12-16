import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while (true) {
			str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			sb.append(vps(str)).append("\n");
		}
		System.out.println(sb);
	}

	private static String vps(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(' || c == '[') {
				stack.push(c);
			}

			else if (c == ')') {

				if (stack.empty() || stack.peek() != '(') {
					return "no";
				} else {
					stack.pop();
				}
			}

			else if (c == ']') {

				if (stack.empty() || stack.peek() != '[') {
					return "no";
				} else {
					stack.pop();
				}
			}

		}

		if (stack.empty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}