import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(addN(Integer.parseInt(br.readLine())) + "");

        bw.flush();
        bw.close();
    }

    static int addN(int n) {
        if (n == 1) {
            return 1;
        }

        return n + addN(n - 1);
    }
}
