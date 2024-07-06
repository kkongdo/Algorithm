import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputString = br.readLine();
		String inputBomb = br.readLine();

		System.out.println(stringExplosion(inputString, inputBomb));
	}

	private static String stringExplosion(String inputString, String inputBomb) {
		Stack<Character> stack = new Stack<Character>();
		int inputBombLength = inputBomb.length();

		for (char ch : inputString.toCharArray()) {
			stack.push(ch);
			if (stack.size() >= inputBombLength) {
				boolean isBomb = true;
				for (int i = 0; i < inputBombLength; i++) {
					if (stack.get(stack.size() - inputBombLength + i) != inputBomb.charAt(i)) {
						isBomb = false;
						break;
					}
				}
				if (isBomb) {
					for (int i = 0; i < inputBombLength; i++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : stack) {
			sb.append(ch);
		}
		return sb.length() > 0 ? sb.toString() : "FRULA";
	}
}
