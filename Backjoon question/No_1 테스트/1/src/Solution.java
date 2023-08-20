import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static int[] strawberry;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            strawberry = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());

                // 거리가 안 되는 딸기는 제외
                if (Math.abs(x) - distance > 0) {
                    x = Integer.MAX_VALUE;
                }

                strawberry[i] = x;
            }

            int answer = getAnswer(n, distance, strawberry);

            sb.append("Case #").append(test_case + 1).append("\n").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static int getAnswer(int n, int distance, int[] strawberry) {
        int answer = 0;
        Arrays.sort(strawberry);

        for (int i = 0; i < n; i++) {
            int start = strawberry[i];
            distance -= start;
            int end = start + distance;
            int index = i + 1;
            int count = 0;

            if (start == Integer.MAX_VALUE) {
                break;
            }

            while (true) {
                if (index >= strawberry.length || strawberry[index] > end || strawberry[index] == Integer.MAX_VALUE) {
                    break;
                }

                count++;
                index++;
            }

            answer = Math.max(answer, count + 1);
        }

        return answer;
    }
}