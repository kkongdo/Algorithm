import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		List<Integer> weight1 = new ArrayList<>();
		List<Integer> weight2 = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (i < N / 2) {
				weight1.add(Integer.parseInt(st.nextToken()));
			} else {
				weight2.add(Integer.parseInt(st.nextToken()));
			}
		}
		List<Integer> sum1 = new ArrayList<>();
		List<Integer> sum2 = new ArrayList<>();

		DFS(0, 0, weight1, sum1);
		DFS(0, 0, weight2, sum2);

		Collections.sort(sum2);
		int answer = 0;
		for (int i = 0; i < sum1.size(); i++) {
			int searchValue = C - sum1.get(i);
			answer += binarySearch(sum2, searchValue) + 1;
		}
		System.out.println(answer);
	}

	private static int binarySearch(List<Integer> sum, int target) {
		int left = 0;
		int right = sum.size() - 1;
		int mid = 0;
		int answer = -1;

		while (left <= right) {
			mid = (left + right) / 2;
			if (sum.get(mid) <= target) {
				answer = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}

		return answer;
	}

	private static void DFS(int index, int sum, List<Integer> weight, List<Integer> answer) {
		if (sum > C) {
			return;
		}
		if (index == weight.size()) {
			answer.add(sum);
			return;
		}

		DFS(index + 1, sum + weight.get(index), weight, answer);
		DFS(index + 1, sum, weight, answer);
	}
}
