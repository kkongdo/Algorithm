import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		int time = sc.nextInt();
		
		int hToM = H * 60;
		int sum = hToM + M + time;
		
		if(sum >= 1440) {
			sum -= 1440;
		}
		
		System.out.println(sum / 60 + " " + sum % 60);
		
		sc.close();
	}
}