import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] students = new int[31];
		int[] noStudents = new int[2];
		
		int count = 0;
		
		for(int i = 1; i < 29; i++) {
			int num = sc.nextInt();
			students[num] = num;
		}
		
		for(int i = 1; i <= 30; i++) {
			if(students[i] == 0) {
				noStudents[count] = i;
				count++;
				if(count == 2) {
					break;
				}
			}
		}
		
		Arrays.sort(noStudents);
		for(int num : noStudents) {
			System.out.println(num);
		}
		
		sc.close();
	}
}