package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15686 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n, m;
    public static List<Point> chicken = new ArrayList<>();
    public static List<Point> home = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        dfs(new ArrayList<>(), 0);
        System.out.println(answer);
    }


    public static void dfs(List<Point> temp, int i) {
        if (temp.size() == m) {
            operate(temp);
            return;
        }

        if (i == chicken.size()) {
            return;
        }

        temp.add(chicken.get(i));
        dfs(temp, i + 1);
        temp.remove(chicken.get(i));
        dfs(temp, i + 1);
    }

    public static void operate(List<Point> temp) {
        int tempAnswer = 0;
        for (Point i : home) {
            int tempDistance = Integer.MAX_VALUE;
            for (Point j : temp) {
                int tempY = Math.abs(i.y - j.y);
                int tempX = Math.abs(i.x - j.x);
                tempDistance = Math.min(tempDistance, tempX + tempY);
            }
            tempAnswer += tempDistance;
        }
        answer = Math.min(answer, tempAnswer);
    }




    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                if (p == 1) {
                    home.add(new Point(i, j));
                } else if (p == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

    }


    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
