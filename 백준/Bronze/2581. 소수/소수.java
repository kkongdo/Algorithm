import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i = M; i <= N; i++) {
			int count = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				list.add(i);
			}
		}
		
		for(int num : list) {
			sum += num;
		}
		
		if(list.isEmpty())
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(list.get(0));
		}
	}
}