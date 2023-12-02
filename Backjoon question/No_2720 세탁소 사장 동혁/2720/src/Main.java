import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());

            sb.append(getChange(c, 25)).append(" ");
            c %= 25;
            sb.append(getChange(c, 10)).append(" ");
            c %= 10;
            sb.append(getChange(c, 5)).append(" ");
            c %= 5;
            sb.append(getChange(c, 1)).append(" ").append("\n");
        }

        System.out.println(sb);
    }

    private static int getChange(int c, int unit) {
        return c / unit;
    }
}
