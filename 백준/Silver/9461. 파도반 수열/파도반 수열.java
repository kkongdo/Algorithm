import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] seq = new long[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		seq[0] = 0;
		seq[1] = seq[2] = seq[3] = 1;
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(padovan(N));
		}
	}
	private static long padovan(int n) {
		if(seq[n] == 0) {
			seq[n] = padovan(n - 2) + padovan(n - 3);
		}
		return seq[n];
	}
}
