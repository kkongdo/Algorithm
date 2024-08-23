import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] board = new int[101];  // 보드 상태를 나타내는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;  // 사다리나 뱀의 위치 설정
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[] count = new int[101];  // 이동 횟수를 기록하는 배열
        boolean[] visited = new boolean[101];  // 방문 여부를 기록하는 배열
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);  // 시작점
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= 6; i++) {  // 주사위 1~6까지 던져보기
                int next = current + i;
                if (next > 100) 
                	continue;
                if (board[next] != 0) {  // 사다리나 뱀을 만난 경우
                    next = board[next];
                }
                if (!visited[next]) {
                    visited[next] = true;
                    count[next] = count[current] + 1;
                    queue.offer(next);
                    if (next == 100) 
                    	return count[next];  // 100번 칸에 도달한 경우
                }
            }
        }
        return -1;
    }
}