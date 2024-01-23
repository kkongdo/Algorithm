import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dis = new long[N - 1];
		long[] L = new long[N];
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < dis.length; i++) {
			dis[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < L.length; i++) {
			L[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long minL = L[0];
		
		for(int i = 0; i < N - 1; i++) {
			if(L[i] < minL) {
				minL = L[i];
			}
			sum += (minL * dis[i]);
		}
		
		System.out.println(sum);
	}
}
