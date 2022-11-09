import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int dan = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            sb.append(dan).append(" * ").append(i).append(" = ").append(dan * i).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
