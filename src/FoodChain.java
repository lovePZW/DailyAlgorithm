import java.io.*;
import java.util.*;
import java.lang.*;

public class FoodChain {

    public static int N = 50010;
    public static int[] parent = new int[N];
    public static int[] deep = new int[N];


    public static void main(String[] args) throws IOException{
        int a = (-3) % 3;
        System.out.println(a);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int lie = 0;

        while(k-- > 0){
            String[] strs = reader.readLine().split(" ");
            int D = Integer.parseInt(strs[0]);
            int X = Integer.parseInt(strs[1]);
            int Y = Integer.parseInt(strs[2]);
            if(X > n || Y > n){
                lie++;
                continue;
            }

            if(D == 1){
                if(find(X) == find(Y) && ((deep[X] - deep[Y]) != 0)){
                    lie++;
                    continue;
                }else if(find(X) != find(Y)){
                    parent[find(X)] = find(Y);
                    deep[find(X)] = deep[Y] - deep[X];
                }
            }else{
                if(X == Y){
                    lie++;
                    continue;
                }
                if(find(X) == find(Y) && (deep[X] - deep[Y] - 1) % 3 != 0){
                    lie++;
                    continue;
                }else{
                    parent[find(X)] = find(Y);
                    deep[find(X)] = deep[Y] + 1 - deep[X];
                }

            }
        }

        writer.write(lie + "");
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int find(int x){
        if(x != parent[x]){
            int u = find(parent[x]);
            deep[x] += deep[parent[x]];
            parent[x] = u;
        }
        return parent[x];
    }
}
