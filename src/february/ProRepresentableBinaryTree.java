package february;

class ProRepresentableBinaryTree {
    static int[] num = new int[] {1, 3, 7, 15, 31, 63};
    static int[] answer;

    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            answer[i] = 1;
        }


        int index = 0;
        for(long i : numbers){
            String s = Long.toBinaryString(i);
            for(int j=0;j<6; j++){
                if(num[j] >= s.length()){
                    int[] array = new int[num[j]];
                    int m = num[j] - s.length();
                    for(char k: s.toCharArray()){
                        array[m] = k - '0';
                        m++;
                    }

                    dfs(index, array, j, num[j]/2);
                    break;
                }
            }
            index++;
        }

        return answer;
    }

    public static void dfs(int index, int[] array, int j, int point){
        if(j == 0 || answer[index] == 0){
            return;
        }

        if(array[point] == 0 &&
                (array[point - (int)Math.pow(2, j -1)] == 1 || array[point + (int)Math.pow(2, j-1)] == 1)
        ){
            answer[index] = 0;
            return;
        }

        dfs(index, array, j - 1, point - (int) Math.pow(2, j - 1));
        dfs(index, array, j - 1, point + (int) Math.pow(2, j - 1));
    }

}
