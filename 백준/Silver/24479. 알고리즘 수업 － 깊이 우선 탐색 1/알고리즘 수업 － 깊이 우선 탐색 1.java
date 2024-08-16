import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] result;
	static ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		result = new int[N + 1];
		
		for(int T = 0; T <= N; T++) {
			nums.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nums.get(u).add(v);
			nums.get(v).add(u);
		}
		DFS(R);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.print(sb);
	}

	private static void DFS(int r) {
		visited[r] = true;
		result[r] = count++;
		Collections.sort(nums.get(r));
		for(Integer value : nums.get(r)) {
			if(!visited[value]) {
				DFS(value);
			}
		}
		return;
	}
}