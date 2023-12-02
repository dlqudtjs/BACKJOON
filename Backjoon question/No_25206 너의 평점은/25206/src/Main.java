import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int totalCredit = 0;
        double total = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken(); // 과목 이름 (필요없음)
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            total += credit * calculateGrade(grade);
            totalCredit += credit;
        }

        System.out.println(String.format("%f", total / totalCredit));
    }

    private static double calculateGrade(String grade) {

        if (grade.equals("A+")) {
            return 4.5;
        }
        if (grade.equals("A0")) {
            return 4.0;
        }
        if (grade.equals("B+")) {
            return 3.5;
        }
        if (grade.equals("B0")) {
            return 3.0;
        }
        if (grade.equals("C+")) {
            return 2.5;
        }
        if (grade.equals("C0")) {
            return 2.0;
        }
        if (grade.equals("D+")) {
            return 1.5;
        }
        if (grade.equals("D0")) {
            return 1.0;
        }

        return 0;
    }
}
