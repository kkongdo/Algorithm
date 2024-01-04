import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int num1 = 0;
	static int num2 = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		fib(num);
		fibonacci(num);
		
		System.out.println(num1 + " " +num2);
	}
	//재귀
	private static int fib(int num) {
		if(num == 1 || num == 2) {
			num1++;
			return 1;
		}
		else {
			return fib(num - 1) + fib(num - 2);
		}
	}
	//DP
	private static int fibonacci(int num) {
		int[] arr = new int[num + 1];
		arr[1] = arr[2] = 1;
		for(int i = 3; i <= num; i++) {
			num2++;
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[num];
	}
}
