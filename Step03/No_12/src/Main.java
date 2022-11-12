import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int answer = (input < 10) ? (input * 10) : input; // 10 이하면 0붙이기

        int n = answer;
        int cnt = 0;

        while (true) {
            cnt++;
            n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);

            if (answer == n) {
                break;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}