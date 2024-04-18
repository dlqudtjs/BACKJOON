import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        int number = Integer.parseInt(br.readLine());

        while (number != 0) {
            if (number % 10 == 9) {
                arr[6]++;

            } else {
                arr[number % 10]++;
            }

            number /= 10;
        }

        arr[6] = (arr[6] % 2) + (arr[6] / 2);

        int answer = 0;
        for (int i = 0; i < 9; i++) {
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);
    }
}
