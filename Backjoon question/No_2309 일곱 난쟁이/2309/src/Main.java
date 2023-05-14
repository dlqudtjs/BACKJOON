import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr = new int[9];
    static int[] answer = new int[7];
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, 0);

        Arrays.sort(answer);

        for (int n : answer) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int count, int sum) {
        if (flag) {
            return;
        }

        if (count == 7) {
            if (sum == 100) {
                flag = true;
            }

            return;
        }

        if (depth >= 9 || sum > 100) {
            return;
        }

        answer[count] = arr[depth];
        /*
         * 자기 자신을 뽑았을 때
         */
        dfs(depth + 1, count + 1, sum + arr[depth]);

        /*
         * 자기 자신을 안 뽑았을 때
         * dpeth(깊이)는 깊어지기 때문에 + 1를 하지만(원본 배열에서 index 역할을 함)
         * (따라서, depth는 arr를 순환하는 index 역할이기 때문에 계속 늘어남. (범위 처리해줘야 함, 42번 줄))
         * count는 + 1를 하지 않는다, 이유는 자기 자신을 뽑고 값을 설정한 count를(46번 줄) 그대로 매개변수로 넘겨주어
         * 다음 함수에서 count를 설정하기 때문에 자기 자신을 뽑지 않게 된다. (count는 조합 완성 배열의 index 역할을 함)
         * (count == 7 이라면 조합이 완성되는 이유이다.)
         */
        dfs(depth + 1, count, sum);
    }
}
