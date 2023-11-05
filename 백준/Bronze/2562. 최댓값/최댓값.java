import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0, loc = 0;
		
		int[] nums = new int[9];
		for(int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i = 0; i < 9; i++) {
			if(nums[i] >= max) {
				max = nums[i];
				loc = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(loc);
		
		sc.close();
	}
}