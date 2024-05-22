/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileloadery12;

import java.io.*;

/**
 *
 * @author thomas.brady
 */
public class FileLoaderY12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try{
      FileReader fr = new FileReader("FileLoaderY12\\src\\fileloadery12\\hello.txt");
      
      BufferedReader br = new BufferedReader(fr);
      
      String line = br.readLine();
      
      String[] tempstringarray = line.split(", ");
      int[] intarr = new int[tempstringarray.length];
      
      for (int i=0; i< tempstringarray.length; i++){
          intarr[i] = Integer.parseInt(tempstringarray[i]);
      }
     
      for (int i=0; i< tempstringarray.length; i++){
          System.out.println(intarr[i]);
      }
      
    }
    catch(IOException ex){
        System.out.println("File loading error.");
    }
}
}
