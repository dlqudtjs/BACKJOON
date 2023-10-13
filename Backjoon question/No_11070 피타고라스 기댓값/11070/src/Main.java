import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] score = new int[n][2];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());

                score[a - 1][0] += p;
                score[a - 1][1] += q;
                score[b - 1][0] += q;
                score[b - 1][1] += p;
            }

            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (score[j][0] == 0 && score[j][1] == 0) {
                    min = 0;

                    continue;
                }

                double exp = Math.pow(score[j][0], 2) / (Math.pow(score[j][0], 2) + Math.pow(score[j][1], 2));
                exp *= 1000;

                max = Math.max(max, (int) exp);
                min = Math.min(min, (int) exp);
            }

            sb.append(max).append("\n");
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
