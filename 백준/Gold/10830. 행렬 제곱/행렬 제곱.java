import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] nums;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		nums = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		int[][] result = pow(nums, B);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static int[][] pow(int[][] a, long exp) {
		if(exp == 1L) {
			return a;
		}
		int[][] ret = pow(a, exp / 2);
		ret = mult(ret, ret);
		if(exp % 2 == 1L) {
			ret = mult(ret, nums);
		}
		return ret;
	}

	private static int[][] mult(int[][] ret, int[][] nums) {
		int[][] num2 = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					num2[i][j] += ret[i][k] * nums[k][j];
					num2[i][j] %= 1000;
				}
			}
		}
		return num2;
	}
}