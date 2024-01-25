import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] nums;
	static int paper1, paper2, paper3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0, 0, N);
		System.out.println(paper1);
		System.out.println(paper2);
		System.out.println(paper3);
	}
	private static void recur(int row, int col, int n) {
		if(check(row, col, n)) {
			if(nums[row][col] == -1) {
				paper1++;
			}else if(nums[row][col] == 0) {
				paper2++;
			}else {
				paper3++;
			}
			return;
		}
		int n2 = n / 3;
		recur(row, col, n2);
		recur(row, col + n2, n2);
		recur(row, col + n2 * 2, n2);
		
		recur(row + n2, col, n2);
		recur(row + n2, col + n2, n2);
		recur(row + n2, col + n2 * 2, n2);
	
		recur(row + n2 * 2, col, n2);
		recur(row + n2 * 2, col + n2, n2);
		recur(row + n2 * 2, col + n2 * 2, n2);
		
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