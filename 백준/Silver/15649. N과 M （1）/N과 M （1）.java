import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		nums=new int[N];
		result=new int[M];
		visited=new boolean[nums.length];
		
		for(int i=0; i<N; i++) {
			nums[i]=i+1;
		}
		
		recur(0);
		sc.close();
	}

	private static void recur(int depth) {
		if(depth==M) {
			print();
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if(visited[i]==false) {
				result[depth]=nums[i];
				visited[i]=true;
				recur(depth+1);
				visited[i]=false;
			}
		}
	}

	private static void print() {
		for(int num : result) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
}
