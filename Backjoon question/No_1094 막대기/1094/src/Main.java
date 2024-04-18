import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int[] sticks = new int[] { 64, 32, 16, 8, 4, 2, 1 };
        int count = 0;

        for (int i = 0; i < sticks.length; i++) {
            if (x >= sticks[i]) {
                x -= sticks[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
