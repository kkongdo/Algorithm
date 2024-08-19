import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] result;
	static int count = 1;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		result = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}
		DFS(V);
		Arrays.fill(visited, false);
		sb.append("\n");
		BFS(V);
		System.out.println(sb);
	}
	private static void BFS(int v) {
		visited[v] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			for(Integer  num : graph.get(current)) {
				if(!visited[num]) {
					visited[num] = true;
					queue.add(num);
				}
			}
		}
	}
	private static void DFS(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		for(Integer num : graph.get(v)) {
			if(!visited[num]) {
				DFS(num);
			}
		}
	}
}
