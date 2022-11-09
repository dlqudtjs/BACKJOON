import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bangkookYear = Integer.parseInt(br.readLine());
        int koreaYear = bangkookYear - 543;

        System.out.println(koreaYear);
    }
}