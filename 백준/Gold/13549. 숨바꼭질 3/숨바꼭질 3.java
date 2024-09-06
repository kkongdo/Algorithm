import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] time;
	static int MAX = 100001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		time = new int[MAX];
		for(int i = 0; i < MAX; i++) {
			time[i] = -1;
		}
		
		BFS(N, K);
		System.out.println(time[K]);
		
	}
	private static int BFS(int N, int K) {
		Deque<Integer> deque = new LinkedList<>();
		deque.offer(N);
		time[N] = 0;
		while(!deque.isEmpty()) {
			int current = deque.poll();
			
			if(current == K) {
				break;
			}
			if(current * 2 < MAX && time[current * 2] == -1) {
				time[current * 2] = time[current];
				deque.offerFirst(current * 2);
			}
			if(current - 1 >= 0 && time[current - 1] == -1) {
				time[current - 1] = time[current] + 1;
				deque.offerLast(current - 1);
			}
			if(current + 1 < MAX && time[current + 1] == -1) {
				time[current + 1] = time[current] + 1;
				deque.offerLast(current + 1);
			}
		}
		return time[K];
	}
}
