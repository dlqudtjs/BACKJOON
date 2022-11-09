import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        String B = in.next();

        in.close();

        System.out.println(A * (B.charAt(2) - '0'));
        System.out.println(A * (B.charAt(1) - '0'));
        System.out.println(A * (B.charAt(0) - '0'));
        System.out.println(A * Integer.parseInt(B));

        /*
         * 성능 개선
         * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         * int firstValue = Integer.parseInt(br.readLine());
         * int secondValue = Integer.parseInt(br.readLine());
         * 
         * System.out.println(firstValue * (secondValue % 10));
         * System.out.println(firstValue * ((secondValue % 100) / 10));
         * System.out.println(firstValue * (secondValue / 100));
         * System.out.println(firstValue * secondValue);
         * 
         * br.close();
         */
    }
}
