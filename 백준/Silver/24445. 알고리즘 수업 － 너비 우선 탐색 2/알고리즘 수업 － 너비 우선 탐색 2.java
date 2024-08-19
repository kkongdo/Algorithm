import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] result;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		result = new int[N + 1];
		
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
		for(int i = 0; i <= N; i++) {
			Collections.sort(graph.get(i), Comparator.reverseOrder());
		}
		
		BFS(R);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
	}
	private static void BFS(int r) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(r);
		int count = 1;
		visited[r] = true;
		result[r] = count++;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(Integer num : graph.get(current)) {
				if(!visited[num]) {
					visited[num] = true;
					queue.add(num);
					result[num] = count++;
				}
			}
		}
	}
}