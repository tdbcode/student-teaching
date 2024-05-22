/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

/**
 *
 * @author thomas.brady
 */

import java.util.Scanner;
import java.util.Stack;

public class Stacks {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  
        System.out.println("Enter a word to reverse:");
        String word = reader.nextLine();
        Stack<String> letters = new Stack<>();

        for(int x=0; x < word.length(); x++){
            letters.push(Character.toString(word.charAt(x)));
    }
int s = letters.size();
       for(int y=0; y < s; y++){
       
        System.out.print(letters.pop());
            System.out.println(y);
       }
    }
    
}
