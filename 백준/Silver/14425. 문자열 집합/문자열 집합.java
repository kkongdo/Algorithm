import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> maps = new HashMap<String, String>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			maps.put(str, str);
		}
		int count = 0;
		for(int i = 0; i < M; i++) {
			if(maps.containsKey(br.readLine())) {
				count++;
			}
		}
		System.out.println(count);
		
		br.close();
	}
}