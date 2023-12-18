import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Balloon> deque = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		sb.append(1).append(" ");
		int moveValue = nums[0];
		for(int i = 1; i < N; i++) {
			deque.offer(new Balloon(i + 1, nums[i]));
		}
		while(!deque.isEmpty()) {
			if(moveValue > 0) {
				for(int i = 1; i < moveValue; i++) {
					deque.add(deque.poll());
				}
				Balloon nextBallon = deque.poll();
				moveValue = nextBallon.value;
				sb.append(nextBallon.index).append(" ");
			}
			else {
				for(int i = 1; i < -moveValue; i++) {
					deque.offerFirst(deque.pollLast());
				}
				Balloon nextBallon = deque.pollLast();
				moveValue = nextBallon.value;
				sb.append(nextBallon.index).append(" ");
			}
		}
		System.out.println(sb);
	}
}

class Balloon{
	int index;
	int value;
	
	public Balloon(int index, int value) {
		this.index = index;
		this.value = value;
	}
}