import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt(); //분수위치값
		int cross_count = 1; //해당 범위의 대각선 칸 갯수
		int prev_count_sum = 0; // 해당 대각선 직전 대각선까지의 칸의 누적합
		
		while(true) {
			if( X <= prev_count_sum + cross_count) {
				if(cross_count % 2 == 1) {
					System.out.print( (cross_count - (X - prev_count_sum - 1)) + "/" + (X - prev_count_sum));
					break;
				}
				else {
					System.out.print((X - prev_count_sum) + "/" + (cross_count - (X - prev_count_sum - 1)));
					break;
				}
			}
			else {
				prev_count_sum += cross_count;
				cross_count++;
			}
		}
		
		sc.close();
	}
}