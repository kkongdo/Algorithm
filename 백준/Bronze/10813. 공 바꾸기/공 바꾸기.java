import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] nums = new int[N];
		for(int a = 0; a < N; a++) {
			nums[a] = a + 1;
		}
		for (int a = 0; a < M; a++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int tmp = nums[i - 1];
			nums[i - 1] = nums[j - 1];
			nums[j - 1] = tmp;
		}
		for(int i = 0; i < N; i++) {
			System.out.print(nums[i] + " ");
		}
		sc.close();
	}
}