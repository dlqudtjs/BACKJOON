import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // 값은 나오나 백준애서 오답처리 됨 왜?!!!!?!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += System.in.read() - 48;
        }

        System.out.println(sum);
    }
}
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// br.readLine();

// int sum = 0;

// for (int value : br.readLine().getBytes()) {
// sum += value - 48;
// }

// System.out.println(sum);