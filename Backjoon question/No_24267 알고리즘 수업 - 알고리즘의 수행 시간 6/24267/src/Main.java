import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(n * (n - 1) * (n - 2) / 6);
        System.out.println(3);
    }
}

/*
 * 사실 못 풀겠다. ㅎ
 */