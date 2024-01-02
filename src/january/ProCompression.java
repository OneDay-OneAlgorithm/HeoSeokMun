package january;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProCompression {
    public static Map<String, Integer> map = new HashMap<>();

    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        init();

        String temp = "";
        for (int i = 0; i < msg.length(); i++) {
            if (map.get(temp + msg.charAt(i)) != null) {
                temp = temp + msg.charAt(i);
                continue;
            }

            map.put(temp + msg.charAt(i), map.size() + 1);
            answer.add(map.get(temp));
            i--;
            temp = "";
        }

        answer.add(map.get(temp));


        return answer;
    }

    public static void init() {
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), map.size() + 1);
        }
    }

}
