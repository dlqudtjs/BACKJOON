import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 1;
            for (int j = 0; j < b; j++) {
                result = a * result % 10;
            }

            // 0일 땐, 10으로 처리 (10번 컴퓨터)
            result = result == 0 ? 10 : result;

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}