import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        switch (input) {
            case "A+":
                sb.append("4.3");
                break;
            case "A0":
                sb.append("4.0");
                break;
            case "A-":
                sb.append("3.7");
                break;
            case "B+":
                sb.append("3.3");
                break;
            case "B0":
                sb.append("3.0");
                break;
            case "B-":
                sb.append("2.7");
                break;
            case "C+":
                sb.append("2.3");
                break;
            case "C0":
                sb.append("2.0");
                break;
            case "C-":
                sb.append("1.7");
                break;
            case "D+":
                sb.append("1.3");
                break;
            case "D0":
                sb.append("1.0");
                break;
            case "D-":
                sb.append("0.7");
                break;
            case "F":
                sb.append("0.0");
                break;
        }

        System.out.println(sb);
    }
}
