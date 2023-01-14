import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int price = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        // int plusPrice = 0; price와 더한 값을 비교하기 위한 변수지만 뺄셈을 활용해 필요 x

        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            price -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        bw.write(price == 0 ? "Yes" : "No");

        bw.flush();
        bw.close();
        br.close();
    }
}
