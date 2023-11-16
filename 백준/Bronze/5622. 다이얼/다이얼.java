import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder numArr = new StringBuilder();
		int count = 0;
		
		for(int i = 0; i <str.length(); i++) {
			char num = str.charAt(i);
			switch(num) {
				case 'A' : case 'B' : case 'C' :
					numArr.append(2);
					break;
				case 'D' : case 'E' : case 'F' :
					numArr.append(3);
					break;
				case 'G' : case 'H' : case 'I' :
					numArr.append(4);
					break;
				case 'J' : case 'K' : case 'L' :
					numArr.append(5);
					break;
				case 'M' : case 'N' : case 'O' :
					numArr.append(6);
					break;
				case 'P' : case 'Q' : case 'R' : case 'S' :
					numArr.append(7);
					break;
				case 'T' : case 'U' : case 'V' :
					numArr.append(8);
					break;
				case 'W' : case 'X' : case 'Y' : case 'Z' :
					numArr.append(9);
					break;
			}
		}
		for(int i = 0; i < numArr.length(); i++) {
			count +=  Integer.parseInt(numArr.substring(i, i+1)) + 1;
		}
		
		
		System.out.println(count);
		sc.close();
	}
}