import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 갯수
		int E = Integer.parseInt(st.nextToken()); // 간선의 갯수
		int K = Integer.parseInt(br.readLine()); // 시작 정점
		
		visited = new boolean[V + 1];
		dist = new int[V + 1];
		
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		djjkstra(K);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	private static void djjkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int currentNode = current.end;
			
			if(visited[currentNode])
				continue;
			visited[currentNode] = true;
			for(Node neighbor : graph.get(currentNode)) {
				if(dist[neighbor.end] > dist[currentNode] + neighbor.weight) {
					dist[neighbor.end] = dist[currentNode] + neighbor.weight;
					pq.offer(new Node(neighbor.end, dist[neighbor.end]));
				}
			}
		}
	}
}
class Node implements Comparable<Node>{
	int end;
	int weight;
	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
}
