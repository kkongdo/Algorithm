import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				nums[i][j] = str.charAt(j) - '0';
			}
		}
		recur(0, 0, N);
		System.out.println(sb);
	}

	private static void recur(int row, int col, int n) {
		if(check(row, col, n)) {
			sb.append(nums[row][col]);
			return;
		}
		int n2 = n / 2;
		sb.append("(");
		recur(row, col, n2);
		recur(row, col + n2, n2);
		recur(row + n2, col, n2);
		recur(row + n2, col + n2, n2);
		sb.append(")");
	}

	private static boolean check(int row, int col, int n) {
		int num = nums[row][col];
		for(int i = row; i < row + n; i++) {
			for(int j = col; j < col + n; j++) {
				if(nums[i][j] != num) {
					return false;
				}
			}
		}
		return true;
	}
}