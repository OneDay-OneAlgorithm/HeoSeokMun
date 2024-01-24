package january;

import java.util.*;

class ProPickingTheDice {
    static int count;
    static int[][] d;
    static int[] answer;
    static int max = 0;
    static int current=0;

    public int[] solution(int[][] dice) {
        count = dice.length;
        d = dice;
        answer = new int[count/2];
        int[] list = new int[count / 2];
        choose(0, list, 0);

        return answer;

    }

    public static void choose(int index, int[] list, int n){
        if(n == count / 2){
            calculate(list);
            return;
        } else if(index == count){
            return;
        }

        list[n] = index;
        choose(index + 1, list, n + 1);
        choose(index + 1, list, n);
    }

    public static void calculate(int[] list){
        List<Integer> my = new ArrayList<>();
        List<Integer> you = new ArrayList<>();

        int[] youList = new int[list.length];

        int index=0;
        for(int i=0;i<count;i++){
            boolean check = false;
            for(int j: list){
                if(j == i){
                    check = true;
                }
            }

            if(!check){
                youList[index++]=i;
            }
        }

        sum(0, 0, 0, my, list);
        sum(0, 0, 0, you, youList);

        Collections.sort(my);
        Collections.sort(you);

        int win=0;
        int j=-1;
        for(int i=0;i<my.size(); i++){
            for(;j<you.size() - 1;){
                if(my.get(i) > you.get(j + 1)){
                    j++;
                } else{
                    //System.out.println(j+1);
                    win+=j+1;
                    break;
                }
            }

            if(j == you.size() - 1){
                win+= you.size();
            }
        }


        if (max < win){
            max = win;
            for(int i=0; i<list.length;i++){
                answer[i] = list[i]+1;
            }
        }
    }

    public static void sum(int sum, int i, int j, List<Integer> t, int[] list){
        if(i == list.length){
            t.add(sum);
            return;
        }
        sum(sum + d[list[i]][j], i+1, 0, t, list);

        if(j < 5){
            sum(sum, i, j+1, t, list);
        }
    }

}
