package january;

import java.util.*;

class ProCalculationOfParkingFees {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for(String s : records){
            String[] car = s.split(" ");
            int minute = minute(car[0]);

            if(car[2].equals("IN")){
                in.put(Integer.parseInt(car[1]), minute);
            } else {
                int time = calTime(in.get(Integer.parseInt(car[1])), minute);
                out.put(Integer.parseInt(car[1]), out.getOrDefault(Integer.parseInt(car[1]), 0) + time);
                in.remove(Integer.parseInt(car[1]));
            }
        }

        for(Integer key : in.keySet()){
            int time = calTime(in.get(key), 1439);
            out.put(key, out.getOrDefault(key, 0) + time);
        }

        List<Integer> m = new ArrayList<>(out.keySet());
        Collections.sort(m);

        int[] answer = new int[m.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = calculate(fees, out.get(m.get(i)));
        }

        return answer;
    }

    public static int calTime(int in, int out){
        return out - in;
    }

    public static int calculate(int[] fees, int time){
        System.out.println(time);
        int money = fees[1];

        int notBase= time - fees[0];
        if (notBase <= 0){
            return money;
        }

        int tempTime = notBase / fees[2];
        if (notBase % fees[2] != 0){
            tempTime += 1;
        }

        return money + tempTime * fees[3];
    }


    public static int minute(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}
