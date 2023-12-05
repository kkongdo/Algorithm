import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long num = Long.parseLong(br.readLine());
		
		System.out.println( num * (num - 1) / 2);
		System.out.println(2);
	}
}