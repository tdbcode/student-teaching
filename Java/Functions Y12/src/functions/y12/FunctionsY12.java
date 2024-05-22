/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions.y12;

/**
 *
 * @author thomas.brady
 */
public class FunctionsY12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        int answer = addfunc(4,2) * addfunc(1,3);
        System.out.println(answer);
        
        
        addproc(4,2);
        addproc(4,3);
        addproc(5,6);
    }
    
    //Return Method
    private static int addfunc(int x, int y){
        return x + y;
    }
    
    //Void Method
    private static void addproc(int x, int y){
        int answer = x + y;
        System.out.println(answer);
    }
    
}
