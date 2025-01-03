import java.util.*;
public class graph{
    static class edge{
        int source;
        int dest;
        int weight;
        public edge(int s, int d, int w){
            this.source=s;
            this.dest=d;
            this.weight=w;
        }
    }
    public static void creategraph(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new edge(0,1,10));  
        graph[0].add(new edge(0,2,15));  
        graph[0].add(new edge(0,3,30));  

        graph[1].add(new edge(1,0,10));  
        graph[1].add(new edge(1,3,40));  

        graph[2].add(new edge(2,0,15));  
        graph[2].add(new edge(2,3,50)); 

        graph[3].add(new edge(3,1,40));  
        graph[3].add(new edge(3,2,50));  

        // graph[4].add(new edge(4,1,-1));   
        // graph[4].add(new edge(4,5,5));  
        // graph[4].add(new edge(4,5,1)); 

        // graph[5].add(new edge(5,0,1));  
        // graph[5].add(new edge(5,2,1));  
        // graph[5].add(new edge(5,6,1)); 

        // graph[6].add(new edge(6,5,1));  


    }

    public static void bfs(ArrayList<edge>[] graph){
                boolean vis[]= new boolean[graph.length];
            for(int i=0;i<graph.length;i++){
                if(!vis[i]){
                    bfsutil(graph, vis);
                }
            }    

    }
    public static void bfsutil(ArrayList<edge>[] graph, boolean vis[]){ //O(n)
        Queue<Integer> q= new LinkedList<>();
        q.add(0);// source
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){ //to find neighbours of a node
                    edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        }

        public static void dfs(ArrayList<edge>[] graph){
        boolean vis[]= new boolean[graph.length];
          for(int i=0;i<graph.length;i++){
            dfsutil(graph, i, vis);
          }

        }
        public static void dfsutil(ArrayList<edge>[] graph, int curr, boolean vis[]){
            System.out.print(curr +" ");
            vis[curr]=true;

            for(int i=0;i<graph[curr].size();i++){
                edge e=graph[curr].get(i);
                if(!vis[e.dest]){
                    dfsutil(graph, e.dest, vis);
                }
            }
        }
        public static boolean haspath(ArrayList<edge>[] graph, int src, int dest, boolean vis[]){
            if(src==dest){
                return true;
            }
            vis[src]=true;
            for(int i=0;i<graph[src].size();i++){
                edge e = graph[src].get(i);
                if(!vis[e.dest] && haspath(graph, e.dest, dest, vis)){
                    return true;
                }
            }
            return false;
        }
        public static boolean detectcycle(ArrayList<edge>[] graph){
            boolean vis[]=new boolean[graph.length];
            for(int i=0;i<graph.length;i++){
                if(!vis[i]){
                    if(detectcycleutil(graph, vis, i, -1)){
                        return true;
                        //cycle exists in one of the part
                    }
                }
            }
            return false;

        }
        public static boolean detectcycleutil(ArrayList<edge>[] graph,boolean vis[], int curr,int par){// O(V+E) V=vertices, E=edges
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                edge e= graph[curr].get(i);
                if(!vis[curr] ){ // case-3
                    if(detectcycleutil(graph, vis, e.dest, curr)){
                    return true;

                }
            }
                else if(vis[e.dest] && e.dest!=par){
                    return true;
                }
            }
            return false;


        }
        public static boolean bipartite(ArrayList<edge> [] graph){ // O(V+E)
            int val[]= new int[graph.length];
            for(int i=0;i<val.length;i++){
                val[i]=-1;// intialize every val in array as -1
            }
            Queue<Integer> q= new LinkedList<>();
            for(int i=0;i<graph.length;i++){
                if(val[i]==-1){// BFS
                    q.add(i);
                    val[i]=0;
                    while(!q.isEmpty()){
                      int curr=  q.remove();
                      for(int j=0;j<graph[curr].size();j++){
                        edge e = graph[curr].get(j);// e.destination
                        //  case 1
                        if(val[e.dest]==-1){
                            int nexval=val[curr]==0?1:0;
                            val[e.dest]=nexval;
                            q.add(e.dest);
                        }
                        //case 2
                        else if(val[e.dest]==val[curr]){
                            return false;
                        }
                        

                      }
                    }

                }

            }
            return true;

        }
        public static boolean iscycleutil(ArrayList<edge> []graph,int curr, boolean vis[], boolean stack[]){
            vis[curr]=true;
            stack[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                edge e=graph[curr].get(i);
                if(stack[e.dest]){ // cycle
                    return true;

                }
                if(!vis[e.dest] && iscycleutil(graph, e.dest, vis, stack)){
                    return true;
                }
            }
            stack[curr]=false;
            return false;
        }

        public static boolean iscycle(ArrayList<edge> []graph){
            boolean vis[]=new boolean[graph.length];
            boolean stack[]=new boolean[graph.length];
            for(int i=0;i<graph.length;i++){
                if(!vis[i]){
                    iscycleutil(graph,i,vis,stack);
                    return true;
                }
            }
            return false;
        }

          public static void topoutil(ArrayList<edge> []graph,int curr, boolean vis[], Stack<Integer>s){
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                edge e= graph[curr].get(i);
                if(!vis[e.dest]){
                    topoutil(graph, e.dest, vis, s);
                }
            }
            s.push(curr);
          }
         public static void topo(ArrayList<edge> []graph){
            boolean vis[]= new boolean[graph.length];
            Stack<Integer> s= new Stack<>();
            for(int i=0;i<graph.length;i++){
                if(!vis[i]){
                    topoutil(graph,i,vis,s);
                }
            }
            while(!s.isEmpty()){
                System.out.println(s.pop()+" ");
            }
         }
         public static void calIndeg(ArrayList<edge>[] graph,int intdeg[]){
            for(int i=0;i<graph.length;i++){
                int v=i;
                for(int j=0;j<graph[v].size();j++){
                    edge e= graph[v].get(j);
                    intdeg[e.dest]++;
                }
            }

         }
         public static void topsortbfs(ArrayList<edge>[] graph){
            int indeg[]=new int[graph.length];
            calIndeg(graph, indeg);
              Queue<Integer> q=new LinkedList<>();
              for(int i=0;i<indeg.length;i++){
                if(indeg[i]==0){
                    q.add(i);
                }
              }
              //bfs
              while(!q.isEmpty()){
               int curr= q.remove();
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    edge e=graph[curr].get(i);
                    indeg[e.dest]--;
                    if(indeg[e.dest]==0){
                        q.add(e.dest);
                    }
                }
              }


         }

         public static void printpath(ArrayList<edge> graph[], int src, int dest, String path){
            if(src==dest){
                System.out.print(path+dest);
            }
            for(int i=0;i<graph[src].size();i++){
                edge e=graph[src].get(i);
                printpath(graph, e.dest, dest, path+src);
            }
         }
        static class pair implements Comparable<pair> {
            int n;
            int path;
        
            public pair(int n, int path) {
                this.n = n;
                this.path = path;
            }
        
            @Override
            public int compareTo(pair p2) {
                return this.path - p2.path;
            }
        }
        
        
        public static void bellmanford(ArrayList<edge> [] graph,int src){
            int dist[]=new int[graph.length];
            for(int i=0;i<graph.length;i++){// initialze every distance with infinity
                if(i!=src){
                    dist[i]=Integer.MAX_VALUE;
                }
            }
            int V=graph.length;// no of vertices
             for(int i=0;i<graph.length;i++){
                //edges
                for(int j=0;j<graph.length;j++){
                    for(int k=0;k<graph[j].size();k++){
                        edge e=graph[j].get(k);

                        int u=e.source;
                        int v=e.dest;
                        int wt=e.weight;
                        if(dist[u]+wt<dist[v] && dist[u]!=Integer.MAX_VALUE){
                            dist[v]=dist[u]+wt;
                        }
                    }
                }
             }
             for(int i=0;i<dist.length;i++){
                System.out.print(dist[i] +" ");
             }
             System.out.println();

        }
        
            public static void dijsktra(ArrayList<edge> graph[], int src) {
                int dist[] = new int[graph.length]; // dist[i] -> src to i
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[src] = 0;
        
                boolean vis[] = new boolean[graph.length];
                PriorityQueue<pair> pq = new PriorityQueue<>();
                pq.add(new pair(src, 0));
        
                while (!pq.isEmpty()) {
                    pair curr = pq.remove();
                    if (!vis[curr.n]) {
                        vis[curr.n] = true;
                        for (int i = 0; i < graph[curr.n].size(); i++) { // neighbours
                            edge e = graph[curr.n].get(i);
                            int u = e.source;
                            int v = e.dest;
                            int wt = e.weight;
                            if (!vis[v] && dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                                // update distance from src to v
                                dist[v] = dist[u] + wt;
                                pq.add(new pair(v, dist[v]));
                            }
                        }
                    }
                }
        
                // print all sources to vertices shortest distance
                for (int i = 0; i < dist.length; i++) {
                    System.out.print(dist[i] + " ");
                }
                System.out.println();
            }
            static class PAIR implements Comparable<PAIR>{
                int v;
                int cost;
                public PAIR(int v, int cost){
                    this.v=v;
                    this.cost=cost;
                }
                @Override
                public int compareTo(PAIR p2){
                    return this.cost-p2.cost;//ascending 
                }
            }
            public static void prims(ArrayList<edge> graph[]){
                boolean vis[]=new boolean[graph.length];
                PriorityQueue<PAIR> pq = new PriorityQueue<>();
                pq.add(new PAIR(0, 0));
                int finalcost=0;
                while(!pq.isEmpty()){
                    PAIR curr=pq.remove();
                    if(!vis[curr.v]){
                        vis[curr.v]=true;
                        finalcost+=curr.cost;
                        for(int i=0;i<graph[curr.v].size();i++){
                            edge e= graph[curr.v].get(i);
                            pq.add(new PAIR(e.dest, e.weight));
                        }
                    }
                }
                System.out.println("final cost "+finalcost);

            }

        
@SuppressWarnings ("unchecked")
    public static void main(String[] args) {
        int Vertices=5;
        ArrayList<edge>[] graph = new ArrayList[Vertices];
        creategraph(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[Vertices]);
// 
// topsortbfs(graph);        
// int src=5; 
// int src=0;
// dijsktra(graph, src);
// bellmanford(graph, 0);
     
    prims(graph);
}

        }