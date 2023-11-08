import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
				'r','s','t','u','v','w','x','y','z'};
		int[] loc = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		
		for(int i = 0; i < str.length(); i++) {
			char selectedAlpha = str.charAt(i);
			for(int j = 0; j < ch.length; j++) {
				if(selectedAlpha == ch[j]) {
					if(loc[j] == -1) {
						loc[j] = i;
						break;
					}
				}
			}
		}
		for(int i = 0; i < loc.length; i++) {
			System.out.print(loc[i] + " ");
		}
	}
}