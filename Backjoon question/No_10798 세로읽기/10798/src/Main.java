import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] strArray = new String[5];

        for (int i = 0; i < 5; i++) {
            strArray[i] = br.readLine();
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (strArray[j].length() > i) {
                    sb.append(strArray[j].charAt(i));
                }
            }
        }

        System.out.println(sb);
    }
}
