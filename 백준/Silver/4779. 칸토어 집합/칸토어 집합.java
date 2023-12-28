import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while( (str = br.readLine()) != null && !str.isEmpty()) {
			N = Integer.parseInt(str);
			int len = (int)Math.pow(3, N);
			sb = new StringBuilder();
			
			for (int i = 0; i < len; i++) {
				sb.append("-");
			}
			cutLines(0 , len);
			System.out.println(sb);
		}
	}

	private static void cutLines(int start, int size) {
		if(size == 1) {
			return;
		}
		int newSize = size / 3;
		for(int i = start + newSize; i < start + 2 * newSize; i++) {
			sb.setCharAt(i, ' ');
		}
		cutLines(start, newSize);
		cutLines(start + 2 * newSize, newSize);
	}
}
