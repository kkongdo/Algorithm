import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N;
	static Stack<Pair> stack = new Stack<>();
	static long count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			Pair pair = new Pair(n,1);
			
			while(!stack.isEmpty() && stack.peek().height <= n) {
				Pair pop = stack.pop();
				count += pop.count;
				if(pop.height == n) {
					pair.count += pop.count;
				}
			}
			if(!stack.empty()) {
				count++;
			}
			stack.push(pair);
		}
		System.out.println(count);
	}
	static class Pair{
		int height;
		int count;
		Pair(int height, int count){
			this.height = height;
			this.count = count;
		}
	}
}
