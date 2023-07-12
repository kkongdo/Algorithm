import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt(); 
		int M=sc.nextInt();

		int[] arr=new int[N+1];
		
		for(int i=1; i<arr.length; i++) {
			arr[i]=arr[i-1]+sc.nextInt();
			
		}
		
		for(int n=0; n<M; n++) {
			int sum=0;
			int i=sc.nextInt(), j=sc.nextInt();
			sum=arr[j]-arr[i-1];
			System.out.println(sum);
		}
		
		sc.close();
	}
}