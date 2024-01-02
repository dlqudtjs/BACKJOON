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
    static int[] constructionTime;
    static int[] answer;
    static List<List<Integer>> nodes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        constructionTime = new int[n + 1];
        entryCount = new int[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            constructionTime[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());

                if (to == -1) {
                    break;
                }

                nodes.get(to).add(i);
                entryCount[i]++;
            }
        }

        topologicalSort();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (entryCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer[current] += constructionTime[current];

            for (int i = 0; i < nodes.get(current).size(); i++) {
                int next = nodes.get(current).get(i);

                answer[next] = Math.max(answer[next], answer[current]);

                entryCount[next]--;
                if (entryCount[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
