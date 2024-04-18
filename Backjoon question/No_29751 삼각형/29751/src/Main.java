import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double w = Integer.parseInt(st.nextToken());
        double h = Integer.parseInt(st.nextToken());

        System.out.printf("%.1f", (w * h) / 2);
    }
}
