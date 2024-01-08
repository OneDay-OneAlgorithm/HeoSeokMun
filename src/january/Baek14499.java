package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14499 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;
    static int[] point = new int[2];
    static int[][] map;
    static int[] command;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        for (int i : command) {
            boolean change = false;
            switch (i) {
                case 1:
                    if (point[1] + 1 < m) {
                        Dice.go(1);
                        point[1] = point[1] + 1;
                        change = true;
                    }
                    break;
                case 2:
                    if (point[1] - 1 >= 0) {
                        Dice.go(2);
                        point[1] = point[1] - 1;
                        change = true;
                    }
                    break;
                case 3:
                    if (point[0] - 1 >= 0) {
                        Dice.go(3);
                        point[0] = point[0] - 1;
                        change = true;
                    }
                    break;
                case 4:
                    if (point[0] + 1 < n) {
                        Dice.go(4);
                        point[0] = point[0] + 1;
                        change = true;
                    }
                    break;
            }

            if (change) {
                if (map[point[0]][point[1]] == 0) {
                    map[point[0]][point[1]] = Dice.down;
                } else {
                    Dice.down = map[point[0]][point[1]];
                    map[point[0]][point[1]] = 0;
                }
                sb.append(Dice.up).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        point[0] = Integer.parseInt(st.nextToken());
        point[1] = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        command = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static class Dice {
        static int up = 0;
        static int north = 0;
        static int east = 0;
        static int west = 0;
        static int south = 0;
        static int down = 0;

        static void go(int i) {
            int temp;
            switch (i) {
                case 1:
                    temp = up;
                    up = west;
                    west = down;
                    down = east;
                    east = temp;
                    break;
                case 2:
                    temp = up;
                    up = east;
                    east = down;
                    down = west;
                    west = temp;
                    break;
                case 3:
                    temp = up;
                    up = south;
                    south = down;
                    down = north;
                    north = temp;
                    break;
                case 4:
                    temp = up;
                    up = north;
                    north = down;
                    down = south;
                    south = temp;
                    break;
            }
        }
    }


}
