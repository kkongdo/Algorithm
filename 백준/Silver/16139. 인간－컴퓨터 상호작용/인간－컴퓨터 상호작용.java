import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(br.readLine());
		int[][] memNums = new int[str.length() + 1][26];
		memNums[1][str.charAt(0) - 'a']++;
		
		for(int i = 2; i <= str.length(); i++) {
			int index = str.charAt(i - 1) - 'a';
			for(int j = 0; j < 26; j++) {
				int before = memNums[i - 1][j];
				memNums[i][j] = j == index ? before + 1 : before;
			}
		}
		StringTokenizer st;
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int index = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken()) + 1;
			int end = Integer.parseInt(st.nextToken()) + 1;
			sb.append(memNums[end][index] - memNums[start - 1][index]).append("\n");
		}
		System.out.println(sb);
	}
}