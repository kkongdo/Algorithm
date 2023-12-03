import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] angles = new int[3];
		int sum = 0;
		for(int i = 0; i < angles.length; i++) {
			angles[i] = Integer.parseInt(br.readLine());
			sum += angles[i];
		}
		Arrays.sort(angles);
		if(sum == 180) {
			if(angles[0] == angles[1] && angles[1] == angles[2]) {
				System.out.println("Equilateral");
			}
			else if((angles[0] != angles[1] && angles[1] == angles[2])){
				System.out.println("Isosceles");
			}
			else if((angles[0] != angles[2] && angles[0] == angles[1])){
				System.out.println("Isosceles");
			}
			else {
				System.out.println("Scalene");
			}
		}
		else {
			System.out.println("Error");
		}
		
	}
}