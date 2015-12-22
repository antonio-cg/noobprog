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
 * Clase que se encarga de limpiar un archivo de texto
 * @author Antonio Caro
 * @author Erika Lizbeth Gomez Ramos
 * 
 */
public class Limpiar {
    
    
    /**
     * 
     * @param ruta Es la ruta de donde se encuentra del archivo a leer
     * @param guardado Ruta donde se guardara el archivo modificado y lmpio de comentarios y tabs
     */
    public static void LimpaTxt(String ruta,String guardado)
    {
      

        //Para guardar la linea
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
     * Elimina un comentario de una linea 
     * @param l Linea de entrada a la cual se le borraran comentario
     * @return 
     * 
     */
    public static String QuitarComentario(String l)
    {
        return l.replaceAll("\\.\\.\\..*", " ");
        
    }
    
    public static String QuitaTabs(String l)
    {
         return l.replaceAll("\\t", " ");
        //return l.replaceAll(" {2,}", " ");
    }
    
}
