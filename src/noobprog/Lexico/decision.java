/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Lexico;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import noobprog.Sintactico.Sintactico;
import noobprog.Utils.Tokenizador;
import noobprog.Utils.tablaSimbolos;

/**
 *
 * @author antonio
 */
public class decision {
    
    public static boolean logico(String s)
    {
        
        try {
            String[] tokens = Tokenizador.tokenize(s);
            
            for(int i=0;i<tokens.length;i++)
            {
                System.out.println(tokens[i]);
                //si el string es un numero
                if(tokens[i].matches("-?\\d+(\\.\\d+)?"))
                {
                    Double parse = Double.parseDouble(tokens[i]);
                    tokens[i] = tablaSimbolos.getObj().insertaNum(parse);
                    
                    
                }else if(tokens[i].matches("\\w*") && !tokens[i].matches("and|or|V|F|\\!"))//es una palabra por lo cual buscamos si esta declarada
                {
                   
                    if(!tablaSimbolos.getObj().estaDeclarada(tokens[i]))
                    {
                        System.out.println("La variable " + tokens[i] + " no esta declarada");
                        return false;
                    }
                    else
                    {
                        //obtenemos el id de la variable
                        tokens[i]=tablaSimbolos.getObj().getId(tokens[i]);
                    }
                }
            }
             System.out.println("Como queda la tabla despues de cambiarlos por id");
        
            Sintactico e = new Sintactico();
      
//        for(int i=0;i<tokens.length;i++)//quitamos los id para dejarlos limpios
//        {
//            if(tokens[i].matches("id[0-9]*"))
//             {
//                tokens[i] = tokens[i].replaceAll("(id)[0-9]*", "$1");
//             }
//        }
        //aumentamos en 1 el tamaño del arreglo
        tokens = Arrays.copyOf(tokens, tokens.length + 1);
        tokens[tokens.length-1] = "$";//Agregamos el simbolo al ultimo
        
        return e.algoritmo(e.getGLogica(), e.getTlogica(), tokens);
            
        } catch (IOException ex) {
            Logger.getLogger(decision.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return false;
    }
}
