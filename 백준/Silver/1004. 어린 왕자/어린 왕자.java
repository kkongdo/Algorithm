import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int count = 0;
			
			int N = Integer.parseInt(br.readLine());
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean startInside = isCheckedInside(x1, y1, cx, cy, r);
				boolean endInside = isCheckedInside(x2, y2, cx, cy, r);
				
				if(startInside != endInside) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isCheckedInside(int x, int y, int cx, int cy, int r) {
		return (cx - x) * (cx - x) + (cy - y) * (cy - y) < r * r;
	}
}
