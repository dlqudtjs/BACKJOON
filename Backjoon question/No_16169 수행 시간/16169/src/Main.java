import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<List<Node>> computers = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        int maxGrade = 0;

        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int grade = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            computers.get(grade).add(new Node(i, speed));

            maxGrade = Math.max(maxGrade, grade);
        }

        int answer = topologySort(maxGrade);

        System.out.println(answer);
    }

    private static int topologySort(int maxGrade) {
        int answer = 0;

        for (int i = 1; i < maxGrade; i++) {
            for (Node to : computers.get(i + 1)) {

                for (Node from : computers.get(i)) {
                    int speed = from.speed + (int) Math.pow(from.number - to.number, 2);

                    dp[to.number] = Math.max(dp[to.number], speed + dp[from.number]);

                    if (i + 1 == maxGrade) {
                        answer = Math.max(answer, dp[to.number] + to.speed);
                    }
                }
            }
        }

        return answer;
    }
}

class Node implements Comparable<Node> {
    int number;
    int speed;

    public Node(int number, int speed) {
        this.number = number;
        this.speed = speed;
    }

    @Override
    public int compareTo(Node o1) {
        return this.speed - o1.speed;
    }
}
