
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 * @author voxmi
 */
public class BigSorting {
    
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
            Arrays.sort(unsorted,new Comparator<String>() {
            @Override
            public int compare(String a, String b) 
            {
                return StringComp(a,b);
            }
        });
        StringBuilder phu = new StringBuilder("");
        for(String c: unsorted){
            phu.append(c+"\n");
        }
         System.out.println(phu);
    }
        static int StringComp(String s, String s1){
            if(s.length() > s1.length()){
                return 1;
            }
            if(s.length() < s1.length()){
                return -1;
            }
            for(int i = 0; i < s.length(); i++){
                if((int)s.charAt(i) > (int)s1.charAt(i)){
                return 1;
                }
            if((int)s.charAt(i) < (int)s1.charAt(i)){
                return -1;
                }
            }
            return 0;
        }
}
