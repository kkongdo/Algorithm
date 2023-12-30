import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(MIN);
	}

	private static void combination(int index, int count) {
		if(count == N /2) {
			diff();
			return;
		}
		for(int i = index; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	private static void diff() {
		int teamStart = 0;
		int teamLink = 0;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(visited[i] == true && visited[j] == true) {
					teamStart += map[i][j];
					teamStart += map[j][i];
				}
				else if(visited[i] == false && visited[j] == false) {
					teamLink += map[i][j];
					teamLink += map[j][i];
				}
			}
		}
		int value = Math.abs(teamStart - teamLink);
		if(value == 0) {
			System.out.println(value);
			System.exit(0);
		}
		MIN = Math.min(value, MIN);
	}
}