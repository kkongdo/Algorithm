import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] cups;
	static Integer[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		cups = new int[num + 1];
		dp = new Integer[num + 1];
		for(int i = 1; i < num + 1; i++) {
			cups[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = cups[1];
		if(num > 1) {
			dp[2] = cups[1] + cups[2];
		}
		System.out.println(find(num));
	}
	private static int find(int num) {
		if(dp[num] == null) {
			dp[num] = Math.max(Math.max(find(num - 2), find(num - 3) + cups[num - 1]) + cups[num], find(num - 1));
		}
		return dp[num];
	}
}