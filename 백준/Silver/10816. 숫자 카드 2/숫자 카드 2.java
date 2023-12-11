import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> cards = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int count = 1;
			if(cards.containsKey(num)) {
				int sum = cards.get(num);
				cards.replace(num, ++sum);
			}
			else {
				cards.put(num, count);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		List<Integer> keys = new ArrayList<Integer>();
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			keys.add(num);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(cards.containsKey(keys.get(i))) {
				sb.append(cards.get(keys.get(i))).append(" ");
			}
			else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
}