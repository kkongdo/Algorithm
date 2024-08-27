import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int[] colors;
	static boolean isBipartite;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			isBipartite = true;
			colors = new int[V + 1];
			list = new ArrayList<>();
			for(int j = 0; j <= V; j++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				list.get(u).add(v);
				list.get(v).add(u);
			}
			for(int j = 1; j <= V; j++) {
				if(colors[j] == 0) {
					DFS(j, 1);
				}
			}
			if(isBipartite) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	private static void DFS(int node, int color) {
		colors[node] = color;
		for(Integer num : list.get(node)) {
			if(colors[num] == 0) {
				DFS(num, -color);
			}
			else if(colors[num] == colors[node]) {
				isBipartite = false;
				return;
			}
		}
	}
}