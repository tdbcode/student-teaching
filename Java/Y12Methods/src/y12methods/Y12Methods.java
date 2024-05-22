/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y12methods;

/**
 *
 * @author thomas.brady
 */
public class Y12Methods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int calc = addNumb(6,6) * addNumb(5,3);
      System.out.println(calc);
    }
    
    
    public static int addNumb(int x, int y){
        int ans = x + y;
        
        return ans;
    }
    
}
