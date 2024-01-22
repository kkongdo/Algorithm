import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		String[] numArr1 = br.readLine().split("-");
		
		for(int i = 0; i < numArr1.length; i++) {
			int tmp = 0;
			String[] numArr2 = numArr1[i].split("\\+");
			for(int j = 0; j < numArr2.length; j++) {
				tmp += Integer.parseInt(numArr2[j]);
			}
			if(sum == Integer.MAX_VALUE) {
				sum = tmp;
			}
			else {
				sum -= tmp;
			}
 		}
		System.out.println(sum);
	}
}