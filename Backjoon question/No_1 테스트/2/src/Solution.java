import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            int[] strawberry = new int[n];

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
        Arrays.sort(strawberry);
        int answer = 0;
        int lastIndex = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int start = strawberry[i];
            int end;
            if (start < 0) {
                end = Math.max(distance - (Math.abs(start) * 2), (distance - Math.abs(start)) / 2);
                end = end <= 0 ? 0 : end;
            } else {
                end = start + (distance - start);
            }
            int index = lastIndex;

            if (start == Integer.MAX_VALUE) {
                break;
            }

            while (true) {
                if (index >= n || strawberry[index] > end) {
                    lastIndex = index;
                    break;
                }

                index++;
                sum++;
            }

            // i가 0이 아니면 이전 딸기를 빼줌
            sum = i != 0 ? sum - 1 : sum;

            answer = Math.max(answer, sum);
        }

        return answer;
    }
}