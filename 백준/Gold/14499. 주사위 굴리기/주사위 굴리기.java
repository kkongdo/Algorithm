import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice;
    // 동, 서, 남, 북
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(st.nextToken());
			moveMap(order - 1);
		}

	}

	private static void moveMap(int move) {
		int nx = x + dx[move];
		int ny = y + dy[move];

		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return;
		}
		x = nx;
		y = ny;
		rollDice(move);
		if(map[x][y] == 0) {
			map[x][y] = dice[5];
		}
		else {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
		System.out.println(dice[0]);
	}

	private static void rollDice(int move) {
		int[] tmp = dice.clone();
		switch (move) {
		case 0: // 동쪽
			dice[0] = tmp[3];
			dice[3] = tmp[5];
			dice[5] = tmp[2];
			dice[2] = tmp[0];
			break;
		case 1: // 서쪽
			dice[0] = tmp[2];
			dice[2] = tmp[5];
			dice[5] = tmp[3];
			dice[3] = tmp[0];
			break;
		case 2: // 북쪽
			dice[0] = tmp[1];
			dice[1] = tmp[5];
			dice[5] = tmp[4];
			dice[4] = tmp[0];
			break;
		case 3: // 남쪽
			dice[0] = tmp[4];
			dice[4] = tmp[5];
			dice[5] = tmp[1];
			dice[1] = tmp[0];
			break;
		}
	}
}