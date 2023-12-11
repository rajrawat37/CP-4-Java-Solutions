import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    static Vector<int[]>[] adj;

    static boolean[] vis;
    static int count;
    static long maxPPA;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));


        StringBuilder res=new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0) break;

            maxPPA = Long.MIN_VALUE;

            adj = new Vector[n + 1];
            vis = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                adj[i] = new Vector<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int ppa = Integer.parseInt(st.nextToken());

                adj[u].add(new int[]{v, ppa});
                adj[v].add(new int[]{u, ppa});
                maxPPA = Math.max(maxPPA, ppa);
            }

            int ans = 2;

            for (int i = 1; i <= n; i++) {
                if (!vis[i]) {
                    count = 0;
                    dfs(i);
                    ans = Math.max(ans, count);
                }
            }
            System.out.println(ans);
        }
    }

    static void dfs(int node) {

        vis[node] = true;
        count++;

        for (int []child : adj[node]) {
            if (child[1] == maxPPA && !vis[child[0]]) {
                dfs(child[0]);
            }
        }
    }
}
