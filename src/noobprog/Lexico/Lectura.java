/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Lexico;

import noobprog.Utils.asmWriter;
import noobprog.Utils.tablaSimbolos;

/**
 *
 * @author antoniocg
 */
public class Lectura {
    
    
    public static void leer(String s)
    {
        String variable = s.split("=")[0].trim();
        System.out.println("VIENDO SI ESTA LA VARIABLE "+variable);
        if(tablaSimbolos.getObj().estaDeclarada(variable))
        {
            if(tablaSimbolos.getObj().getTipo(variable).equals("num"))
            {
                  String id = tablaSimbolos.getObj().getId(variable);
                  System.out.println("LEYENDO OK  GUARDANDO EN LA VARIABLE "+id);
                  asmWriter.getObj().addCode("LEA AX,"+id);
                  asmWriter.getObj().addCode("PUSH AX");
                           
                           
                           asmWriter.getObj().addCode("CALL _leer");
                           asmWriter.getObj().addCode("MOV AX,2");
                           asmWriter.getObj().addCode("ADD SP,AX");
            }
            else
            {
             System.out.println("ERROOOR por el momento solo leo numero");
            
            }
            
        }
        else
        {
            System.out.println("ERRORRR VARIABLE DE LECTURA NO DECLARADA");
        }
        
           
    }
}
