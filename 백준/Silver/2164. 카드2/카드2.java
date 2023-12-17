import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while(true) {
			queue.poll();
			if(queue.size() == 0) {
				System.out.println(1);
				break;
			}
			int num = queue.poll();
			queue.offer(num);
			if(queue.size() == 1) {
				System.out.println(queue.poll());
				break;
			}
		}
	}
}