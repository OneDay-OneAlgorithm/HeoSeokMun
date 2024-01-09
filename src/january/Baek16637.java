package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek16637 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        String s = init();
        dfs(s, 2);
        System.out.println(answer);
    }

    public static void dfs(String s, int i) {
        if (i > s.length() - 3) {
            operate(s);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, i)).append("(").append(s.substring(i, i + 3)).append(")").append(s.substring(i + 3));
        dfs(sb.toString(), i + 6);
        dfs(s, i + 2);
    }

    public static void operate(String temp) {
        Deque<Integer> digit = new ArrayDeque<>();
        Deque<Character> operation = new ArrayDeque<>();

        for (char i : temp.toCharArray()) {
            if (Character.isDigit(i)) {
                if (digit.isEmpty()) {
                    digit.add(i - '0');
                } else {
                    if (operation.getLast() == '(') {
                        digit.add(i - '0');
                    } else {
                        char op = operation.removeLast();
                        digit.add(op(digit.removeLast(), i - '0', op));
                    }
                }
            } else if (i == ')') {
                Integer b = digit.removeLast();
                Integer a = digit.removeLast();
                operation.removeLast();
                char o = operation.removeLast();
                digit.add(op(a, b, o));
            } else {
                operation.add(i);
            }
        }
        answer = Math.max(digit.removeLast(), answer);
    }


    public static int op(int a, int b, char o) {
        if (o == '+') {
            return a + b;
        } else if (o == '-') {
            return a - b;
        } else if (o == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }


    public static String init() throws IOException {
        n = Integer.parseInt(br.readLine());
        return br.readLine();
    }
}
