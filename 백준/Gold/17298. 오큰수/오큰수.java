import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] result = NGE(N, nums);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(result[i]).append(' ');
		}
		System.out.println(sb.toString().trim());
	}

	private static int[] NGE(int n, int[] nums) {
		int[] nge = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				nge[stack.pop()] = nums[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			nge[stack.pop()] = -1;
		}
		return nge;
	}
}