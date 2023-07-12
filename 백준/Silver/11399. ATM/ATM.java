import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] nums=new int[N];
		int[] result=new int[N];
		int ans=0;
		
		for(int i=0; i<N; i++) {
			nums[i]=sc.nextInt();
		}
		Arrays.sort(nums);
		
		for(int i=0; i<N; i++) {
			int sum=0;
			for(int j=0; j<=i; j++) {
				sum+=nums[j];
			}
			result[i]=sum;
		}
		for(int i=0; i<N; i++) {
			ans+=result[i];
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}