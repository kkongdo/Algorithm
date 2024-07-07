import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		final int MAX = 1_000_001;
	
		int[] arr = new int[N];
		int[] count = new int[MAX];
		int[] answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
		}
		NGF(N, arr, count, answer);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb.toString());
		
	}

	private static void NGF(int N, int[] arr, int[] count, int[] answer) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && count[arr[i]] > count[arr[stack.peek()]]) {
				answer[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
	}
}
