import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[m];

        recursion(n, m, 0);

        System.out.println(sb);
    }

    private static void recursion(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(dp[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            dp[depth] = i + 1;
            recursion(n, m, depth + 1);
        }
    }
}
