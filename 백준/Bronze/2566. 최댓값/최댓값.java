import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[9][9];
		int[] loc = new int[2];
		int max = -1;
		
		StringTokenizer st;
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(max < grid[i][j]) {
					max = grid[i][j];
					loc[0] = i + 1 ;
					loc[1] = j + 1;
				}
			}
		}
		System.out.println(max);
		System.out.println(loc[0] + " " + loc[1]);
	}
}