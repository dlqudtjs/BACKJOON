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

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            sb.append(printGridGraphPath(m, n));
        }

        System.out.println(sb);
    }

    public static String printGridGraphPath(int m, int n) {
        StringBuilder sb = new StringBuilder();

        // 실패하는 경우는 없다.
        sb.append("1").append("\n");

        // 왼쪽, 오른쪽 한 번씩 이동하기 위해 flag 선언
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            // 왼쪽에서 오른쪽으로 이동
            if (!flag) {
                for (int c = 1; c < n; c++) {
                    sb.append("(").append(i).append(",").append(c).append(")").append("\n");
                }
            } else {
                // 오른쪽에서 왼쪽으로 이동
                for (int c = n - 1; c >= 1; c--) {
                    sb.append("(").append(i).append(",").append(c).append(")").append("\n");
                }
            }

            // 방향 전환을 위해 flag 반전
            flag = !flag;
        }

        // m - 1, 0 부터 0, 0까지 탐색
        for (int i = m - 1; i >= 0; i--) {
            sb.append("(").append(i).append(",").append(0).append(")").append("\n");
        }

        return sb.toString();
    }
}