import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] ground;
	static int result;
	static int M, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			visited = new boolean[M][N];
			ground = new int[M][N];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				ground[X][Y] = 1;
			}
			result = 0;
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k] && ground[j][k] == 1) {
						BFS(j, k);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	private static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && ground[nx][ny] == 1) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}
	}
}