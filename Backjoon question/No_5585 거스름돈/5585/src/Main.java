import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1000 - Integer.parseInt(br.readLine());
        int change = 0;

        change += n / 500;
        n %= 500;
        change += n / 100;
        n %= 100;
        change += n / 50;
        n %= 50;
        change += n / 10;
        n %= 10;
        change += n / 5;
        n %= 5;
        change += n / 1;
        n %= 1;

        System.out.println(change);
    }
}
