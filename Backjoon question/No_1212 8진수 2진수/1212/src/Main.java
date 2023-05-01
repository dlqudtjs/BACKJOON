import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readbLine();

        if (n.equals("0")) {
            System.out.println(0);
            return;
        }

        String[] binary = new String[] { "000", "001", "010", "011", "100", "101", "110", "111" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n.length(); i++) {
            sb.append(binary[n.charAt(i) - '0']);
        }

        System.out.println(sb.substring(sb.indexOf("1")));
    }
}
