import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < K; i++) { // 전체 로직을 돌리는 테이스 케이스 반복문
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 책의 수 (책의 번호는 1 ~ N 까지 순서대로 부여됨)
            int M = Integer.parseInt(st.nextToken()); // M명의 신청서 수

            Student[] students = new Student[M + 1]; // 책의 번호가 1부터 시작하기 때문에 M + 1을 하였음.
            students[0] = new Student(0, 0); // 0인덱스는 버림

            for (int j = 1; j <= M; j++) {
                st = new StringTokenizer(br.readLine()); // 받을 수 있는 책의 범위 (a ~ b)
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                students[j] = new Student(a, b);
            }

            Arrays.sort(students, new Comparator<Student>() {

                /*
                 * 책을 받을 수 있는 범위는 a ~ b 까지이다.
                 * 신청서의 순서를 1. b 오름차순 2. a 오름차순 순으로 정하였다.
                 * ex) 2 2, 1 2, 1 3의 신청서를 1. a 2. b오름차순으로 했다고 가정했을 때
                 * 1 2, 1 3, 2 2가 되며 마지막 2 2를 받지못해 2명 밖에 나눠주지 못하게 된다 (3명까지 가능)
                 * 하지만 b -> a 오름차순을 했을 경우에는 1 2, 2 2, 1 3가 되고 3명 모두 나눠줄 수 있게 된다.
                 * 이와 같이 자신이 받을 수 있는 수 부터 책을 받게 된다.
                 */
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.b == o2.b) {
                        return o1.a - o1.a;
                    }

                    return o1.b - o2.b;
                }
            });

            int count = 0; // answer
            boolean[] check = new boolean[N + 1]; // 해당 책을 빌렸는지 확인하는 boolean 배열

            // 처음에는 책의 범위 1 ~ N 까지 순서대로 올라가며 책을 나눠주려는 로직을 생각하였으나
            // 다 나눠주지 못하는 상황과 로직이 복잡해지기 때문에 다른 로직을 생각하였다.
            // 다음 로직은 책을 나눠주는 것에 초점이 아닌 위에서 정렬한 신청서를 순서대로 올라가며
            // 신청서의 범위의 책을 빌려 check의 표시는 형식으로 바꿨다. 즉 책의 초점이 아닌 신청서의 초점을 맞췄다.
            for (int j = 1; j <= M; j++) {
                int a = students[j].a;
                int b = students[j].b;

                for (int k = a; k <= b; k++) {
                    if (!check[k]) {
                        check[k] = true;
                        count++;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static class Student {
        int a;
        int b;

        public Student(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
