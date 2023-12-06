import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int number = 666;
		int count = 1;
		while(count != num) {
			number++;
			if(String.valueOf(number).contains("666")) {
				count++;
			}
		}
		System.out.println(number);
	}
}