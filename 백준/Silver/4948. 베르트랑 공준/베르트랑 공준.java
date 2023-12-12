import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Boolean> list = new ArrayList<Boolean>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		getPrime();
		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				break;
			}
			int count = 0;
			for (int i = num + 1; i <= 2 * num; i++) {
				if (list.get(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	private static void getPrime() {
		list.add(false);
		list.add(false);

		for (int i = 2; i <= 246913; i++) {
			list.add(true);
		}
		for (int i = 2; i <= Math.sqrt(246913); i++) {
			if (list.get(i)) {
				for (int j = i * i; j <= 246913; j += i) {
					list.set(j, false);
				}
			}
		}
	}
}