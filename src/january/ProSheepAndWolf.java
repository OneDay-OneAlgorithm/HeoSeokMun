package january;

import java.util.ArrayList;
import java.util.List;

class ProSheepAndWolf {
    static final int SHEEP = 0;
    static final int WOLF = 1;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] gInfo;
    static int answer = 1;

    public int solution(int[] info, int[][] edges) {
        gInfo = info;

        for(int i = 0; i<info.length;i++){
            list.add(new ArrayList<>());
        }

        for(int[] e : edges){
            list.get(e[0]).add(e[1]);
        }

        int[] canGo = new int[info.length];
        dfs(0, 1, 0, canGo);

        return answer;
    }

    public static void dfs(int next, int sheep, int wolf, int[] canGo){
        for(int i : list.get(next)){
            canGo[i] = 1;
        }

        for(int i=0;i<canGo.length;i++){
            if(canGo[i] == 1){
                if(gInfo[i] == 0){
                    canGo[i] = 0;
                    answer = Math.max(answer, sheep + 1);
                    dfs(i, sheep + 1, wolf, canGo);
                    canGo[i] = 1;

                } else{
                    if(sheep - wolf > 1){
                        canGo[i] = 0;
                        dfs(i, sheep, wolf + 1, canGo);
                        canGo[i] = 1;
                    }
                }
            }
        }

        for (int i : list.get(next)) {
            canGo[i] = 0;
        }
    }
}
