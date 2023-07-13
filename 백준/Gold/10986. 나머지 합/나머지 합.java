import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));// 사용자에게 입력받기 위한 버퍼리터
		StringTokenizer st=new StringTokenizer(br.readLine()); //입력값 중 공백을 기준으로 잘라준다.
		
		int N=Integer.parseInt(st.nextToken());	//수의 갯수
		int M=Integer.parseInt(st.nextToken()); // 나누기 할 수
		
		long[] sums=new long[N+1]; // 구간합을 저장하기 위한 배열
		long[] count=new long[M]; // 같은 나머지의 인덱스를 세기 위한 배열
		long result=0; //M으로 나누어 떨어지는 구간 i~j의 쌍의 갯수
		
		st=new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			sums[i]=(sums[i-1]+Long.parseLong(st.nextToken()))%M; //N개의 수를 입력받으면서 누적합을 M으로 나눈 나머지를 sums 배열에 저장
			if(sums[i]==0) {//0~i까지의 합을 M으로 나눈 나머지가 0인 수를 카운팅
				result++; 
			}
			count[(int)sums[i]]++; // 같은 나머지를 가진 인덱스의 수를 카운팅
		}
		
		//S[j]%M==S[i-1]%M을 만족하는 구간 i~j의 수를 결과값에 더한다.
		for(int i=0; i<M; i++) {
			if(count[i]>1) {
				result+=(count[i]*(count[i]-1)/2); // i가 나머지인 인덱스 수에서 중복을 배제한 2가지를 뽑는 수를 카운팅한다.
			}
		}
		System.out.println(result); //결과값 출력
	}
}