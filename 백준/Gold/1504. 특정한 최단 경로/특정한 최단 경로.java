import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static final int INF = 200000000;
	static int result = 200000000;;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		

		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int answer1 = 0, answer2 = 0;
		
	       // 1 -> v1 -> v2 -> N
        // 경로가 존재하지 않을 경우 dist[v1], dist[v2], dist[N]이 INF일 수 있으므로 이에 대한 처리 필요
        answer1 += dijkstra(1, v1, N);
        if (answer1 >= INF) { // 중간에 경로가 없을 경우 INF를 더하지 않도록 처리
            answer1 = INF;
        } else {
            answer1 += dijkstra(v1, v2, N);
            if (answer1 < INF) { // 중간에 경로가 없을 경우 INF를 더하지 않도록 처리
                answer1 += dijkstra(v2, N, N);
            }
        }

        // 1 -> v2 -> v1 -> N
        answer2 += dijkstra(1, v2, N);
        if (answer2 >= INF) { // 중간에 경로가 없을 경우 INF를 더하지 않도록 처리
            answer2 = INF;
        } else {
            answer2 += dijkstra(v2, v1, N);
            if (answer2 < INF) { // 중간에 경로가 없을 경우 INF를 더하지 않도록 처리
                answer2 += dijkstra(v1, N, N);
            }
        }

        int result = Math.min(answer1, answer2);

        if (result >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
	}
	private static int dijkstra(int start, int end, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		
        for(int i = 0; i <= N; i++) {
            dist[i] = INF;
        }
        
        dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int currentEnd = current.end;
			if(visited[currentEnd])
				continue;
			visited[currentEnd] = true;
			for(Node neighbor : graph.get(currentEnd)) {
				if(dist[neighbor.end] > dist[currentEnd] + neighbor.weight) {
					dist[neighbor.end] = dist[currentEnd] + neighbor.weight;
					pq.offer(new Node(neighbor.end, dist[neighbor.end]));
				}
			}
		}
        return dist[end];
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