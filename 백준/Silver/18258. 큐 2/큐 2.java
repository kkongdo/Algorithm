import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int lastNum = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) {
				int num = lastNum = Integer.parseInt(st.nextToken());
				queue.offer(num);
			}
			else if(str.equals("pop")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}
			}
			else if(str.equals("size")) {
				sb.append(queue.size()).append("\n");
			}
			else if(str.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			else if(str.equals("front")) {
				if(!queue.isEmpty()) {
					sb.append(queue.peek()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
			}
			else if(str.equals("back")) {
				if(!queue.isEmpty()) {
					sb.append(lastNum).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
