import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M + 1];
        
        boolean color = false;	
        for(int i = 1;i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                char c = str.charAt(j-1);
                if(!color && c == 'W')
                    board[i][j] = 1;
                else if(color && c == 'B')
                    board[i][j] = 1;
                color = !color;
            }
            if(M % 2 == 0)
                color = !color;
        }
        
        for(int i = 1; i <= N ; i++){
            int tmp = board[i][1];
            for(int j = 2; j <= M; j++){
                tmp += board[i][j];
                board[i][j] = tmp;
            }
        }
        
        for(int i = 1;i <= M; i++){
            int tmp = board[1][i];
            for(int j = 2; j <= N; j++){
                tmp += board[j][i];
                board[j][i] = tmp;
            }
        }
        
        for(int i = K; i <= N; i++){
            for(int j = K; j <= M; j++){
                int tmp = board[i][j] - (board[i-K][j] + board[i][j-K] - board[i-K][j-K]);
                min = Math.min(min, tmp);	
                max = Math.max(max, tmp);	
            }
        }
        System.out.println(Math.min(min, K*K - max));
    }
}