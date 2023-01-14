import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] array = new int[9];
        int maxValue = 0;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
                index = i + 1;
            }
        }

        sb.append(maxValue).append("\n").append(index);
        System.out.println(sb);

        br.close();
    }
}
