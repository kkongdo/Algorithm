import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		List<Integer> list = new ArrayList<Integer>();
		while (queue.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			list.add(queue.poll());
		}
		list.add(queue.poll());
		System.out.print("<");
		for (int i = 0; i < N; i++) {
			if (i != N - 1) {
				System.out.print(list.get(i) + ", ");
			} else {
				System.out.print(list.get(i));
			}
		}
		System.out.println(">");
	}
}
