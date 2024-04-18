import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] entryCount;
    static List<List<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static boolean[] flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        entryCount = new int[n + 1];
        visited = new boolean[n + 1];
        flag = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            entryCount[to]++;
            nodes.get(from).add(to);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                dfs(i);
            }
        }
    }

    private static void dfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

    }
}
