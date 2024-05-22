/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciitochar;

/**
 *
 * @author thomas.brady
 * Randomly select a lowercase number converting ASCII code to Character
 */
public class ASCIItoChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int RandInt = 97+ (int) ((Math.random() * (122 - 97)) + 1);
        char character = (char)RandInt;
        System.out.print(character + " ");
    }
    
}
