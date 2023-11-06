import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] scores = new int[N];
		double[] convertScores = new double[N];
		int max = 0;
		double sum = 0.0;
		
		for(int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			if(max < scores[i]) {
				max = scores[i];
			}
		}
		
		for(int i = 0; i <N; i++) {
			convertScores[i] = ((double)scores[i] / (double)max) * 100;
			sum += convertScores[i];
		}
		System.out.println(sum / (double)N);
		sc.close();
	}
}