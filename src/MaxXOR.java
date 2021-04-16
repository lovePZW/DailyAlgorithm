import java.io.*;
import java.util.*;
import java.lang.*;

public class MaxXOR {

    public static int N = 100010;
    public static int[][] son = new int[31 * N][2];
    public static int index = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] str = reader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(str[i]);
        }

        for(int i = 0; i < n; i++){
            insert(nums[i]);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, search(nums[i]));
        }

        writer.write(max + "");
        writer.flush();
        writer.close();
        reader.close();


    }

    public static void insert(int x){
        int p = 0;
        for(int i = 30; i >= 0; i--){
            int u = (x >>> i) & 1;
            if(son[p][u] == 0){
                son[p][u] = ++index;
            }
            p = son[p][u];
        }
    }

    public static int search(int x){
        int p = 0;
        int res = 0;
        for(int i = 30; i >= 0; i--){
            int u = (x >>> i) & 1;
            if(son[p][1 ^ u] == 0){
                res = res * 2;
            }else{
                res = res * 2 + 1;
            }
            p = son[p][u];
        }
        return res;
    }
}
