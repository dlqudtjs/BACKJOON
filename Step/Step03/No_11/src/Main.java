import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            int a = str.charAt(0) - '0';
            int b = str.charAt(2) - '0';

            sb.append(a + b).append("\n");
        }

        System.out.println(sb);
        br.close();

        // EOF 처리를 해야하는 문제! try catch를 써도 되지만, null값 처리가 더 자연스러운 거 같음!
    }
}
