import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int count=1;
		int[] nums=new int[N];
		int sum=1;
		int start=1, end=1;
		
		while(end !=N ) {
			if(sum==N) {
				end++;
				sum+=end;
				count++;
			}
			else if(sum>N) {
				sum-=start;
				start++;
			}
			else if(sum<N) {
				end++;
				sum+=end;
			}
		}
		System.out.println(count);
	}
}
