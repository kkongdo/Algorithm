import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] box;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int x, y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 행
		int N = Integer.parseInt(st.nextToken()); // 열
		
		box = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		BFS(queue, M, N);
		int result = checkBox(M, N);
		System.out.println(result);
	}
	private static int checkBox(int M, int N) {
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, box[i][j]);
			}
		}
		return max - 1;
	}
	
	private static void BFS(Queue<int[]> queue, int m, int n) {
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
					queue.add(new int[] {nx, ny});
					box[nx][ny] = box[cx][cy] + 1;
				}
			}
		}
	}
}