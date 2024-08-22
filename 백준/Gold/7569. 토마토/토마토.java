import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] boxes;
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		boxes = new int[H][N][M];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					boxes[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(boxes[i][j][k] == 1) {
						queue.add(new int[] {i, j, k});
					}
				}
			}
		}
		BFS(queue, N, M, H);
		int result = checkBoxes(N, M, H);
		System.out.println(result);
		
	}
	private static int checkBoxes(int N, int M, int H) {
		int max = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(boxes[i][j][k] == 0) {
						return -1;
					}
					max = Math.max(max, boxes[i][j][k]);
				}
			}
		}
		return max - 1;
	}
	private static void BFS(Queue<int[]> queue, int n, int m, int h) {
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int ch = current[0];
			int cy = current[1];
			int cx = current[2];
			
			for(int i = 0; i < 6; i++) {
				int nh = ch + dh[i];
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(nx >=0 && nx < m && ny >= 0 && ny < n && nh >=0 && nh < h && boxes[nh][ny][nx] == 0) {
					queue.add(new int[] {nh, ny, nx});
					boxes[nh][ny][nx] = boxes[ch][cy][cx] + 1;
				}
			}
		}
	}
}