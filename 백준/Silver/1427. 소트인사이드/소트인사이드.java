import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = str.toCharArray();
		
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < ch.length; i++) {
			list.add(ch[i]);
		}
		Collections.sort(list, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(char tmp : list) {
			sb.append(tmp);
		}
		System.out.println(sb);
	}
}