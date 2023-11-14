import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String S = sc.next();
			int count = 0;
			char[] c = S.toCharArray();
			StringBuilder sb = new StringBuilder();
			
			while(count != S.length()) {
				for(int j = 0; j < R; j++) {
					sb.append(c[count]);
				}
				count++;
			}
			
			System.out.println(sb);
		}
		sc.close();
	}
}