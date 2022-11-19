public class Main {
    public static void main(String[] args) throws Exception {
        boolean[] selfNumber = new boolean[10001];

        for (int i = 1; i < 10001; i++) { // 10000보다 작거나 같은 셀프 넘버의 범위를 찾아서 넣는게 아닌 10000의 범위를 같고 있는 배열에
                                          // 셀프넘버를 체크하는 느낌으로 풀어야 한다.
            int n = d(i);

            if (n < 10001) { // 10000 값을 넘으면 필요가 없다. (하지만 selfNumber은 [10000]까지 채워야 하기 때문에 break를 걸어선 안 된다.)
                selfNumber[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!selfNumber[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
// StringBuilder sb = new StringBuilder();
// boolean[] selftNumber = d(10001);

// for (int i = 1; i < selftNumber.length; i++) {
// if (selftNumber[i] == false) {
// sb.append(i).append("\n");
// }
// }

// System.out.println(sb);
// }

// static boolean[] d(int n) {
// boolean[] selfNumber = new boolean[n];

// for (int i = 1; i < n; i++) {
// int num = 0;
// String strNum = String.valueOf(i);

// for (int j = 0; j < strNum.length(); j++) {
// num += strNum.charAt(j) - '0';
// }

// num += i;
// if (num <= n - 1) {
// selfNumber[num] = true;
// }
// }

// return selfNumber;
