import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int inputMinute = Integer.parseInt(br.readLine());

        int timeToMinute = (hour * 60) + minute + inputMinute;

        System.out.printf("%d %d", (timeToMinute / 60) % 24, timeToMinute % 60);

        // hour = (timeToMinute / 60) % 24;
        // minute = timeToMinute % 60;
        // System.out.println(hour + " " + minute); 원본 훼손
    }
}
