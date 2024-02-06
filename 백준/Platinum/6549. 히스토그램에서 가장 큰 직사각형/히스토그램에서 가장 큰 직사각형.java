import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] histogram;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			}
			histogram = new int[N];
			for(int i = 0; i < N; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(getLocation(0, N - 1)).append('\n');
			histogram = null;
		}
		System.out.println(sb);
	}
	private static long getLocation(int i, int j) {
		if(i == j) {
			return histogram[i];
		}
		int mid = (i + j) / 2;
		long leftLocation = getLocation(i, mid);
		long rightLocation = getLocation(mid + 1, j);
		
		long max = Math.max(leftLocation, rightLocation);
		max = Math.max(max, getMidLocation(i, j, mid));
		
		return max;
	}
	private static long getMidLocation(int i, int j, int mid) {
		int toLeft = mid;
		int toRight = mid;
		
		long height = histogram[mid];
		long maxAred = height;
		
		while(i < toLeft && toRight < j) {
			if(histogram[toLeft - 1] < histogram[toRight + 1]) {
				toRight++;
				height = Math.min(height, histogram[toRight]);
			}
			else {
				toLeft--;
				height = Math.min(height, histogram[toLeft]);
			}
			maxAred = Math.max(maxAred, height * (toRight - toLeft + 1));
		}
		while(toRight < j) {
			toRight++;
			height = Math.min(height, histogram[toRight]);
			maxAred = Math.max(maxAred, height * (toRight - toLeft + 1));
		}
		while(i < toLeft) {
			toLeft--;
			height = Math.min(height, histogram[toLeft]);
			maxAred = Math.max(maxAred, height * (toRight - toLeft + 1));
		}
		return maxAred;
	}
}
