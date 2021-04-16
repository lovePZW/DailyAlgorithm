import java.io.*;
import java.util.*;
import java.lang.*;

public class UnionSet {

    public static int N = 100010;
    public static int[] parent = new int[N];
    public static int size;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str  = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        size = n;
        while(m-- > 0){
            String[] strs = reader.readLine().split(" ");
            int a = Integer.parseInt(strs[1]);
            int b = Integer.parseInt(strs[2]);
            if(strs[0].equals("M")){
                union(a, b);
            }else{
                if(find(a) == find(b)){
                    writer.write("Yes\n");
                }else{
                    writer.write("No\n");
                }
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int find(int x){
        if(x != parent[x]){
            return find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
        }else{
            parent[rootX] = rootY;
            size--;
        }
    }
}
