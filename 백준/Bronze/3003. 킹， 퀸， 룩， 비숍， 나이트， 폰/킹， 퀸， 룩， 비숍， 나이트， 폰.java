import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] chess = {1, 1, 2, 2, 2, 8};
		int[] chessCount = new int[6];
		int[] answerCount = new int[6];
		
		for(int i = 0; i < chessCount.length; i++) {
			chessCount[i] = sc.nextInt();
		}
		for(int i = 0; i < chessCount.length; i++) {
			if(chess[i] == chessCount[i]) {
				answerCount[i] = 0;
			}
			else if(chess[i] > chessCount[i]) {
				answerCount[i] = chess[i] - chessCount[i];
			}
			else if(chess[i] < chessCount[i]) {
				answerCount[i] = chess[i] - chessCount[i];
			}
		}
		for(int answer : answerCount) {
			System.out.print(answer + " ");
		}
		sc.close();
	}
}