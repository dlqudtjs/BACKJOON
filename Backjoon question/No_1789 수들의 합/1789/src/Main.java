import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        int count = 0;
        int i = 1;

        while (n > 0) {
            n -= i++;
            count++;
        }

        System.out.println(n == 0 ? count : count - 1);
    }
}

/*
 * 20 -> 1, 2, 3, 4, 5 = 15이다.
 * 이때, 6을 더하게 되면 1이 오버되고 앞서 구한 1을 빼고 6을 넣으면 최대 값이 완성된다.
 * 따라서, n이 0일 땐 딱 맞게 구한 것이고, 남을 경우 뒤에서 한 수를 뺀 후 넣은 값이 된다.(count - 1)
 */