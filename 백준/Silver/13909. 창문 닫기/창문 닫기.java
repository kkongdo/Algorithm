import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0 ;
		for(int i = 1; i <= Math.sqrt(N); i++) {
			count++;
		}
		System.out.println(count);
		
	}
}