import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] result;
	static int count = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		result = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		DFS(R);
		for(int i = 1; i < N + 1; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int R) {
		visited[R] = true;
		result[R] = count++;
		Collections.sort(graph.get(R), Comparator.reverseOrder());
		for(Integer value : graph.get(R)) {
			if(!visited[value]) {
				DFS(value);
			}
		}
	}
}