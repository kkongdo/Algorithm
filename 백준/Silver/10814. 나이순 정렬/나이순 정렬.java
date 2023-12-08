import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		Student[] students = new Student[N];
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students[i] = new Student(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(students, (s1 , s2) -> {
			return s1.age - s2.age;
		});
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(students[i]);
		}
		System.out.println(sb);
		
	}
	
	public static class Student {
		int age;
		String name;
		
		public Student(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}