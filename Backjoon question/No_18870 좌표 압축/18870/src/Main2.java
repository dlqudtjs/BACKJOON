import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] copy = arr.clone();
		Arrays.sort(copy);

		int rank = 0;
		for (int x : copy) {
			if (map.containsKey(x)) {
				continue;
			}

			map.put(x, rank++);
		}

		for (int x : arr) {
			sb.append(map.get(x)).append(" ");
		}

		System.out.println(sb);
	}
}
