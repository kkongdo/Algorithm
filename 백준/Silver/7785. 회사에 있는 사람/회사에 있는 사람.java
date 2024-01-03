import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, String> maps = new HashMap<String, String>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			if(!maps.containsKey(name)) {
				maps.put(name, log);
			}
			else {
				maps.remove(name);
			}
		}
		ArrayList<String> result = new ArrayList<String>(maps.keySet());
		Collections.sort(result, Collections.reverseOrder());
		for(String str : result) {
			System.out.println(str);
		}
	}
}	