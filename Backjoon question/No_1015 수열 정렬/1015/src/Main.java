import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                // 왼쪽 부터 비교할 때, 자신이 나오면 continue
                if (i == j) {
                    continue;
                }

                // 비교하는 수가 나보다 작다면 순위가 밀려남
                if (arr[i] > arr[j]) {
                    cnt++;
                    continue;
                }

                // 같은 수이지만, 나보다 앞에 있을 경우 순위가 밀려남
                if (arr[i] == arr[j] && i > j) {
                    cnt++;
                }

            }

            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}
