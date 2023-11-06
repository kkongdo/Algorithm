import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];
		int count = 0;
		
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			nums[i] = num % 42;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(nums[i] == nums[j]) {
					if(i == j) {
						count++;
					}
					break;
				}
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}
}