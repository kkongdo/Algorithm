import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] miro;
	static int result;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j) - '0';
			}
		}
		BFS(0, 0, N, M);
		System.out.println(miro[N - 1][M - 1]);

	}

	private static int BFS(int x, int y, int n, int m) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { x, y });
		miro[x][y] = 1;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && miro[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
					miro[nx][ny] = miro[cx][cy] + 1;
				}
			}
		}
		return miro[n - 1][m - 1];
	}
}
