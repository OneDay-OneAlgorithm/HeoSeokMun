package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1002 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] t;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < n; i++) {
            int x1 = t[i][0];
            int y1 = t[i][1];
            int r1 = t[i][2];
            int x2 = t[i][3];
            int y2 = t[i][4];
            int r2 = t[i][5];

            int distance_pow = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append("\n");
            } else if (distance_pow > Math.pow(r1 + r2, 2)) {
                sb.append(0).append("\n");
            } else if (distance_pow < Math.pow(r2 - r1, 2)) {
                sb.append(0).append("\n");
            } else if (distance_pow == Math.pow(r2 - r1, 2)) {
                sb.append(1).append("\n");
            } else if (distance_pow == Math.pow(r1 + r2, 2)) {
                sb.append(1).append("\n");
            } else {
                sb.append(2).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        t = new int[n][6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
