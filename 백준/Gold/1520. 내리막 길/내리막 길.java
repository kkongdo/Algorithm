import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N;
	static int[][] arr, dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[M + 1][N + 1];
		dp = new int[M + 1][N + 1];
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(DFS(1,1));
	}

	private static int DFS(int x, int y) {
		if(x == M && y == N) {
			return 1;
		}
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		else {
			dp[x][y] = 0;
			for(int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 1 || ny < 1 || nx > M || ny > N) {
					continue;
				}
				if(arr[x][y] > arr[nx][ny]) {
					dp[x][y] += DFS(nx, ny);
				}
			}
		}
		return dp[x][y];
	}
}