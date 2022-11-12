import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int minValue = array[0];
        int maxValue = array[0];
        for (int value : array) {
            minValue = (value < minValue) ? value : minValue;
            maxValue = (value > maxValue) ? value : maxValue;
        }

        System.out.printf("%d %d", minValue, maxValue);

        br.close();
    }
}
