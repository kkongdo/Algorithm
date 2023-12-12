import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Long[] trees = new Long[N];
		for(int i = 0; i < trees.length; i++) {
			trees[i] = Long.parseLong(br.readLine());
		}
		
		Long[] dis = new Long[N - 1];
		for(int i = 0; i < dis.length; i++) {
			dis[i] = trees[i + 1] - trees[i];
		}
		Arrays.sort(dis);
		
		long gcd = 0;
		gcd = gcd(dis[0], dis[1]);
		for(int i = 2; i < dis.length; i++) {
			gcd = gcd(gcd , dis[i]);
			if(gcd == 1) {
				break;
			}
		}
		int count = 0;
		for(int i = 0; i < N - 1; i++) {
			count += ((dis[i] / gcd) - 1);
		}
		System.out.println(count);
	}

	private static Long gcd(Long i, Long j) {
		if(j == 0) {
			return i;
		}
		else {
			return gcd(j, i % j);
		}
	}
}