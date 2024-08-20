import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static boolean[][] visited;
	static int N;
	static int[][] danji;
	static List<Integer> result;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int count = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		danji = new int[N + 1][N + 1];
		result = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				danji[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(danji[i][j] == 1 && !visited[i][j]) {
					DFS(i, j);
					result.add(count);
					count = 1;
				}
			}
		}
		Collections.sort(result);
		sb.append(result.size() + "\n");
		for(Integer num : result) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
	private static void DFS(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && danji[nx][ny] == 1) {
				count++;
				DFS(nx, ny);
			}
		}
	}
}
