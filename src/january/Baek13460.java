package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek13460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int answer = 0;
    static char[][] map;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        Bead initBead = init();
        start(initBead);

        System.out.println(check ? answer : -1);
    }


    public static void start(Bead bead) {
        Deque<Bead> deque = new ArrayDeque<>();
        deque.add(bead);
        while (answer < 10) {
            int size = deque.size();
            answer++;
            for (int i = 0; i < size; i++) {
                Bead poll = deque.poll();
                Bead upBead = new Bead(poll.b, poll.r);
                if (upBead.up() != null) {
                    deque.add(upBead);
                }
                Bead rightBead = new Bead(poll.b, poll.r);
                if (rightBead.right() != null) {
                    deque.add(rightBead);
                }
                Bead downBead = new Bead(poll.b, poll.r);
                if (downBead.down() != null) {
                    deque.add(downBead);
                }
                Bead leftBead = new Bead(poll.b, poll.r);
                if (leftBead.left() != null) {
                    deque.add(leftBead);
                }
                if (check) {
                    return;
                }
            }
        }

    }


    public static class Bead {
        int[] b;
        int[] r;

        public Bead(int[] b, int[] r) {
            this.b = Arrays.copyOf(b, b.length);
            this.r = Arrays.copyOf(r, r.length);
        }

        Bead up() {
            boolean lineCheck = b[0] < r[0];
            while (true) {
                int by = b[0] - 1;
                if (by >= 0 && map[by][b[1]] == '.') {
                    b[0] = by;
                } else if (map[by][b[1]] == 'O') {
                    return null;
                } else {
                    break;
                }
            }

            while (true) {
                int ry = r[0] - 1;
                if (ry >= 0 && map[ry][r[1]] == '.') {
                    r[0] = ry;
                } else if (map[ry][r[1]] == 'O') {
                    check = true;
                    return null;
                } else {
                    break;
                }
            }

            if (b[0] == r[0] && b[1] == r[1]) {
                if (lineCheck) {
                    r[0]++;
                } else {
                    b[0]++;
                }
            }

            return this;
        }

        Bead right() {
            boolean lineCheck = b[1] < r[1];
            while (true) {
                int bx = b[1] + 1;
                if (bx < m && map[b[0]][bx] == '.') {
                    b[1] = bx;
                } else if (map[b[0]][bx] == 'O') {
                    return null;
                } else {
                    break;
                }
            }

            while (true) {
                int rx = r[1] + 1;
                if (rx < m && map[r[0]][rx] == '.') {
                    r[1] = rx;
                } else if (map[r[0]][rx] == 'O') {
                    check = true;
                    return null;
                } else {
                    break;
                }
            }

            if (b[0] == r[0] && b[1] == r[1]) {
                if (lineCheck) {
                    b[1]--;
                } else {
                    r[1]--;
                }
            }
            return this;
        }

        Bead down() {
            boolean lineCheck = b[0] < r[0];
            while (true) {
                int by = b[0] + 1;
                if (by < n && map[by][b[1]] == '.') {
                    b[0] = by;
                } else if (map[by][b[1]] == 'O') {
                    return null;
                } else {
                    break;
                }
            }
            while (true) {
                int ry = r[0] + 1;
                if (ry < n && map[ry][r[1]] == '.') {
                    r[0] = ry;
                } else if (map[ry][r[1]] == 'O') {
                    check = true;
                    return null;
                } else {
                    break;
                }
            }

            if (b[0] == r[0] && b[1] == r[1]) {
                if (lineCheck) {
                    b[0]--;
                } else {
                    r[0]--;
                }
            }
            return this;
        }

        Bead left() {
            boolean lineCheck = b[1] < r[1];
            while (true) {
                int bx = b[1] - 1;
                if (bx >= 0 && map[b[0]][bx] == '.') {
                    b[1] = bx;
                } else if (map[b[0]][bx] == 'O') {
                    return null;
                } else {
                    break;
                }
            }

            while (true) {
                int rx = r[1] - 1;
                if (rx >= 0 && map[r[0]][rx] == '.') {
                    r[1] = rx;
                } else if (map[r[0]][rx] == 'O') {
                    check = true;
                    return null;
                } else {
                    break;
                }
            }

            if (b[0] == r[0] && b[1] == r[1]) {
                if (lineCheck) {
                    r[1]++;
                } else {
                    b[1]++;
                }
            }
            return this;

        }

    }


    static Bead init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int[] b = new int[2];
        int[] r = new int[2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);

                if (s.charAt(j) == 'B') {
                    b[0] = i;
                    b[1] = j;
                    map[i][j] = '.';
                } else if (s.charAt(j) == 'R') {
                    r[0] = i;
                    r[1] = j;
                    map[i][j] = '.';
                }
            }
        }

        return new Bead(b, r);
    }
}
