import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge
{
    int src,dst,w;
    public Edge(int s,int d,int w)
    {
        src = s;
        dst = d;
        this.w = w;
    }
}
class Graph
{
        int V;
        ArrayList<ArrayList<Edge>> list;
    public Graph(int V)
    {
        this.V = V;
        list = new ArrayList<>();
        for(int i=0;i<V;i++)
            list.add(new ArrayList<Edge>());
    }
    public void addEdge(int s,int d,int w)
    {
        list.get(s-1).add(new Edge(s-1,d-1,w));
    }
    public int findmin(int[] dis,boolean[] vis)
    {
        int min=Integer.MAX_VALUE,mi=0;
        for(int i=0;i<V;i++)
        {
            if(!vis[i] && dis[i]<=min)
            {
                min = dis[i];
                mi = i;
            }
        }
        return mi;
    }
    public void shortestDistance()
    {
        int result = 0;
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        for(int i=0;i<V;i++)
        {
            distance[i] = 1000000000;
        }
        distance[0] = 0;
        // visited[0] = true;
        for(int i=0;i<V-1;i++)
        {
            result = findmin(distance,visited);
            visited[result] = true;
            for(int j=0;j<list.get(result).size();j++)
            {
                Edge e1 = list.get(result).get(j);
                if(!visited[e1.dst] && 
                distance[e1.dst] > distance[result] + 
                e1.w)
                    distance[e1.dst] = distance[result] + e1.w;
            }
        }
        for(int i=1;i<V;i++)
            System.out.print(distance[i]+" ");
    }
}
class TestClass {
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s1 = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            Graph g = new Graph(n);
            for(int i=0;i<m;i++)
            {
                String s3 = br.readLine();
                if(s3 != null && s3.length() > 0) {
                    String[] s2 = s3.trim().split("\\s+");
                    int s = Integer.parseInt(s2[0]);
                    int d = Integer.parseInt(s2[1]);
                    int w = Integer.parseInt(s2[2]);
                    g.addEdge(s,d,w);
                }
            }
            
        g.shortestDistance();   
    }
}
