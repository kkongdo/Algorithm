import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static final int INF = Integer.MAX_VALUE;
    public static int T, n, m, t, s, g, h;
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] distance;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<Node>());
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            int[] des = new int[t];
            for (int j = 0; j < t; j++) {
                des[j] = Integer.parseInt(br.readLine());
            }

            int[] distFromS = dijkstra(s);
            int[] distFromG = dijkstra(g);
            int[] distFromH = dijkstra(h);

            for (int d : des) {
                long result1 = distFromS[g] + distFromG[h] + distFromH[d];
                long result2 = distFromS[h] + distFromH[g] + distFromG[d];
                long directResult = distFromS[d];

                if (Math.min(result1, result2) == directResult) {
                    pq.add(d);
                }
            }

            while (!pq.isEmpty()) {
                System.out.print(pq.poll() + " ");
            }
            System.out.println();
        }
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[n + 1]; 
        Arrays.fill(dist, INF); 
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); 
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeEnd = node.end;
            int nodeWeight = node.weight;

            if (dist[nodeEnd] < nodeWeight) continue;
            for (Node neighbor : graph.get(nodeEnd)) {
                int cost = dist[nodeEnd] + neighbor.weight;
                if (cost < dist[neighbor.end]) {
                    dist[neighbor.end] = cost;
                    pq.offer(new Node(neighbor.end, cost));
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
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
