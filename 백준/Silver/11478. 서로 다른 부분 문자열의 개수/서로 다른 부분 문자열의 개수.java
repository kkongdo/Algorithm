import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = str.toCharArray();
		
		Set<String> strSet = new HashSet<String>();
		for(int i = 0; i < ch.length; i++) {
			String tmp = "";
			for(int j = i; j < ch.length; j++) {
				tmp += ch[j];
				strSet.add(tmp);
			}
		}
		System.out.println(strSet.size());
	}
}