import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N= Integer.parseInt(st.nextToken());
		
		List<Boolean> list = new ArrayList<Boolean>(N + 1);
		list.add(false);
		list.add(false);
		
		for(int i = 2; i < N + 1; i++) {
			list.add(true);
		}
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(list.get(i)) {
				for(int j = i * i; j <= N; j += i) {
					list.set(j, false);
				}
			}
		}
		for(int i = M; i <= N; i++) {
			if(list.get(i)) {
				System.out.println(i);
			}
		}
	}
}