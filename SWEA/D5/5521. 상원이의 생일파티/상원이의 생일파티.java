import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer>[] arraylist;
	static boolean[] visited;
	static int count=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		int test_case=Integer.parseInt(br.readLine());
		int answer=0;
		
		for(int t=1; t<=test_case; t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			arraylist=new ArrayList[N+1];
			visited=new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				arraylist[i]=new ArrayList<Integer>();
			}
			for(int i=0; i<M; i++) {
				st=new StringTokenizer(br.readLine());
				int S=Integer.parseInt(st.nextToken());
				int E=Integer.parseInt(st.nextToken());
				arraylist[S].add(E);
				arraylist[E].add(S);
			};
			bfs(1);
			System.out.println("#"+t+" "+count);
			count=0;
		}
	}

	private static void bfs(int index) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(index);
		visited[index]=true;
		int turn=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int s=0; s<size; s++) {
				int node=queue.poll();
				for(int i : arraylist[node]) {
					if(visited[i]==false) {
						count++;
						visited[i]=true;
						queue.add(i);
					}
				}
			}
			turn++;
			if(turn==2) {
				break;
			}
		}
	}
}
