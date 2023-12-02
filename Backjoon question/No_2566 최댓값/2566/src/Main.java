import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = -1;
        int row = 0;
        int colums = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n > max) {
                    row = i;
                    colums = j;
                    max = n;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        sb.append(row + 1).append(" ").append(colums + 1);

        System.out.println(sb);
    }
}
