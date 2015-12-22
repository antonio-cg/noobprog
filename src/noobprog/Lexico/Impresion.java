/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Lexico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import noobprog.Utils.asmWriter;
import noobprog.Utils.simbolo;
import noobprog.Utils.tablaSimbolos;

/**
 *
 * @author antoniocg
 */
public class Impresion {
    
    
    public static boolean esImpresion(String s)
    {
        return s.matches("^muestra(.*)");
    }
    
    public static boolean esImpresionString(String s)
    {
        return s.matches("^muestra(\".*)");
    }
    
    public static void imprimeString(String s)
    {
   
        Pattern pattern = Pattern.compile("\".*?(?<!\\\\)(\")");;
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            //sacamos el string 
            String var = "id"+tablaSimbolos.getObj().getNextId();
            tablaSimbolos.getObj().insertaSimbolo(var,"String",matcher.group(0));
            //añadimos el codigo a ensamblador
            asmWriter.getObj().addCode("LEA AX,"+var);
            asmWriter.getObj().addCode("PUSH AX");
            asmWriter.getObj().addCode("CALL _impString");//ESPERO SIRVA
            asmWriter.getObj().addCode("MOV AX,2");
            asmWriter.getObj().addCode("ADD SP,AX");
               
        }
    }
    
    public static void imprimeVar(String nombreVar)
    {
       Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(nombreVar);

        if(matcher.find()) {
            //sacamos el string 
            
            
            if(tablaSimbolos.getObj().estaDeclarada(matcher.group(1)))
            {
                String  id =tablaSimbolos.getObj().getId(matcher.group(1));
                String sim =  tablaSimbolos.getObj().getTipoById(id);
            //añadimos el codigo a ensamblador
            asmWriter.getObj().addCode("LEA AX,"+id);
            asmWriter.getObj().addCode("PUSH AX");
            if(sim != null && sim.equals("num"))
            {
            asmWriter.getObj().addCode("CALL _impNumero");//ESPERO SIRVA
            }
            else
            {
                asmWriter.getObj().addCode("CALL _impString");
            }
            
            asmWriter.getObj().addCode("MOV AX,2");
            asmWriter.getObj().addCode("ADD SP,AX");            }else
            {
                System.out.println("La variable " + matcher.group(1) + " no esta declarada y no se puede imprimir" );
            }
      }
            
    }
}
