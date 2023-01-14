import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] check = new int[26];
        Arrays.fill(check, -1);

        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 97;
            check[n] = check[n] == -1 ? i : check[n];
        }

        for (int i = 0; i < 26; i++) {
            sb.append(check[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
