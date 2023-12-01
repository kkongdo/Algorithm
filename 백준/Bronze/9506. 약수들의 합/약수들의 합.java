import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == -1) {
				break;
			}
			List<Integer> list = new ArrayList<Integer>();
			int sum = 0;

			for (int i = 1; i < N; i++) {
				if (N % i == 0) {
					list.add(i);
				}
			}
			for (int num : list) {
				sum += num;
			}

			if (sum == N) {
				System.out.print(N + " = ");
				for(int i = 0; i < list.size(); i++) {
					if(i == list.size() - 1) {
						System.out.println(list.get(i));
					}
					else {
						System.out.print(list.get(i) + " + ");
					}
				}
			} else {
				System.out.println(N + " is NOT perfect.");
			}
		}
	}
}