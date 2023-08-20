import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution2 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            PriorityQueue<Integer> left = new PriorityQueue<Integer>();
            PriorityQueue<Integer> right = new PriorityQueue<Integer>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                (x < 0 ? left : right).add(Math.abs(x));
            }

            int Answer = Math.max(getAnswer(left, right, distance), getAnswer(right, left, distance));

            sb.append("Case #").append(test_case + 1).append("\n").append(Answer).append("\n");
        }

        System.out.println(sb);
    }

    public static int getAnswer(PriorityQueue<Integer> first, PriorityQueue<Integer> second, int distance) {
        PriorityQueue<Integer> tempFirst = new PriorityQueue<Integer>(first);
        PriorityQueue<Integer> tempSecond = new PriorityQueue<Integer>(second);
        int Answer = 0;
        int current = 0;
        // 왼쪽 이동
        while (!tempFirst.isEmpty()) {
            int x = tempFirst.poll();

            if (x <= distance + current) {
                distance = (current + distance) - x;
                current = x;
                Answer++;
                continue;
            }

            break;
        }

        // 가운데로 이동
        distance -= current;
        current = 0;

        // 오른쪽 이동
        while (!tempSecond.isEmpty()) {
            int x = tempSecond.poll();

            if (x == 0) {
                Answer++;
                continue;
            }

            if (x <= distance + current) {
                distance = (current + distance) - x;
                current = x;
                Answer++;
                continue;
            }

            break;
        }

        return Answer;
    }
}