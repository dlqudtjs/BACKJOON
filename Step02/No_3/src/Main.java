import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        System.out.println(year % 4 == 0 ? year % 400 == 0 ? "1" : year % 100 != 0 ? "1" : "0" : "0");
    }
}
