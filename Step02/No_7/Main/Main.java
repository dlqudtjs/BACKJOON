import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int prize = 0;

        if (a != b && b != c && a != c) {
            prize = Math.max(a, Math.max(b, c)) * 100;
        } else if (a == b && b == c) {
            prize = 10000 + (a * 1000);
        } else if (a == b || a == c) {
            prize = 1000 + (a * 100);
        } else {
            prize = 1000 + (b * 100);
        }

        System.out.println(prize);
    }
}
