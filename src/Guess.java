import java.io.*;
import java.util.*;
import java.lang.*;

public class Guess{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0){

            int L = scanner.nextInt();
            int M = scanner.nextInt();
            scanner.nextLine();

            int l_left = 1;
            int r_left = 1;
            int l_right = L;
            int r_right = L;

            boolean honest = false;

            while(l_left < l_right){
                int mid = l_left + (l_right - l_left) / 2;
                System.out.println("Query " + mid);
                int res = Integer.parseInt(scanner.nextLine());
                if(res == 0){
                    l_right = mid;
                    r_left = Math.max(r_left, mid);
                    honest = true;
                }else if(res == 1){
                    l_right = mid - 1;
                    r_right = Math.min(r_right, mid - 1);
                }else{
                    l_left = mid + 1;
                    r_left = Math.max(r_left, mid + 1);
                }
            }

            if(l_left != l_right){
                System.out.println("Answer -1 -1");
                break;
            }

            if(!honest){
                System.out.println("Query " + l_left);
                int res = Integer.parseInt(scanner.nextLine());
                if(res == 0){
                    r_left = Math.max(r_left, l_left);
                    honest = true;
                }else{
                    System.out.println("Answer -1 -1");
                    break;
                }
            }

            while(r_left < r_right){
                int mid = r_left + (r_right - r_left + 1) / 2;
                System.out.println("Query " + mid);
                int res = Integer.parseInt(scanner.nextLine());
                if(res == 0){
                    r_left = mid;
                }else if(res == 1){
                    r_right = mid - 1;
                }else{
                    r_left = mid + 1;
                }
            }
            System.out.println("Answer" + l_left + " " + r_left);
        }
        scanner.close();
    }
}