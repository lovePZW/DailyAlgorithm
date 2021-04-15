import java.io.*;
import java.util.*;
import java.lang.*;

public class Trie {

    public static int N = 1000010;
    public static int[][] son = new int[N][26];
    public static int[] count = new int[N];
    public static int index = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        while(n-- > 0){
            String[] str = reader.readLine().split(" ");
            if(str[0].equals("I")){
                insert(str[1]);
            }else{
                writer.write(query(str[1]) + "\n");
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    public static void insert(String s){
        if(s == null || s.equals("")) return;;
        int p = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(son[p][ch - 'a'] == 0){
                son[p][ch - 'a'] = ++index;
            }
            p = son[p][ch - 'a'];
        }
        count[p]++;
    }

    public static int query(String s){
        if(s == null || s.equals("")) return 0;
        int p = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(son[p][ch - 'a'] == 0){
                return 0;
            }
            p = son[p][ch - 'a'];
        }
        return count[p];
    }
}
