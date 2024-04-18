import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        recursion(0, 0);

        System.out.println(sb);
    }

    private static void recursion(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(dp[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth != 0 && i + 1 < dp[depth - 1]) {
                continue;
            }

            dp[depth] = i + 1;
            recursion(start + 1, depth + 1);
        }
    }
}
