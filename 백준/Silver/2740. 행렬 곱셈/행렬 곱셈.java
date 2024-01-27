import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스트라센 알고리즘 : 분할정복을 이용한 행렬곱셈 문제 풀이
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] nums1 = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				nums1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] nums2 = new int[M][K];
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < K ; j++) {
				nums2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				int sum = 0;
				for( int k = 0; k < M; k++) {
					sum += nums1[i][k] * nums2[k][j]; 
				}
				sb.append(sum).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}