import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int openCount = 0;
            boolean flag = false;

            for (char c : br.readLine().toCharArray()) {
                openCount = (c == '(') ? ++openCount : --openCount;

                if (openCount < 0) {
                    flag = true;
                    break;
                }
            }

            sb.append(flag ? "NO" : openCount == 0 ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
