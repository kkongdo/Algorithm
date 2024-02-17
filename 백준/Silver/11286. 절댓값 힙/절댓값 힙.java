import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				}
				else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				else {
					return -1;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(queue.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}
			}
			else {
				queue.offer(input);
			}
		}
		System.out.println(sb);
	}
}