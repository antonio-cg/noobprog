/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author antoniocg
 */
public class comentario {
    
    public static void LimpaTxt(String ruta,String guardado)
    {
      

        // This will reference one line at a time
        String line = null;

        try {
            FileWriter fileWriter = new FileWriter(guardado);
            //Leemos el archivo 
            FileReader fileReader = new FileReader(ruta);

           
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           //leer linea por linea
            
            while((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                line=QuitarComentario(line);
                line=QuitaTabs(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                System.out.println(line);
            }    

            // Cerramos
            bufferedReader.close();         
            bufferedWriter.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
               ruta + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + ruta + "'");                   
            
        }
    }
    
    
    /**
     * 
     * @param l Linea de entrada a la cual se le borraran comentario
     * @return 
     * 
     */
    public static String QuitarComentario(String l)
    {
        if(l.matches(".*\".*\".*"))
        {
            System.out.println("en el metodo: "+l);
            return l.replaceAll("(.*[(?]\\s*\".*|\\s*\"[)?])[\\.{3}.*]?", "$1");
        }
        else
        {
       
           return l.replaceAll("[\\.\\.\\.].*", " ");
        }
        
        
    }
    
    public static String QuitaTabs(String l)
    {
         return l.replaceAll("\\t", " ");
       
    }
    
}
