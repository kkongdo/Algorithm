import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			maps.put(num, num);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(maps.containsKey(num)) {
				sb.append("1").append(" ");
			}
			else {
				sb.append("0").append(" ");
			}
		}
		System.out.println(sb);
	}
}