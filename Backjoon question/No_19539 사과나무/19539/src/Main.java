import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());

            cnt += temp / 2;
            sum += temp;
        }

        System.out.println(sum % 3 != 0 ? "NO" : cnt >= sum / 3 ? "YES" : "NO");
    }
}

/*
 * 1, 2 물뿌리개를 동시에 사용해야 하기 때문에 합이 3의 배수가 아닐 땐 "NO"이다.
 * 제시된 나무 / 2 (2물뿌리개) 의 합이 >= sum / 3 일 때, "YES"이다.
 * 이는, 1, 2, 1, 2 -> cnt = 2, sum / 3 = 2, 2 >= 2로 "YES"이며,
 * 1, 3, 1, 3, 1 -> cnt = 2, sum / 3 = 3, 2 >= 3으로 "NO"이다.
 * 이러한 규칙을 봤을 때 cnt(2물 뿌리개의 횟수) >= sum / 3이라면 "YES"이다.
 * 여기서 헷갈린 부분은 2로 나누면 1물뿌리개와 비율이 맞지 않은 경우는 없을까? 하는 문제였다.
 * 하나씩 해보자.
 * 2 -> 1 (물뿌리개 횟수)
 * 3 -> 1, 4 -> 2, 5 -> 2, 6 -> 3이며, 6같은 경우에는 3으로, 2와 1이 자동으로 같이 뿌려지는 것을 알 수 있다.
 * 그렇다면 5같은 경우에는 어떻게 할까? 5의 경우에는 2물뿌리개를 2번 사용한다. 이때, 나무 그룹의 총 합이 3으로 나누어 떨어진다면
 * sum / 3 과정에서, 1, 2을 함께 사용한 횟수를 비교하기 때문에 2물뿌리개 횟수와 비교하면 된다.
 * 그렇기 때문에 sum / 3은 2물뿌리개의 횟수(1물뿌리개도 포함돼어 있음)와 비교한 후 같거나 작다면 성립한다는 것이다.
 */