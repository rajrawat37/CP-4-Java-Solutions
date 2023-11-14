
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Vector<Integer>[] adj;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        sc.nextLine();

        boolean flag=true;

        StringBuilder res = new StringBuilder();

        while (t-- > 0) {
            int n = (sc.nextLine().charAt(0) - 'A') + 1;

            adj = new Vector[n + 1];
            vis = new boolean[n + 1];

            for (int i = 1; i <= n; i++)
                adj[i] = new Vector<>();


            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.equals("")) {
                    break;
                }
                int u = (s.charAt(0) - 'A') + 1;
                int v = (s.charAt(1) - 'A') + 1;

                adj[u].add(v);
                adj[v].add(u);
            }

            int components = 0;

            for (int i = 1; i <= n; i++) {
                if (!vis[i]) {
                    dfs(i);
                    components++;
                }
            }
            res.append(components).append("\n\n");
        }
        sc.close();
        res.deleteCharAt(res.length()-1);
        System.out.print(res.toString());
    }
    static void dfs(int node){
        vis[node]=true;

        for(int child:adj[node]) {
            if (!vis[child])
                dfs(child);
        }
    }
}
