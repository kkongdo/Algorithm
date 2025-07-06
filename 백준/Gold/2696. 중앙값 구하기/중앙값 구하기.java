import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int M = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

			List<Integer> medians = new ArrayList<>();
			int readCount = 0;

			StringTokenizer st = new StringTokenizer("");

			while (readCount < M) {
				if (!st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}

				int num = Integer.parseInt(st.nextToken());
				readCount++;

				if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
					maxHeap.offer(num);
				} else {
					minHeap.offer(num);
				}

				if (maxHeap.size() > minHeap.size() + 1) {
					minHeap.offer(maxHeap.poll());
				} else if (minHeap.size() > maxHeap.size()) {
					maxHeap.offer(minHeap.poll());
				}

				if (readCount % 2 == 1) {
					medians.add(maxHeap.peek());
				}
			}

			System.out.println(medians.size());

			for (int i = 0; i < medians.size(); i++) {
				System.out.print(medians.get(i));
				if ((i + 1) % 10 == 0 || i == medians.size() - 1) {
					System.out.println();
				} else {
					System.out.print(" ");
				}
			}
		}
	}
}