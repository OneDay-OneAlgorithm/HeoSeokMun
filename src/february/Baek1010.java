package february;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1010 {
    static int t;
    static int[][] p;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (int[] i : p) {
            System.out.println(dp[i[1]][i[0]]);
        }
    }

    public static void init() throws IOException {
        t = Integer.parseInt(br.readLine());
        p = new int[t][2];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
