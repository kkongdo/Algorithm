import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		System.out.println(upperLand());
	}

	private static long upperLand() {
		long min = 1;
		long max = K;
		while(max> min) {
			long mid = (min + max) / 2;
			long count = 0;
			
			for(int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}
			
			if(K <= count) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		return min;
	}
}