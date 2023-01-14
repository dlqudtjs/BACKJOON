import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("Case #").append(i).append(": ")
                    .append((Integer.parseInt(st.nextToken())) + (Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
