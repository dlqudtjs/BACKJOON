import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] paper = new boolean[100][100];

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10; k++) {
                    if (paper[j][k]) {
                        continue;
                    }

                    paper[j][k] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
