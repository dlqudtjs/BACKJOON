import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int round = 0;
        st.nextToken();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while (a != b) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);

            round++;
        }

        System.out.println(round);
    }
}
