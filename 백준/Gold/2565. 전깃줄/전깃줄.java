import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static Integer[] dp;
	static int[][] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N];
		line = new int[N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(find(i), max);
		}
		System.out.println(N - max);
	}
	private static int find(int num) {
		if(dp[num] == null) {
			dp[num] = 1;
			for(int i = num + 1; i < dp.length; i++) {
				if(line[num][1] < line[i][1])
					dp[num] = Math.max(dp[num], find(i) + 1);
			}
		}
		return dp[num];
	}
}
