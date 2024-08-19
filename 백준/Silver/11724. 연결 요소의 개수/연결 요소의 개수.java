import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i);
				result++;
			}
		}

		System.out.println(result);
	}

	private static void DFS(int i) {
		visited[i] = true;
		for (Integer num : graph.get(i)) {
			if (!visited[num]) {
				DFS(num);
			}
		}
	}
}