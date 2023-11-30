import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			int money = Integer.parseInt(br.readLine());

			sb.append((money / 25) + " ");
			money = money % 25;

			sb.append((money / 10) + " ");
			money = money % 10;
			
			sb.append((money / 5) + " ");
			money = money % 5;
			
			sb.append((money / 1) + " ");
			money = money % 1;
			
			System.out.print(sb.toString());
			System.out.println();
		}
	}
}