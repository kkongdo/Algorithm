import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			System.out.println(vps(br.readLine()));
		}

	}

	private static String vps(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				stack.push(ch);
			}
			else if(stack.empty()) {
				return "NO";
			}
			else {
				stack.pop();
			}
		}
		
		if(stack.empty()) {
			return ("YES");
		}else {
			return "NO";
		}
	}
}