import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] square;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		square = new int[9][9];
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
	}
	private static void sudoku(int row, int col) {
		if(col == 9) {
			sudoku(row + 1, 0);
			return;
		}
		if(row == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(square[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(square[row][col] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(possibility(row, col, i)) {
					square[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			square[row][col] = 0;
			return;
		}
		sudoku(row, col + 1);
	}
	private static boolean possibility(int row, int col, int value) {
		
		for(int i = 0; i < 9; i++) {
			if(square[row][i] == value) {
				return false;
			}
		}
		for(int i = 0; i < 9; i++) {
			if(square[i][col] == value) {
				return false;
			}
		}
		int setRow = (row / 3) * 3;
		int setCol = (col / 3) * 3;
		for(int i = setRow; i < setRow + 3; i++) {
			for(int j = setCol; j< setCol + 3; j++) {
				if(square[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}