import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		Set<String> sets = new HashSet<String>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				sets.clear();
			}
			else if(sets.contains(str)) {
				continue;
			}
			else {
				sets.add(str);
				count++;
			}
		}
		System.out.println(count);
	}
}