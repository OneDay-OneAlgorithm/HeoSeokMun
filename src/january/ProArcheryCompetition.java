package january;

class ProArcheryCompetition {
    public static int[] gInfo;
    public static int totalArrow;
    public static int winSum = 0;
    public static int[] answer;
    public int[] solution(int n, int[] info) {
        gInfo = info;
        totalArrow = n;

        int[] temp = new int[11];

        dfs(0, n, temp);

        if (winSum == 0){
            return new int[]{-1};
        }
        return answer;
    }

    public static void dfs(int i, int arrow, int[] ryan){
        if(arrow == 0){
            sum(ryan);
            return;
        } else if(i == 10){
            ryan[i] += arrow;
            sum(ryan);
            ryan[i] -= arrow;
            return;
        }

        if(arrow - gInfo[i] - 1 >= 0){
            ryan[i] = gInfo[i] + 1;
            dfs(i + 1, arrow - ryan[i], ryan);
            ryan[i] = 0;
            dfs(i + 1, arrow, ryan);
        } else {
            dfs(i + 1, arrow, ryan);
        }

    }

    public static void sum(int[] ryan){
        int sumA = 0;
        int sumR = 0;
        int k = 10;
        for(int i=0;i<=10;i++){
            if (ryan[i] > gInfo[i]){
                sumR += k;
            } else {
                if(gInfo[i] !=0){
                    sumA += k;
                }
            }
            k--;
        }

        if(sumR > sumA){
            int temp = sumR - sumA;
            if(temp > winSum){
                winSum = temp;
                answer = ryan.clone();
            }
            else if(temp == winSum){
                for(int i = 10; i>=0 ; i--){
                    if(ryan[i] > answer[i]){
                        answer = ryan.clone();
                        return;
                    } else if(ryan[i] < answer[i]){
                        return;
                    }
                }
            }
        }
    }
}
