import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int result;
	static int T;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] ground;
	static int count = 1;
	static int M, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ground = new int[M][N];
			visited = new boolean[M][N];
			result = 0;
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = 1;
			}
			
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if(!visited[j][k] && ground[j][k] == 1){
						DFS(j, k);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	private static void DFS(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && ground[nx][ny] == 1) {
				DFS(nx, ny);
			}
		}
	}
}