import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			count = 1;
			int num = isPalindrome(str);
			System.out.print(num +" ");
			System.out.println(count);
		}
	}

	private static int isPalindrome(String str) {
		return recursion(str, 0, str.length() - 1);
	}

	private static int recursion(String str, int i, int j) {
		if(i >= j) {
			return 1;
		}
		else if(str.charAt(i) != str.charAt(j)) {
			return 0;
		}
		else {
			count++;
			return recursion(str, i + 1, j - 1);
		}
	}
}