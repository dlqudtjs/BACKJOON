import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = Integer.MIN_VALUE;

        int distance = Math.abs(w - x);
        min = Math.min(x, distance);

        distance = Math.abs(h - y);
        min = Math.min(Math.min(distance, y), min);

        System.out.println(min);
    }
}
