package february;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2798 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] p;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int i, int index, int sum) {
        if (i == 3) {
            if (sum <= m) {
                answer = Math.max(answer, sum);
            }
            return;
        }

        if (index == n) {
            return;
        }

        dfs(i + 1, index + 1, p[index] + sum);
        dfs(i, index + 1, sum);
    }


}
