import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList<Edge>();
		
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(a, b, w));
		}
		dist[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge currentEdge = edgeList.get(j);
                if (dist[currentEdge.start] != Integer.MAX_VALUE &&
                        dist[currentEdge.end] > dist[currentEdge.start] + currentEdge.weight) {
                    dist[currentEdge.end] = dist[currentEdge.start] + currentEdge.weight;
                }
            }
        }
        // 음수 사이클 판별하기
        boolean cycle = false;
        for(int i = 0; i < M; i++){
            Edge currentEdge = edgeList.get(i);
            if (dist[currentEdge.start] != Integer.MAX_VALUE &&
            		dist[currentEdge.end] > dist[currentEdge.start] + currentEdge.weight) {
                cycle = true;
            }
        }
        
        if(cycle){
        	System.out.println("-1");
        } else {
            for(int i = 2; i <= N; i++){
                if(dist[i]==Integer.MAX_VALUE)
                    System.out.println(-1);
                else 
                	System.out.println(dist[i]);
            }
        }
	}
}

class Edge {
	int start, end, weight;

	public Edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}