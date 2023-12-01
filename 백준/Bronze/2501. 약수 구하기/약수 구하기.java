import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int q= Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= p; i++) {
			if(p % i == 0) {
				list.add(i);
			}
		}
		try {
			System.out.println(list.get(q - 1));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(0);
		}
	}
}