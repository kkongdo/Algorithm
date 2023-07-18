import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int[] nums=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int M=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int findNum=Integer.parseInt(st.nextToken());
			int lc=0;
			int rc=N-1;
			do {
				int cc=(lc+rc)/2;
				if(nums[cc]==findNum) {
					System.out.println(1);
					break;
				}
				else {
					if(nums[cc]>findNum) {
						rc=cc-1;
					}
					else if(nums[cc]<findNum) {
						lc=cc+1;
					}
				}
			}while(lc<=rc);
			if(lc>rc) {
				System.out.println(0);
			}
		}
	}
}
