package FindingConnectedComponents;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class wheresmyinternet {
    static Vector<Integer> []adj;
    static boolean []vis;
    static int n,m;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        adj=new Vector[n+1];
        vis=new boolean[n+1];

        for(int i=1;i<=n;i++)
            adj[i]=new Vector<>();

        for(int i=1;i<=m;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);

        StringBuilder res=new StringBuilder();
        for(int i=1;i<=n;i++){
            if(!vis[i])
                res.append(i).append("\n");
        }

        if(res.length()==0)
            System.out.println("Connected");


        System.out.print(res);
    }
    static void dfs(int node){
        vis[node]=true;

        if(adj[node].isEmpty()) return;

        for(int child: adj[node]) {
            if (!vis[child])
                dfs(child);
        }
    }
}
