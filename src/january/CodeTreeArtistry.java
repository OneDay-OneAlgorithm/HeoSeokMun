package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeTreeArtistry {
    static int n;
    static int answer = 0;
    static int[] y = new int[]{-1, 0, 1, 0};
    static int[] x = new int[]{0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static List<List<int[]>> groups;


    public static void main(String[] args) throws IOException {
        init();

        for (int k = 0; k < 4; k++) {
            groups = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        grouping(i, j, visited);
                    }
                }
            }

            calculate();

            moveCross();
            moveSquare();
        }

        System.out.println(answer);
    }

    static void moveSquare() {
        int p = n / 2;
        int[][] s = new int[][]{{0, 0}, {p + 1, 0}, {0, p + 1}, {p + 1, p + 1}};

        int[][] temp = new int[p][p];

        for (int i = 0; i < 4; i++) {
            int y = s[i][0];
            int x = s[i][1];

            int l = 0;

            for (int j = y; j < y + p; j++) {
                int m = 0;
                for (int k = x; k < x + p; k++) {
                    temp[l][m] = map[j][k];
                    m++;
                }
                l++;
            }

            l = p - 1;
            for (int k = x; k < x + p; k++) {
                int m = 0;
                for (int j = y; j < y + p; j++) {
                    map[j][k] = temp[l][m];
                    m++;
                }
                l--;
            }
        }

    }

    static void moveCross() {
        int[] temp = new int[n];
        int p = n / 2;
        int k = n - 1;
        for (int i = 0; i < n; i++) {
            temp[i] = map[p][i];
            map[p][i] = map[i][p];
        }

        for (int i = 0; i < n; i++) {
            map[k][p] = temp[i];
            k--;
        }

    }

    static void calculate() {
        for (int i = 0; i < groups.size() - 1; i++) {
            List<int[]> a = groups.get(i);
            for (int j = i + 1; j < groups.size(); j++) {
                List<int[]> b = groups.get(j);
                int temp = 0;
                for (int[] l : a) {
                    for (int[] m : b) {
                        if (Math.abs(l[0] - m[0]) + Math.abs(l[1] - m[1]) == 1) {
                            temp++;
                        }
                    }
                }
                int num1 = map[a.get(0)[0]][a.get(0)[1]];
                int num2 = map[b.get(0)[0]][b.get(0)[1]];

                answer += (groups.get(i).size() + groups.get(j).size()) * num1 * num2 * temp;
            }
        }
    }


    static void grouping(int i, int j, boolean[][] visited) {
        Deque<int[]> deque = new ArrayDeque<>();

        List<int[]> list = new ArrayList<>();
        visited[i][j] = true;
        deque.add(new int[]{i, j});
        list.add(new int[]{i, j});

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int k = 0; k < size; k++) {
                int[] current = deque.remove();

                for (int l = 0; l < 4; l++) {
                    int cy = current[0] + y[l];
                    int cx = current[1] + x[l];

                    if (cy < 0 || cy >= n || cx < 0 || cx >= n || visited[cy][cx]) {
                        continue;
                    }

                    if (map[i][j] == map[cy][cx]) {
                        visited[cy][cx] = true;
                        list.add(new int[]{cy, cx});
                        deque.add(new int[]{cy, cx});
                    }
                }
            }
        }
        groups.add(list);
    }


    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
