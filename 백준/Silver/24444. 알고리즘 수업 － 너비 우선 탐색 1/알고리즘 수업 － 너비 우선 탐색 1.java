import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		result = new int[M + 1];
		visited = new boolean[M + 1];
		
		for(int i = 0; i <= M; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for(int i = 0; i < M; i++) {
			Collections.sort(graph.get(i));
		}
		
		BFS(R);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= M; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void BFS(int r) {
		int count = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r);
		visited[r] = true;
		result[r] = count++;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(Integer num : graph.get(current)) {
				if(!visited[num]) {
					queue.add(num);
					visited[num] = true;
					result[num] = count++;
				}
			}
		}
	}
}
