import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int x1, y1, x2, y2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int I = Integer.parseInt(br.readLine());
			
			arr = new int[I][I];
			visited = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			BFS(I);
			sb.append(arr[x2][y2]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void BFS(int I) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x1, y1});
		arr[x1][y1] = 0;
		visited[x1][y1] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			if(cx == x2 && cy == y2) {
				return;
			}
			for(int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx >= 0 && nx < I && ny >= 0 && ny < I && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					arr[nx][ny] = arr[cx][cy] + 1;
				}
			}
		}
	}
}
