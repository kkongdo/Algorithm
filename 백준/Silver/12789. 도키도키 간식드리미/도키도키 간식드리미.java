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
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(nums));
	}

	private static String solution(int[] nums) {
		int orderNum = 1;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != orderNum) {
				if(!stack.isEmpty() && stack.peek() == orderNum) {
					stack.pop();
					i--;
					orderNum++;
				}
				else {
					stack.push(nums[i]);
				}
			}
			else {
				orderNum++;
			}
		}
		boolean result = true;
		for(int i = 0; i < stack.size(); i++) {
			int val = stack.pop();
			if(val == orderNum) {
				orderNum++;
			}
			else {
				result = false;
				break;
			}
		}
		return result ? "Nice" : "Sad";
	}
}