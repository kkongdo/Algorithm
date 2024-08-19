import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int computer = Integer.parseInt(br.readLine());
		int network = Integer.parseInt(br.readLine());
		visited = new boolean[computer + 1];
		
		for(int i = 0; i <= computer; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < network; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		DFS(1);
		System.out.println(result - 1);
	}
	private static void DFS(int i) {
		visited[i] = true;
		result++;
		for(Integer num : graph.get(i)) {
			if(!visited[num]) {
				DFS(num);
			}
		}
	}
}