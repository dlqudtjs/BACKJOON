import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(getBags(n));
    }

    public static int getBags(int n) {
        if (n == 4 || n == 7) { // 8이상부터 골드바흐의 추측이 적용되며, 4, 7은 표현이 불가능하다.
            return -1;
        } else if (n % 5 == 0) { // 5의 배수일 경우 딱 맞아 떨어진다.
            return n / 5;
        } else if ((n % 5 == 1) || (n % 5 == 3)) { // 표로 정리하면 이와 같은 규칙이 나옴.
            return (n / 5) + 1;
        } else if ((n % 5 == 2) || (n % 5 == 4)) { // 표로 정리하면 이와 같은 규칙이 나옴.
            return (n / 5) + 2;
        }

        return -1;
    }
}

/*
 * 골드바흐의 추측 : 2보다 큰 모든 짝수는 두 소수의 합으로 표현가능하다.
 * 위 이론에 적용해본다면 3, 5 합, 8 이상의 모든 자연수는 소수의 합으로 나타낼 수 있다.
 */