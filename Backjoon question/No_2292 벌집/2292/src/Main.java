import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 1;
        int range = 1;

        while (n > range) {
            range += (count * 6);
            count++;
        }

        System.out.println(count);
    }
}

/*
 * 2 ~ 8 = 1
 * 
 */