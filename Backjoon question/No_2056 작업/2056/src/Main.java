import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] entryCount;
    static int[] time;
    static List<List<Integer>> tasks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        entryCount = new int[n + 1];
        time = new int[n + 1];
        tasks = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            tasks.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int constuctionTime = Integer.parseInt(st.nextToken());
            time[i] = constuctionTime;

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int task = Integer.parseInt(st.nextToken());
                tasks.get(task).add(i);

                entryCount[i]++;
            }
        }

        int maxTime = topologySort();

        System.out.println(maxTime);
    }

    private static int topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n + 1];
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            result[i] = time[i];
            maxTime = Math.max(maxTime, result[i]);

            if (entryCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer i : tasks.get(current)) {
                // 쌓여온 result와 순수 건설 시간 + 쌓여온 전 건설 시간을 비교한다.
                result[i] = Math.max(result[i], time[i] + result[current]);
                maxTime = Math.max(maxTime, result[i]);

                entryCount[i]--;
                if (entryCount[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return maxTime;
    }
}
