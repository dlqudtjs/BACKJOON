import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute >= 45) {
            minute -= 45;
        } else {
            hour--;
            minute = 60 - (45 - minute);
            if (hour < 0) {
                hour = 23;
            }
        }

        System.out.printf("%d %d", hour, minute);
    }
}
