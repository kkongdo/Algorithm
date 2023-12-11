import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> noLtMem = new HashMap<String, Integer>();
		for(int i = 0; i < N; i++) {
			noLtMem.put(br.readLine(), 0);
		}
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(noLtMem.containsKey(name)) {
				result.add(name);
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(String str : result) {
			System.out.println(str);
		}
	}
}