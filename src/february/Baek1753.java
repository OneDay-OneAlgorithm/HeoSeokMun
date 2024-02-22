import java.util.*;
import java.io.*;

public class Baek1753 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int v, e;
    static List<List<Edge>> graph;
    static int[] visited;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        visited = new int[v + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for(int i=1;i<=e;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        solution(n);

        for(int i=1;i<=v;i++){
            if(visited[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else {
                System.out.println(visited[i]);
            }
        }
    }

    public static void solution(int i){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        visited[i] = 0;
        pq.offer(new Edge(i, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int now = e.v;
            int nowCost = e.w;

            if(visited[e.v] < nowCost) continue;
            for(Edge ob : graph.get(now)){
                if(visited[ob.v] > nowCost + ob.w){
                    visited[ob.v] = nowCost + ob.w;
                    pq.offer(new Edge(ob.v, nowCost + ob.w));
                }
            }
        }
    }


    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return this.w - o.w;
        }
    }
}