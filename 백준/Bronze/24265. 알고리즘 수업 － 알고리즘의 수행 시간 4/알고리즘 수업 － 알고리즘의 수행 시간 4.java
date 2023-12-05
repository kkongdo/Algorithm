import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long num = Long.parseLong(br.readLine());
		Long sum = (long) 0;
		for(int i = 1; i < num; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(2);
	}
}
