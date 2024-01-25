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
		Deque<Integer> queue = new ArrayDeque<Integer>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push")) {
				queue.offer(Integer.parseInt(st.nextToken()));
			} else if (str.equals("pop")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.pop());
				}
			} else if (str.equals("front")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.getFirst());
				}
			} else if (str.equals("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(queue.getLast());
				}
			} else if (str.equals("size")) {
				System.out.println(queue.size());
			} else if (str.equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
	}
}