import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[][] arr = new boolean[100][100];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			for(int j = num1; j < num1 + 10; j++) {
				for(int k = num2; k < num2 + 10; k++) {
					arr[j][k] = true; 
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == true)
					count += 1;
			}
		}
		System.out.println(count);
	}
}