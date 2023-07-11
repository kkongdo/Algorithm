import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack=new Stack<Integer>();
		StringBuilder sb=new StringBuilder();
		
		int num=0;
		int n=Integer.parseInt(br.readLine());
		
		while(n-->0) {
			int input=Integer.parseInt(br.readLine());
			if(input>num) {
				for(int i=num+1; i<=input; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				num=input;
			}
			else if(stack.peek()!=input) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}