import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][2];
		int[][] nums = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				nums[i][j] = str.charAt(j) - '0';
			}
		}
		int result = BFS(0, 0, N, M, nums);
		System.out.println(result);
	}
	private static int BFS(int x, int y, int N, int M, int[][] nums) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, 0, 1});
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			int broken = current[2];
			int distance = current[3];
			
            if (cx == N - 1 && cy == M - 1) {
                return distance;
            }
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(nums[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						queue.add(new int[] {nx, ny, 1, distance + 1});
					}
					if(nums[nx][ny] == 0 && !visited[nx][ny][broken]){
						visited[nx][ny][broken] = true;
						queue.add(new int[] {nx, ny, broken, distance + 1});
					}
				}
			}
		}
		return - 1;
	}
}