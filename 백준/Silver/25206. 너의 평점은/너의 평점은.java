import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0.0, total = 0.0; 
		// sum : 학점*과목평점의 합, total : 과목평점
		
		for(int i = 0; i < 20; i++) {
			String str = sc.next(); //과목명
			double num = sc.nextDouble(); //학점
			String grade = sc.next(); //과목평점
			double convertNum; //학점 * 과목평점
			
			if(grade.equals("P")) {
				continue;
			}
			else {
				convertNum = convert(grade);
			}
			total += num;
			sum += (num * convertNum);
		}
		System.out.printf("%.6f",(sum / total));
		
		sc.close();
	}

	private static double convert(String grade) {
		switch(grade) {
			case "A+" :
				return 4.5;
			case "A0" :
				return  4.0;
			case "B+" :
				return 3.5;
			case "B0" :
				return  3.0;
			case "C+" :
				return 2.5;
			case "C0" :
				return  2.0;
			case "D+" :
				return 1.5;
			case "D0" :
				return  1.0;
			case "F" :
				return 0.0;
			default :
		}
		return 0.0;
	}
}
