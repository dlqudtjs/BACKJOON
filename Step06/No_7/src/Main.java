import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            a = ((a % 10) * 100) + (((a / 10) % 10) * 10) + (a / 100);
            b = ((b % 10) * 100) + (((b / 10) % 10) * 10) + (b / 100);
        }

        System.out.println(a > b ? a : b);
        br.close();
    }
}
