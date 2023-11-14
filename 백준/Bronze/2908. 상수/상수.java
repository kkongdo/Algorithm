import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num1.length(); i++) {
			sb.append(num1.charAt(i));
		}
		String revNum1 = sb.reverse().toString();
		
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < num1.length(); i++) {
			sb2.append(num2.charAt(i));
		}
		String revNum2 = sb2.reverse().toString();
		
		if(Integer.parseInt(revNum1) > Integer.parseInt(revNum2)) {
			System.out.println(revNum1);
		}else {
			System.out.println(revNum2);
		}
		
		sc.close();
	}
}
