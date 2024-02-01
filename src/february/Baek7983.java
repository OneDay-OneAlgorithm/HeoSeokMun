package february;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek7983 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] p;

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(p, (a1, a2) -> a2[1] - a1[1]);
        int lastPoint = p[0][1];

        for (int i = 0; i < n; ++i) {
            if (p[i][1] <= lastPoint) {
                lastPoint = p[i][1] - p[i][0];
            } else {
                lastPoint -= p[i][0];
            }
        }
        System.out.println(lastPoint);

    }

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        p = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
