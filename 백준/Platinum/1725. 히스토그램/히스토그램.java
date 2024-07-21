import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 2];
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int answer = 0;
		for(int i = 1; i <= N + 1; i++) {
			while(!stack.isEmpty()) {
				int top = stack.peek();
				if(nums[top] <= nums[i])
					break;
				stack.pop();
				answer = Math.max(answer, nums[top] * (i - stack.peek() - 1));
			}
			stack.push(i);
		}
		System.out.println(answer);
	}
}