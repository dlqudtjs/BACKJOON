import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] str = br.readLine().getBytes();
        br.close();
        int len = str.length;
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            char c = (char) str[i];

            if (c == 'c' && i < len - 1) { // c
                if (str[i + 1] == '=' || str[i + 1] == '-') {// c=, c-
                    i++;
                }
            } else if (c == 'd' && i < len - 1) { // d
                if (str[i + 1] == '-') { // d-
                    i++;
                } else if (str[i + 1] == 'z' && i < len - 2) { // dz
                    if (str[i + 2] == '=') { // dz=
                        i += 2;
                    }
                }
            } else if ((c == 's' || c == 'z') && i < len - 1) { // s, z
                if (str[i + 1] == '=') { // s=, z=
                    i++;
                }
            } else if ((c == 'l' || c == 'n') && i < len - 1) { // l, n
                if (str[i + 1] == 'j') { // lj, nj
                    i++;
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
