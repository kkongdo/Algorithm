import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] type = new int[N];
		for(int i = 0; i < N; i++) {
			type[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> queue = new ArrayDeque<Integer>();
		st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(type[i] == 0) {
				queue.addFirst(num);
			}
			else {
				count++;
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(count == N) {
				sb.append(st.nextToken()).append(" ");
			}else {
				sb.append(queue.poll()).append(" ");
				queue.add(Integer.parseInt(st.nextToken()));
			}
		}
		System.out.println(sb);
	}
}	