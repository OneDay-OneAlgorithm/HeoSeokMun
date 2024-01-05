package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14500 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] y = new int[]{-1, 0, 1, 0};
    static int[] x = new int[]{0, 1, 0, -1};

    static int n, m;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        start();

        System.out.println(answer);
    }


    public static void start() {
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                dfs(check, 1, i, j, map[i][j]);
                check[i][j] = false;
            }
        }
    }

    public static void dfs(boolean[][] check, int time, int i, int j, int sum) {
        if (time == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int cy = y[k] + i;
            int cx = x[k] + j;
            if (0 <= cy && cy < n && 0 <= cx && cx < m) {
                if (!check[cy][cx]) {
                    sum += map[cy][cx];
                    check[cy][cx] = true;
                    dfs(check, ++time, cy, cx, sum);
                    check[cy][cx] = false;
                    time--;
                    sum -= map[cy][cx];
                }
            }
        }

        for (int k = 0; k < 4; k++) {
            int cy = y[k] + i;
            int cx = x[k] + j;
            if (0 <= cy && cy < n && 0 <= cx && cx < m) {
                if (!check[cy][cx]) {
                    sum += map[cy][cx];
                    check[cy][cx] = true;
                    dfs(check, ++time, i, j, sum);
                    check[cy][cx] = false;
                    time--;
                    sum -= map[cy][cx];
                }
            }
        }

    }


    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }


}
