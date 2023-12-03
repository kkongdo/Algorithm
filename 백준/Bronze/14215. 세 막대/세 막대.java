import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] lens = new int[3];
		for(int i = 0; i < lens.length; i++) {
			lens[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lens);
		while(true) {
			if(lens[2] < lens[0] + lens[1]) {
				System.out.println(lens[0] + lens[1] + lens[2]);
				break;
			}
			else if(lens[0] == lens[1] && lens[1] == lens[2]) {
				System.out.println(lens[0] + lens[1] + lens[2]);
				break;
			}
			lens[2]--;
		}
	}
}