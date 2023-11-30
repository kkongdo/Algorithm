import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int N = sc.nextInt();
		
		char[] ch = str.toCharArray();
		int[] num = new int[ch.length];
		int sum = 0;
		
		for(int i = num.length - 1; i >= 0; i--) {
			if(ch[i] >= '0' && ch[i] <= '9') {
				num[i] = ch[i] - '0';
			}
			else {
				num[i] = (ch[i] - 65) + 10;
			}
			sum += num[i] * Math.pow(N, (num.length -1 ) - i );
		}
		System.out.println(sum);
		
		sc.close();
	}
}