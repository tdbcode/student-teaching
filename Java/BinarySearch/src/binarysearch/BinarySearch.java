/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Scanner;

/**
 *
 * @author thomas.brady
 * Simple binary search with parallel arrays
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        int[] ID = {1001,1002,1050,1100,1120,1180,1200,1400};
        String[] name = {"Apple","Cheery","Peach","Banana","fig","grape","olive","Mango"};
        
        int target = inputText.nextInt();
        int low = 0;
        int high = 7;
        int found = -1;
        int mid;
        
        while ((found == -1) && (low <= high)){
            mid = (low + high) / 2;
            if (ID[mid] == target){
                found = mid;
            }
            else if (target < ID[mid]){
                high = mid-1;   
            }
            else{
                low = mid + 1;
            }
        }
                
        if (found>0){
            System.out.println(target + ", " + name[found]);
        }
        else{
            System.out.println(target + " was not found");
        }
        
}
}
