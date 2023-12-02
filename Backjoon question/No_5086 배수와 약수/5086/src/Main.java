import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0) {
                break;
            }

            if (b % a == 0) {
                sb.append("factor").append("\n");
                continue;
            }

            if (a % b == 0) {
                sb.append("multiple").append("\n");
                continue;
            }

            sb.append("neither").append("\n");
        }

        System.out.println(sb);
    }
}
