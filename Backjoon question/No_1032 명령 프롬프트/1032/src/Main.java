import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr[0].length(); i++) {
            boolean flag = false;
            char c = arr[0].charAt(i);

            for (int j = 1; j < n; j++) {
                if (arr[j].charAt(i) != c) {
                    flag = true;
                    break;
                }
            }

            sb.append(flag ? "?" : c);
        }

        System.out.println(sb);
    }
}
