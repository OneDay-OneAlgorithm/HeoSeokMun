package february;

class ProWordConversion {
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];

        dfs(0, begin, target, words, visited);

        if (answer == Integer.MAX_VALUE){
            return 0;
        }
        return answer;
    }

    static void dfs(int n, String current, String target, String[] words, boolean[] visited){
        if(target.equals(current)){
            answer = Math.min(answer, n);
            return;
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i]){
                continue;
            }

            String s = words[i];

            int sum = 0;
            for(int j=0;j<s.length();j++){
                if(current.charAt(j) != s.charAt(j)){
                    sum++;
                }
            }

            if (sum == 1){
                visited[i] = true;
                dfs(n+1, s, target, words, visited);
                visited[i] = false;
            }
        }
    }
}
