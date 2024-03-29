import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] nums = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			nums[i] = i;
		}
		
		for(int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			for(int m = i; m <= j; m++) {
				int backNum = j--;
				
				int tmp = nums[m];
				nums[m] = nums[backNum];
				nums[backNum] = tmp;
			}
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(nums[i] + " ");
		}
		
		sc.close();
	}
}