package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CodeTreeWoodThin {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] direct = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] cross = new int[][]{{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static StringTokenizer st;
    static int n, m, k, c;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < m; i++) {
            growth();
            breeding();
            findMaxAndRemove();
            reduce();

        }
        System.out.println(answer);

    }

    static void growth() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for (int l = 0; l < 4; l++) {
                        int x = j + direct[l][1];
                        int y = i + direct[l][0];
                        if (0 <= x && x < n && 0 <= y && y < n && map[y][x] > 0) {
                            count++;
                        }
                    }
                    map[i][j] += count;
                }

            }
        }
    }


    static void breeding() {
        int[][] tempMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    List<int[]> list = new ArrayList<>();
                    int count = 0;
                    for (int l = 0; l < 4; l++) {
                        int x = j + direct[l][1];
                        int y = i + direct[l][0];
                        if (0 <= x && x < n && 0 <= y && y < n && map[y][x] == 0) {
                            list.add(new int[]{y, x});
                            count++;
                        }
                    }

                    if (count != 0) {
                        for (int[] l : list) {
                            tempMap[l[0]][l[1]] += map[i][j] / count;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += tempMap[i][j];
            }
        }
    }

    static int[] findMaxAndRemove() {
        int max = 0;
        int[] point = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    int temp = map[i][j];
                    for (int l = 0; l < 4; l++) {
                        for (int m = 1; m <= k; m++) {
                            int x = j + cross[l][1] * m;
                            int y = i + cross[l][0] * m;
                            if (0 <= x && x < n && 0 <= y && y < n && map[y][x] > 0) {
                                temp += map[y][x];
                            } else {
                                break;
                            }
                        }
                    }
                    if (temp > max) {
                        max = temp;
                        point[0] = i;
                        point[1] = j;
                    }
                }
            }
        }

        answer += max;
        map[point[0]][point[1]] = -11 - c;
        for (int l = 0; l < 4; l++) {
            for (int m = 1; m <= k; m++) {
                int x = point[1] + cross[l][1] * m;
                int y = point[0] + cross[l][0] * m;
                if (0 <= x && x < n && 0 <= y && y < n && (map[y][x] > 0)) {
                    map[y][x] = -11 - c;
                } else if (0 <= x && x < n && 0 <= y && y < n && (map[y][x] == 0 || map[y][x] < -10)) {
                    map[y][x] = -11 - c;
                    break;
                } else if (0 <= x && x < n && 0 <= y && y < n && map[y][x] == -1) {
                    break;
                }
            }
        }

        return point;
    }

    static void reduce() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < -10) {
                    map[i][j]++;
                    if (map[i][j] == -10) {
                        map[i][j] = 0;
                    }
                }
            }
        }

    }


    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
