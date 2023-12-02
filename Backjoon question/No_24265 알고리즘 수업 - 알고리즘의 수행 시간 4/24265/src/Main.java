import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine()) - 1;

        System.out.println((n * (n + 1) / 2));
        System.out.println(2);
    }
}

/*
 * notion 등차수열의 합 참고*
 */
