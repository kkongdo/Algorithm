import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 2 };
	static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		BFS(N, M);

	}

	private static void BFS(int n, int m) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		check[n] = 1;
		while (!queue.isEmpty()) {
			int target = queue.poll();
			if(target == m) {
				System.out.println(check[target] - 1);
				return;
			}
			for (int j = 0; j < 3; j++) {
				int nx;
				if (j < 2) {
					nx = target + dx[j];
				} else {
					nx = target * dx[j];
				}
				if (nx >= 0 && nx < 100001 && check[nx] == 0) {
					queue.offer(nx);
					check[nx] = check[target] + 1;
				}
			}
		}
	}
}
