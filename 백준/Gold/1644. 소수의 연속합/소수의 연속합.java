import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[N + 1]; // 에라토스테네스의 체

		for (int i = 2; i <= N; i++) {
			prime[i] = true;
		}
		
		for (int i = 2; i * i <= N; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = false;
				}
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (prime[i]) {
				primes.add(i);
			}
		}
		
		int start = 0, end = 0; 
		int sum = 0; 
		int answer = 0;
		
		while(true) {
			if(sum >= N) {
				sum -= primes.get(start++);
			}
			else if(end == primes.size()) {
				break;
			}
			else {
				sum += primes.get(end++);
			}
				
			if(sum == N) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
