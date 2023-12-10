import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> maps1 = new HashMap<String, Integer>();
		Map<Integer, String> maps2 = new HashMap<Integer, String>();
		
		for(int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			maps1.put(str, i);
			maps2.put(i, str);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(isNumber(str)) {
				sb.append(maps2.get(Integer.parseInt(str))).append("\n");
			}
			else {
				sb.append(maps1.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean isNumber(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}