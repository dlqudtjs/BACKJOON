import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        dfs(0, n);

        System.out.println(sb);
    }

    private static void dfs(int depth, int n) {
        if (n == depth) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[depth] = i + 1;
                visited[i] = true;
                dfs(depth + 1, n);
                visited[i] = false;
            }
        }
    }
}
