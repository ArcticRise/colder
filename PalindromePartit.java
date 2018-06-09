/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author voxmi
 */
public class PalindromePartit {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int m = minCut(s);
        System.out.println(m);
        
    }
     public static int minCut(String s) {
        char[] a = s.toCharArray();
        int[] bold = new int[a.length];
        boolean[][] checker = new boolean[a.length][a.length];            
            for(int i = 0; i < a.length; i++){
                int cut = i;
                for(int j = 0; j <= i; j++){
                    if(a[j] == a[i] && (j+1 > i-1 || checker[j+1][i-1])){
                        checker[j][i] = true;
                        cut = j == 0 ? 0 : Math.min(cut, bold[j-1] + 1);
                    }
                }
                bold[i] = cut;
            }
        return bold[a.length-1];
    }
}

