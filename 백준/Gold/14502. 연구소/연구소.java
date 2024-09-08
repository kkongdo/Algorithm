import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus{
	int x;
	int y;
	public Virus() {
	}
	public Virus(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[] dx = {-1, 0, 1 , 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static int[][] copyMap;
	static int maxSafeZone = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0, N, M);
		System.out.println(maxSafeZone);
		
	}
	private static void DFS(int wallCount, int N, int M) {
		if(wallCount == 3) {
			BFS(N, M);
			return;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(wallCount + 1, N, M);
					map[i][j] = 0;
				}
			}
		}
	}
	private static void BFS(int N, int M) {
		Queue<Virus> queue = new LinkedList<Virus>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					queue.offer(new Virus(i, j));
				}
			}
		}
		copyMap = new int[N][M];
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            copyMap[i][j] = map[i][j];
	        }
	    }
		while(!queue.isEmpty()) {
			Virus virus = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = 2;
						queue.add(new Virus(nx, ny));
					}
				}
			}
		}
		countSafeZone(copyMap, N, M);
	}
	private static void countSafeZone(int[][] copyMap2, int N, int M) {
		int safeZone = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap2[i][j] == 0) {
					safeZone++;
				}
			}
		}
		maxSafeZone = Math.max(safeZone, maxSafeZone);
	}
}
