import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제풀이 참고 사이트 : https://st-lab.tistory.com/95
public class Main {
	static char[][] ch;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ch = new char[N][N];
		star(0, 0, N, false);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				sb.append(ch[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	private static void star(int x, int y, int n, boolean blank) {
		if(blank) {
			for(int i = x; i < x + n; i++) {
				for(int j = y; j < y +n; j++) {
					ch[i][j] = ' ';
				}
			}
			return;
		}
		if(n == 1) {
			ch[x][y] ='*';
			return;
		}
		
		int size = n / 3;
		int count = 0;
		for(int i = x; i < x + n; i += size) {
			for(int j = y; j < y + n; j += size) {
				count++;
				if(count == 5) {
					star(i, j, size, true);
				}
				else {
					star(i, j, size, false);
				}
			}
		}
	}
}