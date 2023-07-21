import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, sum;
	static int[] parent;
	static PriorityQueue<Edge> queue;
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int v;
		public Edge(int s, int e, int v) {
			super();
			this.s=s;
			this.e=e;
			this.v=v;
		}
		@Override
		public int compareTo(Edge o) {
			return this.v-o.v;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		queue=new PriorityQueue<Edge>();
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			char[] ch=str.toCharArray();
			
			for(int j=0; j<N; j++) {
				int temp=0;
				if(ch[j]>='a' && ch[j]<='z') {
					temp=ch[j]-'a'+1;
				}
				else if(ch[j]>='A' && ch[j]<='Z') {
					temp=ch[j]-'A'+27;
				}
				sum+=temp;
				if(i!=j && temp!=0)
					queue.add(new Edge(i,j,temp));
			}
		}
		parent=new int[N];
		for(int i=0; i<N; i++) {
			parent[i]=i;
		}
		int useEdge=0;
		int result=0;
		while (!queue.isEmpty()) {
			Edge edge=queue.poll();
			if ( find(edge.s)!=find(edge.e)) {
				union(edge.s, edge.e);
				result=result+edge.v;
				useEdge++;
			}
		}
		if (useEdge==N-1) {
			System.out.println(sum-result);
		}
		else{
			System.out.println(-1);
		}
	}
	private static void union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			parent[b]=a;
		}
	}
	private static int find(int a) {
		if(a==parent[a]) {
			return a;
		}
		else {
			return parent[a]=find(parent[a]);
		}
	}
}
