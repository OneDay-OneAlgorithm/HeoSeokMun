package january;

import java.util.*;

class ProDonutsAndBarGraphs {
    static List<List<Integer>> graph;
    static int[] answer = new int[]{0, 0, 0, 0};
    static int max = 0;

    public int[] solution(int[][] edges) {
        for(int[] i : edges){
            max = Math.max(max, i[0]);
            max = Math.max(max, i[1]);
        }

        graph = new ArrayList<>();
        for(int i=0;i<=max;i++){
            graph.add(new ArrayList<>());
        }

        int[] visited = new int[max + 1];


        for(int[] i : edges){
            graph.get(i[0]).add(i[1]);
        }

        int index = 1;
        for(int i=1; i<=max;i++){
            if(visited[i] == 0){
                bfs(i, visited, index++);
            }
        }

        return answer;
    }

    public static void bfs(int start, int[] visited, int index){
        boolean hasMulti = graph.get(start).size() >=2;
        boolean root = true;
        int edge = 0;
        int node = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        if(hasMulti){
            int[] clone = visited.clone();
            while(deque.size() != 0){
                int size = deque.size();
                for(int i=0;i<size;i++){
                    int c = deque.remove();
                    clone[c]=index;
                    node++;
                    edge += graph.get(c).size();
                    for(int j : graph.get(c)){
                        if(j == start){
                            root = false;
                        }
                        if(clone[j] == 0){
                            deque.add(j);
                        }
                    }
                }
            }
            if(root){
                answer[0] = start;
            } else{
                answer[3] ++;
                for(int i=1;i<clone.length;i++){
                    if(clone[i] == index){
                        visited[i] = index;
                    }
                }
            }
            //System.out.println(start + ": " + edge +" " + node);
        } else{
            boolean is8 = false;
            boolean isStick = false;
            while(deque.size() != 0){
                int size = deque.size();
                for(int i=0;i<size;i++){
                    int c = deque.remove();
                    visited[c]=index;
                    node++;
                    int count = graph.get(c).size();
                    if(count == 2){
                        is8 = true;
                    }
                    edge += count;
                    for(int j : graph.get(c)){
                        if(visited[j] == 0){
                            deque.add(j);
                        } else if(visited[j] != index){
                            isStick = true;
                        }
                    }
                }
            }
            if (is8){
                answer[3]++;
            } else if(edge == node && !isStick){
                answer[1]++;
            } else if(edge + 1 == node) {
                answer[2]++;
            }
        }
    }
}
