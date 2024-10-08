import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		
		for(int i = 0; i < rope.length; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		int maxWeight = 0;
		
		for(int i = 0; i < N; i++) {
			int currentWeight = rope[i] * (N - i);
			if(currentWeight > maxWeight) {
				maxWeight = currentWeight;
			}
		}
		System.out.println(maxWeight);
	}
}
