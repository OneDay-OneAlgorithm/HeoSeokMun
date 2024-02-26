package february;

import java.util.*;

class ProFailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] remain = new int[N+1];
        int person = stages.length;

        Stage[] s = new Stage[N];

        for(int i=0;i<stages.length;i++){
            int now = stages[i];
            if(now > N){
                continue;
            }
            remain[now]++;
        }

        for(int i=0;i<N;i++){
            if (person == 0){
                s[i] = new Stage(i+1, 0);
                continue;
            }

            s[i] = new Stage(i+1, (double)remain[i+1] / person);
            person -= remain[i+1];
        }

        Arrays.sort(s);
        for(int i=0;i<answer.length;i++){
            answer[i] = s[i].index;
        }

        return answer;
    }

    public static class Stage implements Comparable<Stage>{
        int index;
        double fail;

        public Stage(int index, double fail){
            this.index = index;
            this.fail = fail;
        }

        @Override
        public int compareTo(Stage o){
            if(this.fail < o.fail){
                return 1;
            } else if (this.fail == o.fail){
                return this.index - o.index;
            }
            return -1;
        }
    }


}
