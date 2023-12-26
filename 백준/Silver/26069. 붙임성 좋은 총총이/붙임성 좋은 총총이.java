import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> mems = new HashSet<String>();
		mems.add("ChongChong");
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			String mem1 = st.nextToken();
			String mem2 = st.nextToken();
			if(mems.contains(mem1) || mems.contains(mem2)){
				mems.add(mem1);
				mems.add(mem2);
			}
		}
		System.out.println(mems.size());
	}
}