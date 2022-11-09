import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j <= i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
