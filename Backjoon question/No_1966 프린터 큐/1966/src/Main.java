import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] dp = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dp[j] = Integer.parseInt(st.nextToken());
                queue.add(j);
                // num과 중요도 매핑
                map.put(j, dp[j]);
            }

            Arrays.sort(dp);

            // 가장 중요도가 높은 인덱스
            int index = n - 1;
            int count = 0;

            while (true) {
                if (dp[index] == map.get(queue.peek())) {
                    count++;
                    if (queue.peek() == m) {
                        break;
                    }
                    queue.poll();
                    index--;
                } else {
                    queue.add(queue.poll());
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
