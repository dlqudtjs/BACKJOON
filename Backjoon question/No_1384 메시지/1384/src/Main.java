import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            sb.append("Group ").append(count++).append("\n");

            boolean[][] check = new boolean[n][n - 1];
            Map<Integer, String> names = new HashMap<>();
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                names.put(i, st.nextToken());

                for (int j = 0; j < n - 1; j++) {
                    check[i][j] = st.nextToken().equals("P") ? false : true;

                    if (check[i][j]) {
                        flag = true;
                    }
                }
            }

            if (!flag) {
                sb.append("Nobody was nasty\n\n");
                continue;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (check[i][j]) {
                        int number = i - (j + 1);
                        if (number < 0) {
                            number = n + number;
                        }

                        sb.append(names.get(number)).append(" was nasty about ").append(names.get(i)).append("\n");
                    }
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
