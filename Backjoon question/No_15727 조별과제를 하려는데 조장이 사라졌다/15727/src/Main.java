import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        int answer = l % 5 == 0 ? l / 5 : (l / 5) + 1;

        System.out.println(answer);
    }
}
